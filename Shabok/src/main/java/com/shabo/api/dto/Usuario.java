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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="Usuarios")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler", "document"})
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	@JsonIgnore
	@Column(name="password")
	private String password;
	@Column(name="username")
	private String username;
	@Column(name="email")
	private String email;
	@Column(name="nombre")
	private String nombre;
	@Column(name="role")
	String role;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "libro")
	@JsonIgnore
	private List<UsuarioLibro> listaLibros;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "usuario")
	@JsonIgnore
	private List<Prestamo> prestamos;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "usuario")
	@JsonIgnore
	private List<Comentario> comentarios;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "usuario")
	@JsonIgnore
	private List<Valoracion> puntuaciones;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "emisor")
	@JsonIgnore
	private List<Chat> chatsEnviados;
	@OneToMany(cascade = CascadeType.ALL , fetch = FetchType.LAZY, mappedBy = "receptor")
	@JsonIgnore
	private List<Chat> chatsRecividos;

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
		this.chatsRecividos = chatsRecividos;
	}

	public Usuario(String username, String password, String nombre, String email) {
		super();
		this.username = username;
		this.password = password;
		this.nombre = nombre;
		this.email = email;
	}



	public Usuario() {
		super();
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
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
		return this.chatsRecividos;
	}

	public void setChatsRecividos(List<Chat> chatsRecividos) {
		this.chatsRecividos = chatsRecividos;
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
}
