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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="Valoracion")
public class Valoracion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@Column(name="valoracion")
	private long valoracion;
	@Column(name="num_votos")
	private long numVotos;
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="ISBN")
	private Libro libro;
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	
	public Valoracion(long valoracion, long numVotos, Libro libro, Usuario usuario) {
		super();
		this.valoracion = valoracion;
		this.numVotos = numVotos;
		this.libro = libro;
		this.usuario = usuario;
	}

	public Valoracion() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getValoracion() {
		return valoracion;
	}

	public void setValoracion(long valoracion) {
		this.valoracion = valoracion;
	}

	public long getNumVotos() {
		return numVotos;
	}

	public void setNumVotos(long numVotos) {
		this.numVotos = numVotos;
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
