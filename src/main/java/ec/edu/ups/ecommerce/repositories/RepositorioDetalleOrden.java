package ec.edu.ups.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ec.edu.ups.ecommerce.entities.DetalleOrden;
import ec.edu.ups.ecommerce.entities.EEstadoOrden;

import java.util.List;

@Repository
public interface RepositorioDetalleOrden extends JpaRepository< DetalleOrden, Long>{
	@Query("Select d.producto.modelo, d.producto.descripcion, d.producto.precio, d.producto.precio, d.cantidad, d.total from DetalleOrden d where d.estado=?1 and d.producto.proveedor.id = ?2")
	List<Object> findAllByEstadoAndProductoProveedorId(EEstadoOrden state, Long provider);
	
	@Query("Select SUM(d.total) from DetalleOrden d where d.estado=?1 and d.producto.proveedor.id = ?2")
	Object getTotalVentas(EEstadoOrden state, Long provider);
}
