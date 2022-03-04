/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabo.api.dao.ICategoriaLibroDAO;
import com.shabo.api.dto.CategoriaLibro;
import com.shabo.api.dto.CategoriaLibroID;

/**
 * @author Fenrir
 *
 */
@Service
public class CategoriaLibroServiceImpl implements ICategoriaLibroService {
	
	@Autowired
	ICategoriaLibroDAO iCategoriaLibroDAO;

	@Override
	public List<CategoriaLibro> mostrarCategoriaLibros() {
		// TODO Auto-generated method stub
		return iCategoriaLibroDAO.findAll();
	}

	@Override
	public CategoriaLibro mostrarCategoriaLibroID(CategoriaLibroID id) {
		// TODO Auto-generated method stub
		return iCategoriaLibroDAO.findById(id).get();
	}

	@Override
	public CategoriaLibro crearCategoriaLibro(CategoriaLibro categoria) {
		// TODO Auto-generated method stub
		return iCategoriaLibroDAO.save(categoria);
	}

	@Override
	public CategoriaLibro modificarCategoriaLibro(CategoriaLibroID id, CategoriaLibro categoria) {
		// TODO Auto-generated method stub
		return iCategoriaLibroDAO.save(categoria);
	}

	@Override
	public void eliminarCategoriaLibro(CategoriaLibroID id) {
		iCategoriaLibroDAO.deleteById(id);
		
	}
	
	
}
