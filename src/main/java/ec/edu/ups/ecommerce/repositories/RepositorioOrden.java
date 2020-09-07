package ec.edu.ups.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;


import ec.edu.ups.ecommerce.entities.Orden;


@Repository
public interface RepositorioOrden extends JpaRepository<Orden, Long> {
	
	
}
