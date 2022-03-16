/**
 * 
 */
package com.shabo.api.dto;

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
@Table(name="Prestamo")
public class Prestamo {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="propietario_id")
	private UsuarioLibro libro;
	@ManyToOne
	@JoinColumn(name="usuario_prestamo")
	private Usuario usuario;
	
	public Prestamo(UsuarioLibro libro, Usuario usuario) {
		super();
		this.libro = libro;
		this.usuario = usuario;
	}

	public Prestamo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public UsuarioLibro getLibro() {
		return libro;
	}

	public void setLibro(UsuarioLibro libro) {
		this.libro = libro;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}
