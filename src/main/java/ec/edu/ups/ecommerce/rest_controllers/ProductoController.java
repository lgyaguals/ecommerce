package ec.edu.ups.ecommerce.rest_controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.ups.ecommerce.repositories.RepositorioMarca;
import ec.edu.ups.ecommerce.repositories.RepositorioModelo;
import ec.edu.ups.ecommerce.repositories.RepositorioProducto;
import ec.edu.ups.ecommerce.repositories.RepositorioProveedor;
import java.util.List;
import java.util.Optional;

import ec.edu.ups.ecommerce.entities.Modelo;
import ec.edu.ups.ecommerce.entities.Producto;
import ec.edu.ups.ecommerce.entities.Proveedor;
import ec.edu.ups.ecommerce.message.request.ProductoRequest;

@RestController
@RequestMapping("/api")
public class ProductoController {

	@Autowired
	RepositorioProducto repositorioProducto;

	@Autowired
	RepositorioProveedor repositorioProveedor;

	@Autowired
	RepositorioMarca repositorioMarca;

	@Autowired
	RepositorioModelo repositorioModelo;

	@GetMapping("/productos")
	public List<Producto> listarProdutos() {
		return repositorioProducto.findAll();
	}

	@GetMapping("/productos/{id}")
	public Optional<Producto> obtenerProducto(@PathVariable Long id) {
		return repositorioProducto.findById(id);
	}

	@GetMapping("/productos-marca/{marca}")
	public List<Object> listarProdutosPorMarca(@PathVariable Long marca) {
		return repositorioProducto.findAllByMarcaId(marca);
	}

	@GetMapping("/productos-modelo/{modelo}")
	public List<Object> listarProdutosPorModelo(@PathVariable Long modelo) {
		return repositorioProducto.findAllByModeloId(modelo);
	}

	@GetMapping("/productos-proveedor/{proveedor}")
	public List<Object> listarProdutosPorProveedor(@PathVariable String proveedor) {
		
		Proveedor p = repositorioProveedor.findByUsuarioEmail(proveedor);
		System.out.println(p.getId());
		return repositorioProducto.findAllByProveedorId(p.getId());
	}

	@GetMapping("/productos-precio/{precio}")
	public List<Object> listarProdutosPorProveedor(@PathVariable float precio) {
		return repositorioProducto.findAllByPrice(precio);
	}

	@GetMapping("/producto/{param}")
	public List<Object> buscarProducto(@PathVariable String param) {
		return repositorioProducto.search(param);
	}

	@PostMapping("/productos")
	ResponseEntity<String> registarProducto(@RequestBody ProductoRequest product) {
		try {
			Proveedor proveedor = repositorioProveedor.findByUsuarioEmail(product.getProvider());
			if (repositorioProducto.existsByProveedorIdAndModeloId(proveedor.getId(), product.getModel())) {
				return new ResponseEntity<String>(
						"{\"message\":{\"type\":\"warning\", \"content\": \"La producto ya está registrado. \"}}",
						HttpStatus.BAD_REQUEST);
			}
			Producto p = new Producto();
			Modelo m = new Modelo();
			m = (repositorioModelo.findById(product.getModel())).get();
			p.setMarca(m.getMarca());
			p.setModelo(m);
			p.setProveedor((repositorioProveedor.findByUsuarioEmail(product.getProvider())));
			p.setDescripcion(product.getDescription());
			p.setPrecio(product.getPrice());
			p.setUrlImagen(product.getUrlImage());
			repositorioProducto.save(p);
			return ResponseEntity.ok("{\"message\":{\"type\":\"success\", \"content\": \"Registro exitoso\"}}");
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(
					"{\"message\":{\"type\":\"error\", \"content\": \"Ha ocurrido un error\"}}",
					HttpStatus.BAD_REQUEST);
		}
	
	}

	@PostMapping("/productos/{id}")
	ResponseEntity<String> actualizarProducto(@PathVariable Long id, @RequestBody ProductoRequest product) {
		try {
			Optional<Producto> p = repositorioProducto.findById(id);
			if (!p.isPresent())
				return new ResponseEntity<String>(
						"{\"message\":{\"type\":\"error\", \"content\": \"Ha ocurrido un error\"}}",
						HttpStatus.BAD_REQUEST);

			Modelo m = new Modelo();
			m = (repositorioModelo.findById(product.getModel())).get();
			p.get().setMarca(m.getMarca());
			p.get().setModelo(m);
			p.get().setProveedor((repositorioProveedor.findByUsuarioEmail(product.getProvider())));
			p.get().setDescripcion(product.getDescription());
			p.get().setPrecio(product.getPrice());
			p.get().setUrlImagen(product.getUrlImage());
			repositorioProducto.save(p.get());
			return ResponseEntity.ok("{\"message\":{\"type\":\"success\", \"content\": \"Actualización exitosa\"}}");

		} catch (Exception e) {
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(
					"{\"message\":{\"type\":\"error\", \"content\": \"Ha ocurrido un error\"}}",
					HttpStatus.BAD_REQUEST);
		}

	}

}
