package ec.edu.ups.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ec.edu.ups.ecommerce.entities.Producto;
import java.util.List;

@Repository
public interface RepositorioProducto extends JpaRepository<Producto, Long> {
	
	List<Producto> findAllByMarcaId(Long marca);
	
	List<Producto> findAllByModeloId(Long marca);
	
	@Query("SELECT p FROM Producto p WHERE CONCAT(p.marca.nombre, p.modelo.nombre) LIKE %?1%")
	List<Producto> search(String keyword);
	
	@Query("SELECT p FROM Producto p WHERE p.precio <= ?1")
	List<Producto> findAllByPrice(float price);
	
	
}
