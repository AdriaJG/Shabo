/**
 * 
 */
package com.shabo.api.dto;

import java.io.Serializable;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author Fenrir
 *
 */
public class CategoriaLibroID implements Serializable {
	@ManyToOne
	@JoinColumn(name="ISBN")
	private Libro libro;
	@ManyToOne
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
