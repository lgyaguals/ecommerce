/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;


import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;


@Entity
@Table(name = "perfil_usuario")
@EntityListeners(AuditingEntityListener.class)
public class PerfilUsuario{

    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
   
    @OneToOne
    @JoinColumn(name = "id_usuario")
    @MapsId
    private Usuario usuario;
    
      
    @Enumerated(EnumType.ORDINAL)
    private ETipoDocumento tipoDocumento;
    
    @Column(length = 13)
    private String documento;
    
    @Column(length = 60)
    private String nombre;
    
    @Column(length = 60)
    private String apellido;

    
    
    
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilUsuario)) {
            return false;
        }
        PerfilUsuario other = (PerfilUsuario) object;
        return !((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id)));
    }

    @Override
    public String toString() {
        return String.format("{ id= {0}, nombre = {1}, apellido = {3}}",
        id, nombre, apellido);
    }

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public ETipoDocumento getTipoDocumento() {
		return tipoDocumento;
	}

	public void setTipoDocumento(ETipoDocumento tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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
