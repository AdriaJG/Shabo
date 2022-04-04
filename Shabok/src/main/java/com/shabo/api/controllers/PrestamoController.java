/**
 * 
 */
package com.shabo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shabo.api.dto.Prestamo;
import com.shabo.api.services.PrestamoServiceImpl;
import com.shabo.api.services.UsuarioServiceImpl;

/**
 * @author Fenrir
 *
 */
@RestController
@RequestMapping("/api")
public class PrestamoController {
	
	@Autowired
	private PrestamoServiceImpl prestamosServiceImpl;
	
	@GetMapping("/prestamos")
	public List<Prestamo> listarPrestamo(){
		return prestamosServiceImpl.mostrarPrestamos();
	}
	
	@GetMapping("/prestamos/{id}")
	public Prestamo mostrarPrestamoID(@PathVariable(name="id") long id){
		return prestamosServiceImpl.mostrarPrestamoID(id);
	}
	
	@PostMapping("/prestamos/crear")
	public Prestamo crearPrestamo(@RequestBody Prestamo prestamo, Authentication usuario){
		return prestamosServiceImpl.crearPrestamo(prestamo);
	}
	
	@PostMapping("/prestamos/modificar/{id}")
	public Prestamo modificarPrestamo(@PathVariable(name="id") long id, @RequestBody String prestamo) {
		Prestamo prestamoSeleccionado = new Prestamo();
		Prestamo prestamoModificado = new Prestamo();
		
		prestamoSeleccionado = prestamosServiceImpl.mostrarPrestamoID(id);
		//prestamoSeleccionado.set;
		
		return prestamoModificado = prestamosServiceImpl.modificarPrestamo(prestamoSeleccionado);
	}
	
	@DeleteMapping("prestamo/eliminar/{id}")
	public void eliminarEquioi(@PathVariable(name="id") long id) {
		prestamosServiceImpl.eliminarPrestamo(id);
		
	}
	
}
