/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import com.shabo.api.dto.Valoracion;

/**
 * @author Fenrir
 *
 */
public interface IValoracionService {
	public List<Valoracion> mostrarValoracions();
	
	public  Valoracion mostrarValoracionID(int id);
	
	public Valoracion crearValoracion(Valoracion valoracion);
	
	public Valoracion modificarValoracion(int id, Valoracion valoracion);
	
	public void eliminarValoracion(int id);
}
