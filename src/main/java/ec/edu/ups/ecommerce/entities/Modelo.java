package ec.edu.ups.ecommerce.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

@Entity
@Table(name="modelos", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
                "nombre"
            })})

public class Modelo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@JoinColumn(name="id_marca")
	@ManyToOne
	private Marca marca;
	
	@Column(length = 60)
	private String nombre;

	@CreatedDate
	@Column(name = "creado_en", updatable = false)
    private Date creadoEn;
	
	@LastModifiedDate
    @Column(name = "modificado_en")
    private Date modificadoEn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Marca getMarca() {
		return marca;
	}

	public void setMarca(Marca marca) {
		this.marca = marca;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Date getCreadoEn() {
		return creadoEn;
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
