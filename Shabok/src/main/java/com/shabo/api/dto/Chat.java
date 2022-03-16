/**
 * 
 */
package com.shabo.api.dto;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.shabo.api.statics.EstadoChat;

/**
 * @author Fenrir
 *
 */
@Entity
@Table(name="Chatea")
public class Chat {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(name="mensaje")
	private String mensaje;
	@Column(name="estado")
	private EstadoChat estado;
	@Column(name="hora")
	private Date horaEnviado;
	@ManyToOne
	@JoinColumn(name="usuario_emisor")
	private UsuarioLibro emisor;
	@ManyToOne
	@JoinColumn(name="usuario_receptor")
	private Usuario receptor;
	
	public Chat(String mensaje, EstadoChat estado, Date horaEnviado, UsuarioLibro emisor, Usuario receptor) {
		super();
		this.mensaje = mensaje;
		this.estado = estado;
		this.horaEnviado = horaEnviado;
		this.emisor = emisor;
		this.receptor = receptor;
	}

	public Chat() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	public EstadoChat getEstado() {
		return estado;
	}

	public void setEstado(EstadoChat estado) {
		this.estado = estado;
	}

	public Date getHoraEnviado() {
		return horaEnviado;
	}

	public void setHoraEnviado(Date horaEnviado) {
		this.horaEnviado = horaEnviado;
	}

	public UsuarioLibro getEmisor() {
		return emisor;
	}

	public void setEmisor(UsuarioLibro emisor) {
		this.emisor = emisor;
	}

	public Usuario getReceptor() {
		return receptor;
	}

	public void setReceptor(Usuario receptor) {
		this.receptor = receptor;
	}
	
}