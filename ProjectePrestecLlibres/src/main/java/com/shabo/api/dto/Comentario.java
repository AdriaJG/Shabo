/**
 * 
 */
package com.shabo.api.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="Comentario")
public class Comentario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="mensaje")
	String mensaje;
	@Column(name="data_publicacion")
	private Date fechaPublicacion;
	@ManyToOne
	@JoinColumn(name="ISBN")
	private Libro libro;
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	public Comentario(String mensaje, Date fechaPublicacion, Libro libro, Usuario usuario) {
		super();
		this.mensaje = mensaje;
		this.fechaPublicacion = fechaPublicacion;
		this.libro = libro;
		this.usuario = usuario;
	}

	public Comentario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public Date getFechaPublicacion() {
		return fechaPublicacion;
	}

	public void setFechaPublicacion(Date fechaPublicacion) {
		this.fechaPublicacion = fechaPublicacion;
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
}
