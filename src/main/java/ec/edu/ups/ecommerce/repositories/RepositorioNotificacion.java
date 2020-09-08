package ec.edu.ups.ecommerce.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.ecommerce.entities.EEstadoNotificacion;
import ec.edu.ups.ecommerce.entities.Notificacion;

@Repository
public interface RepositorioNotificacion  extends JpaRepository<Notificacion, Long>{
	
	List<Notificacion> findAllByUsuarioIdOrderByCreadoEnDesc(Long id);
	List<Notificacion> findAllByUsuarioIdAndEstado(Long id, EEstadoNotificacion estado);
	
}
