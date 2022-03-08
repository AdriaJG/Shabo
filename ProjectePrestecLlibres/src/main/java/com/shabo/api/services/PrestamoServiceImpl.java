/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabo.api.dao.IPrestamoDAO;
import com.shabo.api.dto.Prestamo;

/**
 * @author Fenrir
 *
 */
@Service
public class PrestamoServiceImpl implements IPrestamoService {
	
	@Autowired
	IPrestamoDAO iPrestamoDAO;

	@Override
	public List<Prestamo> mostrarPrestamos() {
		// TODO Auto-generated method stub
		return iPrestamoDAO.findAll();
	}

	@Override
	public Prestamo mostrarPrestamoID(int id) {
		// TODO Auto-generated method stub
		return iPrestamoDAO.findById(id).get();
	}

	@Override
	public Prestamo crearPrestamo(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return iPrestamoDAO.save(prestamo);
	}

	@Override
	public Prestamo modificarPrestamo(Prestamo prestamo) {
		// TODO Auto-generated method stub
		return iPrestamoDAO.save(prestamo);
	}

	@Override
	public void eliminarPrestamo(int id) {
		iPrestamoDAO.deleteById(id);
		
	}
	
	
}
