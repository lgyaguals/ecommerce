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

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name="notificaciones")
@EntityListeners(AuditingEntityListener.class)
public class Notificacion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "id_usuario", nullable = false)
	private Usuario usuario;
	
	@Column(nullable = false)
	private String mensaje;
	
	@Enumerated(EnumType.STRING)
	private EEstadoNotificacion estado;
	
	@CreatedDate
	@Column(name = "creado_en", nullable = false)
	private Date creadoEn;

	@LastModifiedDate
	@Column(name = "actualizado_en", nullable = false)
	private Date actualizadoEn;
	
	
}
