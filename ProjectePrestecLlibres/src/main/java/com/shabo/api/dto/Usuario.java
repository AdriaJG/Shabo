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

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="Usuarios")
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="password")
	private String password;
	@Column(name="username")
	String username;
	@Column(name="nombre")
	private String nombre;
	@Column(name="role")
	String role;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "libro")
	private List<UsuarioLibro> listaLibros;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Prestamo> prestamos;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Comentario> comentarios;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "usuario")
	private List<Valoracion> puntuaciones;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "emisor")
	private List<Chat> chatsEnviados;
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "receptor")
	private List<Chat> ChatsRecividos;

	public Usuario(String password, String username, String nombre, String role, List<UsuarioLibro> listaLibros,
			List<Prestamo> prestamos, List<Comentario> comentarios, List<Valoracion> puntuaciones,
			List<Chat> chatsEnviados, List<Chat> chatsRecividos) {
		super();
		this.password = password;
		this.username = username;
		this.nombre = nombre;
		this.role = role;
		this.listaLibros = listaLibros;
		this.prestamos = prestamos;
		this.comentarios = comentarios;
		this.puntuaciones = puntuaciones;
		this.chatsEnviados = chatsEnviados;
		ChatsRecividos = chatsRecividos;
	}

	public Usuario() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<UsuarioLibro> getListaLibros() {
		return listaLibros;
	}

	public void setListaLibros(List<UsuarioLibro> listaLibros) {
		this.listaLibros = listaLibros;
	}

	public List<Prestamo> getPrestamos() {
		return prestamos;
	}

	public void setPrestamos(List<Prestamo> prestamos) {
		this.prestamos = prestamos;
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

	public List<Chat> getChatsEnviados() {
		return chatsEnviados;
	}

	public void setChatsEnviados(List<Chat> chatsEnviados) {
		this.chatsEnviados = chatsEnviados;
	}

	public List<Chat> getChatsRecividos() {
		return ChatsRecividos;
	}

	public void setChatsRecividos(List<Chat> chatsRecividos) {
		ChatsRecividos = chatsRecividos;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
}
