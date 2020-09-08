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
import ec.edu.ups.ecommerce.message.request.ModeloRequest;
import ec.edu.ups.ecommerce.repositories.RepositorioMarca;
import ec.edu.ups.ecommerce.repositories.RepositorioModelo;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api")
public class ModeloController {
	
	@Autowired
	private RepositorioModelo repositorioModelo;
	
	@Autowired
	 private RepositorioMarca repositorioMarca;
	
	@GetMapping("/modelos")
	protected List<Modelo> listarModelos(){
		return repositorioModelo.findAll();
	}
	
	@GetMapping("/modelos-marca/{id}")
	protected List<Modelo> listarModelosPorMarca(@PathVariable Long id){
		return repositorioModelo.findAllByMarcaId(id);
	}
	
	@GetMapping("/modelos/{id}")
	protected Optional<Modelo> getModelo(@PathVariable Long id){
		return repositorioModelo.findById(id);
	}
	
	@PostMapping("/modelos")
	protected ResponseEntity<String> crearModelo(@RequestBody ModeloRequest modelo){
		try {
			if(repositorioModelo.existsByNombre(modelo.getName())) {
				return  new ResponseEntity<String>("{\"message\":{\"type\":\"warning\", \"content\": \"El modelo ya está registrada. \"}}", HttpStatus.BAD_REQUEST);
			}
			Modelo m = new Modelo();
			Optional<Marca> marca = repositorioMarca.findById(modelo.getBrandId());
			m.setNombre(modelo.getName());
			m.setMarca(marca.get());
			repositorioModelo.save(m);
			
			return ResponseEntity.ok("{\"message\":{\"type\":\"success\", \"content\": \"Registro exitoso\"}}");
				
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return  new ResponseEntity<String>("{\"message\":{\"type\":\"error\", \"content\": \"Ha ocurrido un error\"}}", HttpStatus.BAD_REQUEST);
		}
		
	}
	 @PostMapping("/modelos/{id}")
	  public ResponseEntity<String> actualizarModelo (@RequestBody ModeloRequest modelo, @PathVariable Long id) {
	   Optional<Modelo> m = repositorioModelo.findById(id);
	  
		Optional<Marca> marca = repositorioMarca.findById(modelo.getBrandId());
	   if(!m.isPresent() || !marca.isPresent())
		   return new ResponseEntity<String>("{\"message\":{\"type\":\"error\", \"content\": \"Ha ocurrido un error\"}}", HttpStatus.BAD_REQUEST);
	  
	  m.get().setNombre(modelo.getName()); 
	  m.get().setMarca(marca.get());
	  repositorioModelo.save(m.get());
	  return ResponseEntity.ok("{\"message\":{\"type\":\"success\", \"content\": \"Actualización exitosa\"}}");
	  }

}
