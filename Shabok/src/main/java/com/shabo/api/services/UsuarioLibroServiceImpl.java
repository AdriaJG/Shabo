/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabo.api.dao.IUsuarioLibroDAO;
import com.shabo.api.dto.Usuario;
import com.shabo.api.dto.UsuarioLibro;

/**
 * @author Fenrir
 *
 */
@Service
public class UsuarioLibroServiceImpl implements IUsuarioLibroService {
	
	@Autowired
	IUsuarioLibroDAO iUsuarioLibroDAO;

	@Override
	public List<UsuarioLibro> mostrarUsuarioLibros() {
		// TODO Auto-generated method stub
		return iUsuarioLibroDAO.findAll();
	}

	@Override
	public UsuarioLibro mostrarUsuarioLibroID(long id) {
		// TODO Auto-generated method stub
		return iUsuarioLibroDAO.findById(id).get();
	}

	@Override
	public UsuarioLibro crearUsuarioLibro(UsuarioLibro usuarioLibro) {
		// TODO Auto-generated method stub
		return iUsuarioLibroDAO.save(usuarioLibro);
	}

	@Override
	public UsuarioLibro modificarUsuarioLibro(UsuarioLibro usuarioLibro) {
		// TODO Auto-generated method stub
		return iUsuarioLibroDAO.save(usuarioLibro);
	}

	@Override
	public void eliminarUsuarioLibro(long id) {
		iUsuarioLibroDAO.deleteById(id);
		
	}

	@Override
	public List<UsuarioLibro> mostrarLibrosUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return iUsuarioLibroDAO.findByUsuario(usuario);
	}
	
	
}
