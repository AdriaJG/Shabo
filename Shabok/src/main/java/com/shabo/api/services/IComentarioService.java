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
	
	public  Comentario mostrarComentarioID(long id);
	
	public Comentario crearComentario(Comentario comentario);
	
	public Comentario modificarComentario(Comentario comentario);
	
	public void eliminarComentario(long id);
}
