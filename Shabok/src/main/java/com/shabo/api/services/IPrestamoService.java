/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import com.shabo.api.dto.Prestamo;

/**
 * @author Fenrir
 *
 */
public interface IPrestamoService {
	public List<Prestamo> mostrarPrestamos();
	
	public  Prestamo mostrarPrestamoID(long id);
	
	public Prestamo crearPrestamo(Prestamo prestamo);
	
	public Prestamo modificarPrestamo(Prestamo prestamot);
	
	public void eliminarPrestamo(long id);
}
