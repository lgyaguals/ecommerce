package ec.edu.ups.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ec.edu.ups.ecommerce.entities.Producto;
import java.util.List;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
	
	@Query("SELECT  p.modelo, p.precio, p.proveedor.id, p.descripcion,p.urlImagen FROM Producto p where p.marca.id = ?1")
	List<Object> findAllByMarcaId(Long marca);
	
	@Query("SELECT p.modelo, p.precio, p.proveedor.id, p.descripcion,p.urlImagen FROM Producto p where p.modelo.id = ?1")
	List<Object> findAllByModeloId(Long modelo);
	
	@Query("SELECT p.modelo, p.precio, p.proveedor.id, p.descripcion,p.urlImagen FROM Producto p where p.proveedor.id = ?1")
	List<Object> findAllByProveedorId(Long proveedor);
	
	@Query("SELECT  p.modelo , p.precio, p.proveedor.id, p.descripcion, p.urlImagen   FROM Producto p WHERE CONCAT(p.marca.nombre, p.modelo.nombre) LIKE %?1%")
	List<Object> search(String keyword);
	
	@Query("SELECT p.modelo, p.precio, p.proveedor.id, p.descripcion,p.urlImagen FROM Producto p WHERE p.precio <= ?1")
	List<Object> findAllByPrice(float price);
	
	Boolean existsByProveedorIdAndModeloId(Long proveedor, Long marca);
	
}
