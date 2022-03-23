/**
 * 
 */
package com.shabo.api.dto;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="Libros")
@JsonIdentityInfo(
		  generator = ObjectIdGenerators.PropertyGenerator.class, 
		  property = "ISBN")
public class Libro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long ISBN;
	@Column(name="titulo")
	private String titulo;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="autor")
	private String autor;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "libro")
	private List<UsuarioLibro> listaPropietarios;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "libro")
	private List<Comentario> comentarios;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "libro")
	private List<Valoracion> puntuaciones;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "libro")
	private List<CategoriaLibro> categorias;
	
	public Libro(long ISBN, String titulo, String descripcion, String autor, List<UsuarioLibro> listaPropietarios,
			List<Comentario> comentarios, List<Valoracion> puntuaciones, List<CategoriaLibro> categorias) {
		super();
		this.ISBN = ISBN;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.autor = autor;
		this.listaPropietarios = listaPropietarios;
		this.comentarios = comentarios;
		this.puntuaciones = puntuaciones;
		this.categorias = categorias;
	}

	public Libro() {
		super();
	}
	@JsonAnyGetter
	public long getISBN() {
		return this.ISBN;
	}
	@JsonAnySetter
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public List<UsuarioLibro> getListaPropietarios() {
		return listaPropietarios;
	}

	public void setListaPropietarios(List<UsuarioLibro> listaPropietarios) {
		this.listaPropietarios = listaPropietarios;
	}

	public List<Comentario> getComentarios() {
		return comentarios;
	}

	public void setComentarios(List<Comentario> comentarios) {
		this.comentarios = comentarios;
	}

	public List<Valoracion> getPuntuaciones() {
		return puntuaciones;
	}

	public void setPuntuaciones(List<Valoracion> puntuaciones) {
		this.puntuaciones = puntuaciones;
	}
	
	public List<CategoriaLibro> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<CategoriaLibro> categorias) {
		this.categorias = categorias;
	}
}
