package ec.edu.ups.ecommerce.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.JoinColumn;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "usuarios", uniqueConstraints = {
        @UniqueConstraint(columnNames = {
            "username"
        }),
        @UniqueConstraint(columnNames = {
            "email"
        })
})
@EntityListeners(AuditingEntityListener.class)
@DynamicUpdate
public class Usuario {
	
	@Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
	
	@Column(name = "username", nullable = false, length = 120)
    private String username;
	
    @Column(name = "email", nullable = false, length = 120)
    private String email;
    
    @Column( nullable = false, length = 120)
    private String password;
    
    
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private PerfilUsuario perfil;
    
    @CreatedDate
	@Column(name = "creado_en", updatable = false)
    private Date creadoEn;
	
	@LastModifiedDate
    @Column(name = "modificado_en")
    private Date modificadoEn;
	
	 @ManyToMany(fetch = FetchType.LAZY)
	    @JoinTable(name = "usuarios_roles", 
	      joinColumns = @JoinColumn(name = "id_usuario"), 
	      inverseJoinColumns = @JoinColumn(name = "id_rol"))
	    private Set<Rol> roles = new HashSet<>();

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}


	public PerfilUsuario getPerfil() {
		return perfil;
	}

	public void setPerfil(PerfilUsuario perfil) {
		this.perfil = perfil;
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

	
	public String getUsername() {
		return username;
	}

	public void setUserName(String userName) {
		this.username = userName;
	}

	public Set<Rol> getRoles() {
        return roles;
    }
 
    public void setRoles(Set<Rol> roles) {
        this.roles = roles;
    }
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", email=" + email + ", password=" + password + ", perfil="
				+ perfil + ", creadoEn=" + creadoEn + ", modificadoEn=" + modificadoEn + "]";
	}
	
	
	
	
	
	

}
