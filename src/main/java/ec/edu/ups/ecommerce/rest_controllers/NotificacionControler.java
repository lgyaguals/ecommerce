package ec.edu.ups.ecommerce.rest_controllers;

import java.util.List;

import ec.edu.ups.ecommerce.entities.EEstadoNotificacion;
import ec.edu.ups.ecommerce.entities.Notificacion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.ecommerce.repositories.RepositorioNotificacion;

@RestController
@RequestMapping("/api/notificaciones")
public class NotificacionControler {

	@Autowired
	private RepositorioNotificacion repositorioNotificacion;

	@GetMapping("/{id}")
	List<Notificacion> listarNotifiaciones(@PathVariable Long id) {
		return repositorioNotificacion.findAllByUsuarioIdOrderByCreadoEnDesc(id);
	}

	@GetMapping("/recientes/{id}")
	ResponseEntity<String> notifiacionesRecientes(@PathVariable Long id) {
		int notificaciones = repositorioNotificacion.findAllByUsuarioIdAndEstado(id, EEstadoNotificacion.Enviada).size();
		if (notificaciones == 1) {
			return ResponseEntity.ok("{\"message\":\"Tiene " + notificaciones + " notificación sin leer\" }");
		} else if (notificaciones > 1) {
			return ResponseEntity.ok("{\"message\":\"Tiene " + notificaciones + " notificaciones sin leer\" }");
		} else {

			return ResponseEntity.ok("{\"message\":\"No tiene nuevas notificaciones \" }");
		}
	}

}
