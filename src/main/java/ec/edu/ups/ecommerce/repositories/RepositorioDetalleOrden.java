package ec.edu.ups.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.ecommerce.entities.DetalleOrden;
import ec.edu.ups.ecommerce.entities.EEstadoOrden;

import java.util.List;

@Repository
public interface RepositorioDetalleOrden extends JpaRepository< DetalleOrden, Long>{
	
	List<DetalleOrden> findAllByEstadoAndProductoProveedorId(EEstadoOrden state, Long provider);
}
