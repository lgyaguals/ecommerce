package ec.edu.ups.ecommerce.repositories;



import org.springframework.data.jpa.repository.JpaRepository;


import ec.edu.ups.ecommerce.entities.PerfilUsuario;

public interface RepositorioPerfil extends  JpaRepository<PerfilUsuario, Long> {
	
	

}
