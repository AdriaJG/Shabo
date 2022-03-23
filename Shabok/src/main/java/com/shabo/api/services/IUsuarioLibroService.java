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
	
	public UsuarioLibro mostrarUsuarioLibroID(long id);
	
	public UsuarioLibro crearUsuarioLibro(UsuarioLibro propietario);
	
	public UsuarioLibro modificarUsuarioLibro(UsuarioLibro propietario);
	
	public void eliminarUsuarioLibro(long id);
}
