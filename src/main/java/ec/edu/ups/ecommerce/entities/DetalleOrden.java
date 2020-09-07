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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.NaturalId;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="detalle_orden")
@EntityListeners(AuditingEntityListener.class)
public class DetalleOrden {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id; 
	
	@ManyToOne
	@JoinColumn(name="id_producto", nullable = false)
	private Producto producto;
	
	@Column(nullable=false)
	private int cantidad;
	
	@Column(nullable=false)
	private float total;
	
	@CreatedDate
	@Column(name = "creado_en", nullable = false)
	private Date creadoEn;
	
	@Enumerated(EnumType.STRING)
    @NaturalId
    @Column(length = 10)
	private EEstadoOrden estado = EEstadoOrden.PENDIENTE;
	
	@LastModifiedDate
	@Column(name = "actualizado_en", nullable = false)
	private Date actualizadoEn;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public float getTotal() {
		return total;
	}
	public void setTotal(float total) {
		this.total = total;
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
