package ec.edu.ups.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ec.edu.ups.ecommerce.entities.Producto;
import java.util.List;
import java.util.Optional;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
	
	@Query("SELECT  p.id, p.modelo, p.precio, p.proveedor.id, p.descripcion,p.urlImagen FROM Producto p where p.id = ?1")
	Optional<Object> getById(Long id);
	
	@Query("SELECT  p.id, p.modelo, p.precio, p.proveedor.id, p.descripcion,p.urlImagen FROM Producto p where p.marca.id = ?1")
	List<Object> findAllByMarcaId(Long marca);
	
	@Query("SELECT  p.id, p.modelo, p.precio, p.proveedor.id, p.descripcion,p.urlImagen FROM Producto p where p.modelo.id = ?1")
	List<Object> findAllByModeloId(Long modelo);
	
	@Query("SELECT  p.id, p.modelo, p.precio, p.proveedor.id, p.descripcion,p.urlImagen FROM Producto p where p.proveedor.id = ?1")
	List<Object> findAllByProveedorId(Long proveedor);
	
	@Query("SELECT   p.id, p.modelo , p.precio, p.proveedor.id, p.descripcion, p.urlImagen   FROM Producto p WHERE CONCAT(p.marca.nombre, p.modelo.nombre) LIKE %?1%")
	List<Object> search(String keyword);
	
	@Query("SELECT  p.id, p.modelo, p.precio, p.proveedor.id, p.descripcion,p.urlImagen FROM Producto p WHERE p.precio <= ?1")
	List<Object> findAllByPrice(float price);
	
	Boolean existsByProveedorIdAndModeloId(Long proveedor, Long marca);
	
}
