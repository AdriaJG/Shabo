/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabo.api.dao.ICategoriaDAO;
import com.shabo.api.dto.Categoria;

/**
 * @author Fenrir
 *
 */
@Service
public class CategoriaServiceImpl implements ICategoriaService {
	
	@Autowired
	ICategoriaDAO iCategoriaDAO;

	@Override
	public List<Categoria> mostrarCategorias() {
		// TODO Auto-generated method stub
		return iCategoriaDAO.findAll();
	}

	@Override
	public Categoria mostrarCategoriaID(String id) {
		// TODO Auto-generated method stub
		return iCategoriaDAO.findById(id).get();
	}

	@Override
	public Categoria crearCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return iCategoriaDAO.save(categoria);
	}

	@Override
	public Categoria modificarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		return iCategoriaDAO.save(categoria);
	}

	@Override
	public void eliminarCategoria(String id) {
		iCategoriaDAO.deleteById(id);
		
	}
	
	
}
