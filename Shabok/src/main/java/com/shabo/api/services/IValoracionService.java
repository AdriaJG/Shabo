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
	
	public  Valoracion mostrarValoracionID(long id);
	
	public Valoracion crearValoracion(Valoracion valoracion);
	
	public Valoracion modificarValoracion(Valoracion valoracion);
	
	public void eliminarValoracion(long id);
}
