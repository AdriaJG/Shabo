/**
 * 
 */
package com.shabo.api.dto;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="UsuarioLibro")
public class UsuarioLibro {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name="ISBN")
	private Libro libro;
	@ManyToOne
	@JoinColumn(name="usuario_id")
	private Usuario usuario;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Prestamo> prestamos;
	
	public UsuarioLibro(Libro libro, Usuario usuario, List<Prestamo> prestamos) {
		super();
		this.libro = libro;
		this.usuario = usuario;
		this.prestamos = prestamos;
	}

	public UsuarioLibro() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
	}
}
