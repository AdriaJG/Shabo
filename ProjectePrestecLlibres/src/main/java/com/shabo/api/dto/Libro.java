/**
 * 
 */
package com.shabo.api.dto;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="Libros")
public class Libro {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String ISBN;
	@Column(name="titulo")
	private String titulo;
	@Column(name="descripcion")
	private String descripcion;
	@Column(name="autor")
	private String autor;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "libro")
	private List<UsuarioLibro> listaPropietarios;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "libro")
	private List<Comentario> comentarios;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "libro")
	private List<Valoracion> puntuaciones;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "libro")
	private List<CategoriaLibro> categorias;
	
	public Libro(String ISBN, String titulo, String descripcion, String autor, List<UsuarioLibro> listaPropietarios,
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

	public String getISBN() {
		return ISBN;
	}

	public void setISBN(String iSBN) {
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
