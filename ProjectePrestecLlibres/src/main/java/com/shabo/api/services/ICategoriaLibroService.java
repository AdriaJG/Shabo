/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import com.shabo.api.dto.CategoriaLibro;
import com.shabo.api.dto.CategoriaLibroID;

/**
 * @author Fenrir
 *
 */
public interface ICategoriaLibroService {
	public List<CategoriaLibro> mostrarCategoriaLibros();
	
	public  CategoriaLibro mostrarCategoriaLibroID(CategoriaLibroID id);
	
	public CategoriaLibro crearCategoriaLibro(CategoriaLibro chat);
	
	public CategoriaLibro modificarCategoriaLibro(CategoriaLibroID id,CategoriaLibro chat);
	
	public void eliminarCategoriaLibro(CategoriaLibroID id);
}
