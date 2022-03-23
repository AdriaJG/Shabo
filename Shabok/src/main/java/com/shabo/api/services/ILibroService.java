/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import com.shabo.api.dto.Libro;
import com.shabo.api.dto.UsuarioLibro;
import com.shabo.api.dto.Usuario;

/**
 * @author Fenrir
 *
 */
public interface ILibroService {
	public List<Libro> mostrarLibros();
	
	public  Libro mostrarLibroID(int id);
	
	public Libro crearLibro(Libro libro);
	
	public Libro modificarLibro(Libro libro);
	
	public void eliminarLibro(int id);
	
	public boolean esPropietario(Libro libro, Usuario usuario);
}
