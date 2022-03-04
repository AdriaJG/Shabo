/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import com.shabo.api.dto.Comentario;

/**
 * @author Fenrir
 *
 */
public interface IComentarioService {
	public List<Comentario> mostrarComentarios();
	
	public  Comentario mostrarComentarioID(int id);
	
	public Comentario crearComentario(Comentario comentario);
	
	public Comentario modificarComentario(int id, Comentario comentario);
	
	public void eliminarComentario(int id);
}
