package ec.edu.ups.ecommerce.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ec.edu.ups.ecommerce.entities.Notificacion;

@Repository
public interface RepositorioNotificacion  extends JpaRepository<Notificacion, Long>{

}
