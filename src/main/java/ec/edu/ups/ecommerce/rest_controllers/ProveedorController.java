package ec.edu.ups.ecommerce.rest_controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.ecommerce.entities.Proveedor;
import ec.edu.ups.ecommerce.repositories.RepositorioProveedor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ProveedorController {

	@Autowired
	RepositorioProveedor repositorProveedor;

	@GetMapping("/proveedores")
	List<Object> listarProveedor() {

		return repositorProveedor.getProveedores();

	}
	
	@GetMapping("/proveedores/{id}")
	Object obtenerProveedor( @PathVariable Long id) {

		return repositorProveedor.getProveedor(id);

	}
	
	@PostMapping("/proveedores/{id}")
	public ResponseEntity<String> actualizarProveedor(@PathVariable Long id, @RequestBody String commision) {
			Optional<Proveedor> p = repositorProveedor.findById(id);
			if(!p.isPresent()) {
				 return new ResponseEntity<String>("{\"message\":{\"type\":\"error\", \"content\": \"Ha ocurrido un error\"}}", HttpStatus.BAD_REQUEST);
			}else {
				p.get().setComision(Float.parseFloat(commision));
				repositorProveedor.save(p.get());
				 return ResponseEntity.ok("{\"message\":{\"type\":\"success\", \"content\": \"Actualización exitosa\"}}");
			}
		
			
		
	}
	

}
