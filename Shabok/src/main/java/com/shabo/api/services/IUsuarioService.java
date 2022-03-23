/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import com.shabo.api.dto.Usuario;

/**
 * @author Fenrir
 *
 */
public interface IUsuarioService {
	public List<Usuario> mostrarUsuarios();
	
	public Usuario mostrarUsuarioID(long id);
	
	public Usuario buscarUsuarioNombre(String nombre);
	
	public Usuario buscarUsuarioUsername(String nombre);
	
	public Usuario crearUsuario(Usuario usuario);
	
	public Usuario modificarUsuario(Usuario usuario);
	
	public void eliminarUsuario(long id);
}
