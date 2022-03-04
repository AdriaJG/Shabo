/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import com.shabo.api.dto.UsuarioLibro;

/**
 * @author Fenrir
 *
 */
public interface IUsuarioLibroService {
	public List<UsuarioLibro> mostrarUsuarioLibros();
	
	public UsuarioLibro mostrarUsuarioLibroID(int id);
	
	public UsuarioLibro crearUsuarioLibro(UsuarioLibro propietario);
	
	public UsuarioLibro modificarUsuarioLibro(int id, UsuarioLibro propietario);
	
	public void eliminarUsuarioLibro(int id);
}
