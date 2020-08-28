package ec.edu.ups.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ec.edu.ups.ecommerce.entities.Modelo;

@Repository
public interface RepositorioModelo extends JpaRepository<Modelo, Long>{

}
