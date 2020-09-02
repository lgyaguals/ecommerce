package ec.edu.ups.ecommerce.rest_controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import ec.edu.ups.ecommerce.entities.Marca;
import ec.edu.ups.ecommerce.entities.Modelo;
import ec.edu.ups.ecommerce.message.request.MarcaRequest;
import ec.edu.ups.ecommerce.repositories.RepositorioMarca;
import ec.edu.ups.ecommerce.repositories.RepositorioModelo;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class MarcaController {

	@Autowired
	 private RepositorioMarca repositorioMarca;
	@Autowired
	 private RepositorioModelo repositorioModelo;
	
	 @GetMapping("/marcas")
	  public List<Marca> listarMarcas() {
	    return repositorioMarca.findAll();
	  }
	 
	 @GetMapping("/marcas/{id}")
	  public Optional<Marca> getMarca(@PathVariable Long id) {
	    return repositorioMarca.findById(id);
	  }
	 
	 @PostMapping("/marcas")
	  public ResponseEntity<String> crearMarca( @RequestBody MarcaRequest marca) {
		try {
		
			if (repositorioMarca.existsByNombre(marca.getName())) {
				return new ResponseEntity<String>("{\"message\":{\"type\":\"warning\", \"content\": \"La marca ya está registrada. \"}}", HttpStatus.BAD_REQUEST);
			}
			Marca m = new Marca();
			m.setNombre(marca.getName());
			repositorioMarca.save(m);
			return ResponseEntity.ok("{\"message\":{\"type\":\"success\", \"content\": \"Registro exitoso\"}}");
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.getMessage());
			return new ResponseEntity<String>("{\"message\":{\"type\":\"error\", \"content\": \"Ha ocurrido un error\"}}", HttpStatus.BAD_REQUEST);
		}
	  }
	 
	 @PostMapping("/marcas/{id}")
	  public ResponseEntity<String> actualizarMarca (@RequestBody MarcaRequest marca, @PathVariable Long id) {
	   Optional<Marca> m = repositorioMarca.findById(id);
	   if(!m.isPresent())
		   return new ResponseEntity<String>("{\"message\":{\"type\":\"error\", \"content\": \"Ha ocurrido un error\"}}", HttpStatus.BAD_REQUEST);
	   
	  m.get().setNombre(marca.getName()); 
	  repositorioMarca.save(m.get());
	  return ResponseEntity.ok("{\"message\":{\"type\":\"success\", \"content\": \"Actualización exitosa\"}}");
	  }
	 
	 @PostMapping("/marca/{id}")
	  public ResponseEntity<String> eliminarMarca ( @PathVariable Long id) {
	   List<Modelo> m = repositorioModelo.findAllByMarcaId(id);
	   if(!m.isEmpty())
		   return new ResponseEntity<String>("{\"message\":{\"type\":\"error\", \"content\": \"No se puede eliminar porque la marca tiene modelos registrados\"}}", HttpStatus.BAD_REQUEST);
	   
	  
	  repositorioMarca.deleteById(id);
	  return ResponseEntity.ok("{\"message\":{\"type\":\"success\", \"content\": \"Eliminación exitosa\"}}");
	  }
}
