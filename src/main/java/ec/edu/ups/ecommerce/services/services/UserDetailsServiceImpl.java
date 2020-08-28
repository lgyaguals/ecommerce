package ec.edu.ups.ecommerce.services.services;


import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import ec.edu.ups.ecommerce.entities.Usuario;
import ec.edu.ups.ecommerce.repositories.RepositorioUsuario;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    RepositorioUsuario userRepository;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String username)
            throws UsernameNotFoundException {
    	
        Usuario user = userRepository.findByUsername(username)
                	.orElseThrow(() -> 
                        new UsernameNotFoundException("User Not Found with -> username or email : " + username)
        );

        return UserPrincipal.build(user);
    }
}