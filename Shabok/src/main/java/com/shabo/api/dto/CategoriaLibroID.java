/**
 * 
 */
package com.shabo.api.dto;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Fenrir
 *
 */
public class CategoriaLibroID implements Serializable {
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="ISBN")
	private Libro libro;
	@ManyToOne(cascade = CascadeType.ALL , fetch = FetchType.LAZY)
	@JoinColumn(name="categoria")
	private Categoria categoria;
	
	public CategoriaLibroID(Libro libro, Categoria categoria) {
		super();
		this.libro = libro;
		this.categoria = categoria;
	}

	public CategoriaLibroID() {
		super();
	}
	
	
}
