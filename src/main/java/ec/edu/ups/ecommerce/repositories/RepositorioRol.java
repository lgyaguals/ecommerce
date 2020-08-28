package ec.edu.ups.ecommerce.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ec.edu.ups.ecommerce.entities.ERol;
import ec.edu.ups.ecommerce.entities.Rol;

@Repository
public interface RepositorioRol extends JpaRepository<Rol, Long> {
	
	@Query("FROM Rol WHERE nombre = ?1")
	Optional<Rol> findByName(ERol rol);
	
	
}
