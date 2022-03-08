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

import com.shabo.api.dto.Libro;
import com.shabo.api.services.LibroServiceImpl;
import com.shabo.api.services.UsuarioLibroServiceImpl;
import com.shabo.api.services.UsuarioServiceImpl;

/**
 * @author Fenrir
 *
 */
@RestController
@RequestMapping("/api")
public class LibroController {
	
	@Autowired
	private LibroServiceImpl librosServiceImpl;
	
	@GetMapping("/libros")
	public List<Libro> listarLibro(){
		return librosServiceImpl.mostrarLibros();
	}
	
	@GetMapping("/libros/{id}")
	public Libro mostrarLibroID(@PathVariable(name="id") String id){
		return librosServiceImpl.mostrarLibroID(id);
	}
	
	@PutMapping("/libros/crear")
	public Libro crearLibro(@RequestBody Libro libro) {
		return librosServiceImpl.crearLibro(libro);
	}
	
	@PostMapping("/libros/modificar/{id}")
	public Libro modificarLibro(@PathVariable(name="id") String id, @RequestBody Libro libro) {
		Libro libroSeleccionado = new Libro();
		Libro libroModificado = new Libro();
		
		libroSeleccionado = librosServiceImpl.mostrarLibroID(id);
		libroSeleccionado.setAutor(libro.getAutor());
		libroSeleccionado.setDescripcion(libro.getDescripcion());
		libroSeleccionado.setTitulo(libro.getTitulo());
		
		return libroModificado = librosServiceImpl.modificarLibro(libroSeleccionado);
	}
	
	@DeleteMapping("libro/eliminar/{id}")
	public void eliminarEquioi(@PathVariable(name="id") String id) {
		librosServiceImpl.eliminarLibro(id);
		
	}
	
}
