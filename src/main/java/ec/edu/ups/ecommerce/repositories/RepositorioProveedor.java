package ec.edu.ups.ecommerce.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


import ec.edu.ups.ecommerce.entities.Proveedor;


public interface RepositorioProveedor  extends JpaRepository<Proveedor, Long>{
	 @Query(
			 value=" select pu.id_usuario, pu.nombre, pu.apellido, pu.tipo_documento, pu.documento, p.comision from perfil_usuario pu inner join proveedores p  on p.id_usuario =pu.id_usuario",
			 nativeQuery=true)
	 List<Object> getProveedores();
	 
	 @Query(
			 value=" select p.id, pu.nombre, pu.apellido, pu.tipo_documento, pu.documento, p.comision from perfil_usuario pu inner join proveedores p  on p.id_usuario =pu.id_usuario where p.id_usuario =?",
			 nativeQuery=true)
	 Object getProveedor(Long id);
	
	
		 
	 
	 
}
