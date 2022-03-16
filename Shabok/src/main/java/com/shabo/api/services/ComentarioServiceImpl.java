/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabo.api.dao.IComentarioDAO;
import com.shabo.api.dto.Comentario;

/**
 * @author Fenrir
 *
 */
@Service
public class ComentarioServiceImpl implements IComentarioService {
	
	@Autowired
	IComentarioDAO iComentarioDAO;

	@Override
	public List<Comentario> mostrarComentarios() {
		// TODO Auto-generated method stub
		return iComentarioDAO.findAll();
	}

	@Override
	public Comentario mostrarComentarioID(int id) {
		// TODO Auto-generated method stub
		return iComentarioDAO.findById(id).get();
	}

	@Override
	public Comentario crearComentario(Comentario comentario) {
		// TODO Auto-generated method stub
		return iComentarioDAO.save(comentario);
	}

	@Override
	public Comentario modificarComentario(Comentario comentario) {
		// TODO Auto-generated method stub
		return iComentarioDAO.save(comentario);
	}

	@Override
	public void eliminarComentario(int id) {
		iComentarioDAO.deleteById(id);
		
	}
	
	
}
