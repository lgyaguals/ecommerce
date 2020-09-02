package ec.edu.ups.ecommerce.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "proveedores")
@EntityListeners(AuditingEntityListener.class)
public class Proveedor {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
	
	@OneToOne
    @JoinColumn(name = "id_usuario")
	private Usuario usuario;
	
	@Column(columnDefinition = "float not null default '0.03'")
	private float comision = .03f;
	
	@CreatedDate
	@Column(name = "creado_en", nullable = false)
	private Date creadoEn;

	@LastModifiedDate
	@Column(name = "actualizado_en", nullable = false)
	private Date actualizadoEn;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public float getComision() {
		return comision;
	}

	public void setComision(float comision) {
		this.comision = comision;
	}

	public Date getCreadoEn() {
		return creadoEn;
	}

	public void setCreadoEn(Date creadoEn) {
		this.creadoEn = creadoEn;
	}

	public Date getActualizadoEn() {
		return actualizadoEn;
	}

	public void setActualizadoEn(Date actualizadoEn) {
		this.actualizadoEn = actualizadoEn;
	}

	
	
	
	
   

}
