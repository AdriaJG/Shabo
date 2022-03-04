/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import com.shabo.api.dto.Libro;

/**
 * @author Fenrir
 *
 */
public interface ILibroService {
	public List<Libro> mostrarLibros();
	
	public  Libro mostrarLibroID(String id);
	
	public Libro crearLibro(Libro libro);
	
	public Libro modificarLibro(String id, Libro libro);
	
	public void eliminarLibro(String id);
}
