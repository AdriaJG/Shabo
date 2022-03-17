package com.shabo.api.controllers;

import com.shabo.api.dao.IUsuarioDAO;
import com.shabo.api.dto.Usuario;
import static com.shabo.api.statics.Roles.ADMINISTRATOR;

import org.springframework.security.core.Authentication;

public class Verificador {
	Usuario usuario;
	IUsuarioDAO iUsuarioDAO;
	
	public Verificador(Authentication authentication) {
		super();
		System.out.println(authentication);
		this.usuario = iUsuarioDAO.findByNombre(authentication.getName());
	}
	
	public Verificador() {
		
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public void SetUsuarioAuth(Authentication authentication) {
		this.usuario = iUsuarioDAO.findByNombre(authentication.getName());
	}
	
	public boolean isRecursoPropietario(Usuario recurso) {
		return this.usuario == recurso || this.usuario.getRole().equals(ADMINISTRATOR);
	}
	
	public Usuario obtenerUsuarioNombre(String nombre) {
		return iUsuarioDAO.findByUsername(nombre);
	}
}
