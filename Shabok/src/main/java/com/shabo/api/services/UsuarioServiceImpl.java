/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabo.api.dao.IUsuarioDAO;
import com.shabo.api.dto.Usuario;

/**
 * @author Fenrir
 *
 */
@Service
public class UsuarioServiceImpl implements IUsuarioService {
	
	@Autowired
	IUsuarioDAO iUsuarioDAO;

	@Override
	public List<Usuario> mostrarUsuarios() {
		// TODO Auto-generated method stub
		return iUsuarioDAO.findAll();
	}

	@Override
	public Usuario mostrarUsuarioID(long id) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.findById(id).get();
	}

	@Override
	public Usuario crearUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public Usuario modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.save(usuario);
	}

	@Override
	public void eliminarUsuario(long id) {
		iUsuarioDAO.deleteById(id);
		
	}

	@Override
	public Usuario buscarUsuarioUsername(String nombre) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.findByUsername(nombre);
	}

	@Override
	public Usuario buscarUsuarioNombre(String nombre) {
		// TODO Auto-generated method stub
		return iUsuarioDAO.findByNombre(nombre);
	}
	
	
	
}
