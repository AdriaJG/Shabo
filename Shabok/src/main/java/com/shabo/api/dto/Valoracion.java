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

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="valoracion")
@JsonIgnoreProperties({"libro", "usuario_id"})
public class Valoracion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="valoracion")
	private int valoracion;
	@Column(name="num_votos")
	private int numVotos;
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="ISBN")
	@JsonManagedReference
	private Libro libro;
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="usuario_id")
	@JsonManagedReference
	private Usuario usuario;
	
	public Valoracion(int valoracion, int numVotos, Libro libro, Usuario usuario) {
		super();
		this.valoracion = valoracion;
		this.numVotos = numVotos;
		this.libro = libro;
		this.usuario = usuario;
	}

	public Valoracion() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getValoracion() {
		return valoracion;
	}

	public void setValoracion(int valoracion) {
		this.valoracion = valoracion;
	}

	public int getNumVotos() {
		return numVotos;
	}

	public void setNumVotos(int numVotos) {
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
