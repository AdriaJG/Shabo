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
	
	public  Categoria mostrarCategoriaID(String id);
	
	public Categoria crearCategoria(Categoria categoria);
	
	public Categoria modificarCategoria(String id,Categoria categoria);
	
	public void eliminarCategoria(String id);
}
