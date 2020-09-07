package ec.edu.ups.ecommerce.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
@Entity
@Table(name="ordenes")
@EntityListeners(AuditingEntityListener.class)
public class Orden {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	@ManyToOne
	private Usuario usuario;
	@CreatedDate
	@Column(name = "fecha_orden", updatable = false)
	private Date fechaOrden;
	private float iva;
	private float subtotal;
	private float total;
	@Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 10)
	private EEstadoOrden estado = EEstadoOrden.PENDIENTE;
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	public Date getFechaOrden() {
		return fechaOrden;
	}
	public void setFechaOrden(Date fechaOrden) {
		this.fechaOrden = fechaOrden;
	}
	public float getIva() {
		return iva;
	}
	public void setIva(float iva) {
		this.iva = iva;
	}
	public float getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(float subtotal) {
		this.subtotal = subtotal;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
	}
	public EEstadoOrden getEstado() {
		return estado;
	}
	public void setEstado(EEstadoOrden estado) {
		this.estado = estado;
	}
	
	
	
	
	
	
}
