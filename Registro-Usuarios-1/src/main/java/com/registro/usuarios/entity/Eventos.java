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
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
@Table(name = "Eventos")
public class Eventos {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	@NotEmpty
	private String nombre_evento;
	
	@NotEmpty
	private String descripcion_evento;
	
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_evento")
	private Date fecha;
	
	@NotEmpty
	private String hora;
	
	@NotEmpty
	private String lugar;
	
	
	private String imagen;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre_evento() {
		return nombre_evento;
	}

	public void setNombre_evento(String nombre_evento) {
		this.nombre_evento = nombre_evento;
	}

	public String getDescripcion_evento() {
		return descripcion_evento;
	}

	public void setDescripcion_evento(String descripcion_evento) {
		this.descripcion_evento = descripcion_evento;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public Eventos(int id, @NotEmpty String nombre_evento, @NotEmpty String descripcion_evento, Date fecha,
			@NotEmpty String hora, @NotEmpty String lugar, String imagen) {
		super();
		this.id = id;
		this.nombre_evento = nombre_evento;
		this.descripcion_evento = descripcion_evento;
		this.fecha = fecha;
		this.hora = hora;
		this.lugar = lugar;
		this.imagen = imagen;
	}

	public Eventos(int id) {
		super();
		this.id = id;
	}

	public Eventos() {
		super();
	}

	
}
