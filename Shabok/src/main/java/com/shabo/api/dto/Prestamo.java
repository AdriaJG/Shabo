/**
 * 
 */
package com.shabo.api.dto;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="prestamo")
public class Prestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="propietario_id")
	private UsuarioLibro libro;
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_prestamo")
	private Usuario usuario;
	@Column(name="fecha_prestado")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaInicio;
	@Column(name="fecha_entregado")
	@Temporal(TemporalType.TIMESTAMP)
	private Date fechaFin;

	public Prestamo(int id, UsuarioLibro libro, Usuario usuario, Date fechaInicio, Date fechaFin) {
		super();
		this.id = id;
		this.libro = libro;
		this.usuario = usuario;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
	}

	public Prestamo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UsuarioLibro getLibro() {
		return libro;
	}

	public void setLibro(UsuarioLibro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Date getFechaFin() {
		return fechaFin;
	}

	public void setFechaFin(Date fechaFin) {
		this.fechaFin = fechaFin;
	}
}
