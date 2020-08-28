package ec.edu.ups.ecommerce.rest_controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ec.edu.ups.ecommerce.entities.Marca;
import ec.edu.ups.ecommerce.repositories.RepositorioMarca;

@RestController
@RequestMapping("/api")
public class MarcaController {

	@Autowired
	 private RepositorioMarca repositorioMarca;
	
	 @GetMapping("/marcas")
	  public List<Marca> listarMarcas() {
	    return repositorioMarca.findAll();
	  }
	 
	 @PostMapping("/marcas")
	  public Marca crearMarca( @RequestBody Marca marca) {
		System.out.println(marca.getNombre());
	    return repositorioMarca.save(marca);
	  }

}
