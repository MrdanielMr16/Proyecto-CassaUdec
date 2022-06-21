package com.registro.usuarios.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;

@Entity
public class estadoSalud implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6023048026538078149L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	/**
	 Diagnostico de enfermeria (nanda)
	 */
	
	@NotEmpty
	private String diagnosticoNANDA;
	
	/**
	Resultados esperados (NOC)
	 */
	
	@NotEmpty
	private String requisitoAutocuidado;
	
	@NotEmpty
	private String abiertoIndicadores;
	
	@NotEmpty
	private String escalaValoracion;
	
	@NotEmpty
	private String puntuacionInicial;
	
	@NotEmpty
	private String metaAutocuidado;
	
	@NotEmpty
	private String diagnosticoNOC;
	
	/**
	 Intervenciones (NIC)
	 */
	
	@NotEmpty
	private String intervencionesEnfermeria;
	
	@NotEmpty
	private String abiertoActividades;
	
	@NotEmpty
	private String evaluacion;
	
	/**
	 Relacion de paciente
	 */
	@ManyToOne
	@JoinColumn(name = "pacientes_id")
	private Pacientes pacientes;

	@Temporal(TemporalType.DATE)
	@DateTimeFormat(iso = ISO.DATE)
	@Column(name = "fecha_valoracion")
	private Date fecha_valoracion;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDiagnosticoNANDA() {
		return diagnosticoNANDA;
	}

	public void setDiagnosticoNANDA(String diagnosticoNANDA) {
		this.diagnosticoNANDA = diagnosticoNANDA;
	}

	public String getRequisitoAutocuidado() {
		return requisitoAutocuidado;
	}

	public void setRequisitoAutocuidado(String requisitoAutocuidado) {
		this.requisitoAutocuidado = requisitoAutocuidado;
	}

	public String getAbiertoIndicadores() {
		return abiertoIndicadores;
	}

	public void setAbiertoIndicadores(String abiertoIndicadores) {
		this.abiertoIndicadores = abiertoIndicadores;
	}

	public String getEscalaValoracion() {
		return escalaValoracion;
	}

	public void setEscalaValoracion(String escalaValoracion) {
		this.escalaValoracion = escalaValoracion;
	}

	public String getPuntuacionInicial() {
		return puntuacionInicial;
	}

	public void setPuntuacionInicial(String puntuacionInicial) {
		this.puntuacionInicial = puntuacionInicial;
	}

	public String getMetaAutocuidado() {
		return metaAutocuidado;
	}

	public void setMetaAutocuidado(String metaAutocuidado) {
		this.metaAutocuidado = metaAutocuidado;
	}

	public String getDiagnosticoNOC() {
		return diagnosticoNOC;
	}

	public void setDiagnosticoNOC(String diagnosticoNOC) {
		this.diagnosticoNOC = diagnosticoNOC;
	}

	public String getIntervencionesEnfermeria() {
		return intervencionesEnfermeria;
	}

	public void setIntervencionesEnfermeria(String intervencionesEnfermeria) {
		this.intervencionesEnfermeria = intervencionesEnfermeria;
	}

	public String getAbiertoActividades() {
		return abiertoActividades;
	}

	public void setAbiertoActividades(String abiertoActividades) {
		this.abiertoActividades = abiertoActividades;
	}

	public String getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

	public Pacientes getPacientes() {
		return pacientes;
	}

	public void setPacientes(Pacientes pacientes) {
		this.pacientes = pacientes;
	}

	public Date getFecha_valoracion() {
		return fecha_valoracion;
	}

	public void setFecha_valoracion(Date fecha_valoracion) {
		this.fecha_valoracion = fecha_valoracion;
	}

	public estadoSalud(int id, @NotEmpty String diagnosticoNANDA, @NotEmpty String requisitoAutocuidado,
			@NotEmpty String abiertoIndicadores, @NotEmpty String escalaValoracion, @NotEmpty String puntuacionInicial,
			@NotEmpty String metaAutocuidado, @NotEmpty String diagnosticoNOC,
			@NotEmpty String intervencionesEnfermeria, @NotEmpty String abiertoActividades, @NotEmpty String evaluacion,
			Pacientes pacientes, Date fecha_valoracion) {
		super();
		this.id = id;
		this.diagnosticoNANDA = diagnosticoNANDA;
		this.requisitoAutocuidado = requisitoAutocuidado;
		this.abiertoIndicadores = abiertoIndicadores;
		this.escalaValoracion = escalaValoracion;
		this.puntuacionInicial = puntuacionInicial;
		this.metaAutocuidado = metaAutocuidado;
		this.diagnosticoNOC = diagnosticoNOC;
		this.intervencionesEnfermeria = intervencionesEnfermeria;
		this.abiertoActividades = abiertoActividades;
		this.evaluacion = evaluacion;
		this.pacientes = pacientes;
		this.fecha_valoracion = fecha_valoracion;
	}

	public estadoSalud(@NotEmpty String diagnosticoNANDA, @NotEmpty String requisitoAutocuidado,
			@NotEmpty String abiertoIndicadores, @NotEmpty String escalaValoracion, @NotEmpty String puntuacionInicial,
			@NotEmpty String metaAutocuidado, @NotEmpty String diagnosticoNOC,
			@NotEmpty String intervencionesEnfermeria, @NotEmpty String abiertoActividades, @NotEmpty String evaluacion,
			Pacientes pacientes, Date fecha_valoracion) {
		super();
		this.diagnosticoNANDA = diagnosticoNANDA;
		this.requisitoAutocuidado = requisitoAutocuidado;
		this.abiertoIndicadores = abiertoIndicadores;
		this.escalaValoracion = escalaValoracion;
		this.puntuacionInicial = puntuacionInicial;
		this.metaAutocuidado = metaAutocuidado;
		this.diagnosticoNOC = diagnosticoNOC;
		this.intervencionesEnfermeria = intervencionesEnfermeria;
		this.abiertoActividades = abiertoActividades;
		this.evaluacion = evaluacion;
		this.pacientes = pacientes;
		this.fecha_valoracion = fecha_valoracion;
	}

	public estadoSalud(int id) {
		super();
		this.id = id;
	}

	public estadoSalud() {
		super();
	}

	
	
	
}
