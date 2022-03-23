/**
 * 
 */
package com.shabo.api.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabo.api.dao.ILibroDAO;
import com.shabo.api.dto.Libro;
import com.shabo.api.dto.Usuario;
import com.shabo.api.dto.UsuarioLibro;

/**
 * @author Fenrir
 *
 */
@Service
public class LibroServiceImpl implements ILibroService {
	
	@Autowired
	ILibroDAO iLibroDAO;

	@Override
	public List<Libro> mostrarLibros() {
		// TODO Auto-generated method stub
		return iLibroDAO.findAll();
	}

	@Override
	public Libro mostrarLibroID(long id) {
		// TODO Auto-generated method stub
		return iLibroDAO.findById(id).get();
	}

	@Override
	public Libro crearLibro(Libro libro) {
		// TODO Auto-generated method stub
		return iLibroDAO.save(libro);
	}

	@Override
	public Libro modificarLibro(Libro libro) {
		// TODO Auto-generated method stub
		return iLibroDAO.save(libro);
	}

	@Override
	public void eliminarLibro(long id) {
		iLibroDAO.deleteById(id);
		
	}

	@Override
	public boolean esPropietario(Libro libro, Usuario usuario) {
		// TODO Auto-generated method stub
		List<UsuarioLibro> propietarios = libro.getListaPropietarios();
		for (int i = 0; i < propietarios.size(); i++) {
			if(propietarios.get(i).getUsuario() == usuario) {
				return true;
			}
		}
		return false;
	}
	
	
}
