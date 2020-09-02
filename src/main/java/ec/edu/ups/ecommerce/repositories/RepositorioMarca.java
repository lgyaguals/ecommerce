package ec.edu.ups.ecommerce.repositories;



import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import ec.edu.ups.ecommerce.entities.Marca;




@Repository
public interface RepositorioMarca  extends JpaRepository<Marca, Long>{
	
	Boolean existsByNombre(String nombre);
	}

