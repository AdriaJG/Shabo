/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabo.api.dao.ILibroDAO;
import com.shabo.api.dto.Libro;

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
	public Libro mostrarLibroID(String id) {
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
	public void eliminarLibro(String id) {
		iLibroDAO.deleteById(id);
		
	}
	
	
}
