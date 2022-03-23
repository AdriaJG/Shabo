/**
 * 
 */
package com.shabo.api.dto;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="categorialibro")
@IdClass(CategoriaLibroID.class)
public class CategoriaLibro {
	@Id
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="ISBN")
	private Libro libro;
	@Id
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="categoria")
	private Categoria categoria;
	
	public CategoriaLibro(Libro libro, Categoria categoria) {
		super();
		this.libro = libro;
		this.categoria = categoria;
	}

	public CategoriaLibro() {
		super();
	}

	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
}
