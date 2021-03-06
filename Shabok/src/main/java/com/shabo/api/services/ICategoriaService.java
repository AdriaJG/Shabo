/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import com.shabo.api.dto.Categoria;

/**
 * @author Fenrir
 *
 */
public interface ICategoriaService {
	public List<Categoria> mostrarCategorias();
	
	public  Categoria mostrarCategoriaID(long id);
	
	public Categoria crearCategoria(Categoria categoria);
	
	public Categoria modificarCategoria(Categoria categoria);
	
	public void eliminarCategoria(long id);
}
