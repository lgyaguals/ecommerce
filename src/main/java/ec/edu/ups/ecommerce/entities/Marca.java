package ec.edu.ups.ecommerce.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "marcas", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "nombre"
            })})
           
@EntityListeners(AuditingEntityListener.class)
public class Marca {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column( nullable = false, length = 120)
    private String nombre;
	
	@CreatedDate
	@Column(name = "creado_en", updatable = false)
    private Date creadoEn;
	
	@LastModifiedDate
    @Column(name = "modificado_en")
    private Date modificadoEn;

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public long getId() {
		return id;
	}

	public Date getCreadoEn() {
		return creadoEn;
	}


	public void setId(long id) {
		this.id = id;
	}

	public void setCreadoEn(Date creadoEn) {
		this.creadoEn = creadoEn;
	}

	public Date getModificadoEn() {
		return modificadoEn;
	}

	public void setModificadoEn(Date modificadoEn) {
		this.modificadoEn = modificadoEn;
	}

	
    
    
    
    
}
