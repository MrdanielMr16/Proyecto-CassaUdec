package com.registro.usuarios.entity;



import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Cartillas")
public class Cartillas {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombre_Cartilla;
	private String descripcion;
	private String nombre_archivo;
	private Long tamanio;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_Subida")
	private Date fecha_Subida;
	
	private byte[] contenido;
	
	public Cartillas(Long id, String nombre_Cartilla, String descripcion, String nombre_archivo, Long tamanio,
			Date fecha_Subida, byte[] contenido) {
		super();
		this.id = id;
		this.nombre_Cartilla = nombre_Cartilla;
		this.descripcion = descripcion;
		this.nombre_archivo = nombre_archivo;
		this.tamanio = tamanio;
		this.fecha_Subida = fecha_Subida;
		this.contenido = contenido;
	}
	public Cartillas(Long id, String nombre_archivo, Long tamanio,String nombre_Cartilla,String descripcion) {
		this.id = id;
		this.nombre_archivo = nombre_archivo;
		this.tamanio = tamanio;
		this.nombre_Cartilla = nombre_Cartilla;
		this.descripcion = descripcion;
	}
	public Cartillas() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre_archivo() {
		return nombre_archivo;
	}
	public void setNombre_archivo(String nombre_archivo) {
		this.nombre_archivo = nombre_archivo;
	}
	public Long getTamanio() {
		return tamanio;
	}
	public void setTamanio(Long tamanio) {
		this.tamanio = tamanio;
	}
	public Date getFecha_Subida() {
		return fecha_Subida;
	}
	public void setFecha_Subida(Date fecha_Subida) {
		this.fecha_Subida = fecha_Subida;
	}
	public byte[] getContenido() {
		return contenido;
	}
	public void setContenido(byte[] contenido) {
		this.contenido = contenido;
	}
	public String getNombre_Cartilla() {
		return nombre_Cartilla;
	}
	public void setNombre_Cartilla(String nombre_Cartilla) {
		this.nombre_Cartilla = nombre_Cartilla;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
