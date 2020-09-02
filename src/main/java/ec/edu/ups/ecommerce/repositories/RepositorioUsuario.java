package ec.edu.ups.ecommerce.repositories;
import ec.edu.ups.ecommerce.entities.Usuario;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Long> {
	
	@Query("FROM Usuario WHERE email = ?1 OR username = ?1")
	Optional<Usuario> findByUsername(String username);
    Boolean existsByUsername(String username);
    Boolean existsByEmail(String email);
  
    
    

}
