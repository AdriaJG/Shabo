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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="categorias")
public class Categoria {
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	private String categoria;
	@Column(name="descripcion")
	private String descripcion;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "libro")
	private List<CategoriaLibro> libros;
	
	public Categoria(String categoria, String descripcion, List<CategoriaLibro> libros) {
		super();
		this.categoria = categoria;
		this.descripcion = descripcion;
		this.libros = libros;
	}

	public Categoria() {
		super();
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public List<CategoriaLibro> getLibros() {
		return libros;
	}

	public void setLibros(List<CategoriaLibro> libros) {
		this.libros = libros;
	}
	
}
