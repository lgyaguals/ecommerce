package ec.edu.ups.ecommerce.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.ecommerce.entities.EEstadoOrden;
import ec.edu.ups.ecommerce.entities.Proveedor;
import ec.edu.ups.ecommerce.repositories.RepositorioDetalleOrden;
import ec.edu.ups.ecommerce.repositories.RepositorioProveedor;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class DetalleOrdenController {
	
	@Autowired
	RepositorioDetalleOrden repositorioDetalleOrden;
	@Autowired
	RepositorioProveedor repositorioProveedor;
	
	@GetMapping("/ventas/{proveedor}")
	public ResponseEntity<String> obtenerTotalVentas(@PathVariable String proveedor) {
		Proveedor p = repositorioProveedor.findByUsuarioEmail(proveedor);
		Object total = repositorioDetalleOrden.getTotalVentas(EEstadoOrden.CONFIRMADA, p.getId());
		if(total!=null)
			return ResponseEntity.ok("{\"total\":"+total+"}");
		else
			return ResponseEntity.ok("{\"total\":0}");
		
	}
	
	
}
