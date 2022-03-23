/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabo.api.dao.IValoracionDAO;
import com.shabo.api.dto.Valoracion;

/**
 * @author Fenrir
 *
 */
@Service
public class ValoracionServiceImpl implements IValoracionService {
	
	@Autowired
	IValoracionDAO iValoracionDAO;

	@Override
	public List<Valoracion> mostrarValoracions() {
		// TODO Auto-generated method stub
		return iValoracionDAO.findAll();
	}

	@Override
	public Valoracion mostrarValoracionID(long id) {
		// TODO Auto-generated method stub
		return iValoracionDAO.findById(id).get();
	}

	@Override
	public Valoracion crearValoracion(Valoracion valoracion) {
		// TODO Auto-generated method stub
		return iValoracionDAO.save(valoracion);
	}

	@Override
	public Valoracion modificarValoracion(Valoracion valoracion) {
		// TODO Auto-generated method stub
		return iValoracionDAO.save(valoracion);
	}

	@Override
	public void eliminarValoracion(long id) {
		iValoracionDAO.deleteById(id);
		
	}
	
	
}
