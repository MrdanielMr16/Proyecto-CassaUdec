package com.registro.usuarios.entity;

import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "Usuario", uniqueConstraints = @UniqueConstraint(columnNames = "email"))
public class Usuario implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7891904879124309325L;

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column
	@NotBlank
	@Size(min=5,max =20,message="No se cumplen las reglas del tamaño" )
	private String nombre;
	@Column
	@NotBlank
	private String apellido;
	@Column
	@NotBlank
	private String Pais;
	@Column
	@NotBlank
	private String ciudad;
	@Column
	@NotBlank
	private String email;
	@Column
	@NotBlank
	private String username;
	@Column
	@NotBlank
	private String password;
	@Transient
	private String confirmPassword;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "Usuario_roles",
			joinColumns = @JoinColumn(name="Usuario_id"),
			inverseJoinColumns = @JoinColumn(name="Rol_id"))
	private Set<Rol> roles;
	
	

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
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

	public String getPais() {
		return Pais;
	}

	public void setPais(String pais) {
		Pais = pais;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	public Set<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Set<Rol> roles) {
		this.roles = roles;
	}

	public Usuario(long id,
			@NotBlank @Size(min = 5, max = 20, message = "No se cumplen las reglas del tamaño") String nombre,
			@NotBlank String apellido, @NotBlank String pais, @NotBlank String ciudad, @NotBlank String email,
			@NotBlank String username, @NotBlank String password, @NotBlank String confirmPassword, Set<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		Pais = pais;
		this.ciudad = ciudad;
		this.email = email;
		this.username = username;
		this.password = password;
		this.confirmPassword = confirmPassword;
		this.roles = roles;
	}

	public Usuario(long id) {
		super();
		this.id = id;
	}

	public Usuario() {
		super();
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", Pais=" + Pais + ", ciudad="
				+ ciudad + ", email=" + email + ", username=" + username + ", password=" + password
				+ ", confirmPassword=" + confirmPassword + ", roles=" + roles + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Pais, apellido, ciudad, confirmPassword, email, id, nombre, password, roles, username);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Usuario other = (Usuario) obj;
		return Objects.equals(Pais, other.Pais) && Objects.equals(apellido, other.apellido)
				&& Objects.equals(ciudad, other.ciudad) && Objects.equals(confirmPassword, other.confirmPassword)
				&& Objects.equals(email, other.email) && id == other.id && Objects.equals(nombre, other.nombre)
				&& Objects.equals(password, other.password) && Objects.equals(roles, other.roles)
				&& Objects.equals(username, other.username);
	}
	
	
}
