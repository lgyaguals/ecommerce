package ec.edu.ups.ecommerce.rest_controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ec.edu.ups.ecommerce.services.services.UserPrincipal;

import ec.edu.ups.ecommerce.entities.ERol;
import ec.edu.ups.ecommerce.entities.ETipoDocumento;
import ec.edu.ups.ecommerce.entities.PerfilUsuario;
import ec.edu.ups.ecommerce.entities.Rol;
import ec.edu.ups.ecommerce.entities.Usuario;
import ec.edu.ups.ecommerce.message.request.LoginForm;
import ec.edu.ups.ecommerce.message.request.SignUpForm;
import ec.edu.ups.ecommerce.message.response.JwtResponse;
import ec.edu.ups.ecommerce.repositories.RepositorioPerfil;
import ec.edu.ups.ecommerce.repositories.RepositorioRol;
import ec.edu.ups.ecommerce.repositories.RepositorioUsuario;
import ec.edu.ups.ecommerce.services.jwt.JwtProvider;


@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/auth")
public class AuthRestAPIs {

	@Autowired
	AuthenticationManager authenticationManager;

	@Autowired
	RepositorioUsuario userRepository;
	@Autowired
	RepositorioPerfil profileRepository;

	@Autowired
	RepositorioRol roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	JwtProvider jwtProvider;

	@PostMapping("/signin")
	public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginForm loginRequest) {

		Authentication authentication = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(loginRequest.getUsername(),loginRequest.getPassword()));

		SecurityContextHolder.getContext().setAuthentication(authentication);

		String jwt = jwtProvider.generateJwtToken(authentication);
		UserPrincipal userDetails = (UserPrincipal) authentication.getPrincipal();
		List<String> roles = userDetails.getAuthorities().stream()
				.map(item -> item.getAuthority())
				.collect(Collectors.toList());
		
		return ResponseEntity.ok(new JwtResponse(jwt,
				userDetails.getName(), 
				 userDetails.getEmail(), 
				 roles));
	}

	@PostMapping("/signup")
	public ResponseEntity<String> registerUser(@Valid @RequestBody SignUpForm signUpRequest) {
		if (userRepository.existsByUsername(signUpRequest.getUsername())) {
			return new ResponseEntity<String>("{\"message\":{\"type\":\"warning\", \"content\": \"El usuario ya está registrado. Por favor ingrese un usuario diferente \"}}", HttpStatus.BAD_REQUEST);
		}

		if (userRepository.existsByEmail(signUpRequest.getEmail())) {
			return new ResponseEntity<String>("{\"message\":{\"type\":\"warning\", \"content\": \"El email ya está registrado.\"}}", HttpStatus.BAD_REQUEST);
		}

		// Creating user's account
		Usuario user = new Usuario();
		user.setUserName(signUpRequest.getUsername());
		user.setPassword(encoder.encode(signUpRequest.getPassword()));
		user.setEmail(signUpRequest.getEmail());
		Set<Rol> roles = new HashSet<>();
		if (signUpRequest.getProvider()) {
			Rol rol = roleRepository.findByName(ERol.ROLE_PROVIDER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(rol);
		} else {
			Rol rol = roleRepository.findByName(ERol.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Fail! -> Cause: User Role not find."));
			roles.add(rol);
		}

		user.setRoles(roles);
		Usuario persistUser = userRepository.save(user);
		PerfilUsuario perfil = new PerfilUsuario();
		perfil.setUsuario(persistUser);
		perfil.setNombre(signUpRequest.getFirstName());
		perfil.setApellido(signUpRequest.getLastName());
		perfil.setDocumento(signUpRequest.getDocument());

		switch (signUpRequest.getDocumentType()) {
		case "2":
			perfil.setTipoDocumento(ETipoDocumento.Pasaporte);
			break;
		case "3":
			perfil.setTipoDocumento(ETipoDocumento.RUC);
			break;

		default:
			perfil.setTipoDocumento(ETipoDocumento.Cédula);
			break;
		}
		profileRepository.save(perfil);

		return ResponseEntity.ok("{\"message\":{\"type\":\"success\", \"content\": \"Registro exitoso, ahora inicie sesión\"}}");
	}
}