package ec.edu.ups.ecommerce.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.ecommerce.entities.Modelo;
import ec.edu.ups.ecommerce.repositories.RepositorioModelo;

@RestController
public class ModeloController {
	
	@Autowired
	private RepositorioModelo repositorioModelo; 
	
	@GetMapping("/modelos")
	protected List<Modelo> listarModelos(){
		return repositorioModelo.findAll();
	}
	
	@PostMapping("/modelos")
	protected Modelo crearModelo(@RequestBody Modelo modelo){
		return repositorioModelo.save(modelo);
	}

}
