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

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="Categorialibro")
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
