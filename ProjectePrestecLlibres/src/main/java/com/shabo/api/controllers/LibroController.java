/**
 * 
 */
package com.shabo.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
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

/**
 * @author Fenrir
 *
 */
@RestController
@RequestMapping("/api")
public class LibroController {
	
	@Autowired
	private LibroServiceImpl libroesServiceImpl;
	
	@GetMapping("/libros")
	public List<Libro> listarLibro(){
		return libroesServiceImpl.mostrarLibros();
	}
	
	@GetMapping("/libros/{id}")
	public Libro mostrarLibroID(@PathVariable(name="id") String id){
		return libroesServiceImpl.mostrarLibroID(id);
	}
	
	@PutMapping("/libros/crear")
	public Libro crearLibro(@RequestBody Libro libro) {
		return libroesServiceImpl.crearLibro(libro);
	}
	
	@PostMapping("/libros/modificar/{id}")
	public Libro modificarLibro(@PathVariable(name="id") String id, @RequestBody Libro libro) {
		Libro libroSeleccionado = new Libro();
		Libro libroModificado = new Libro();
		
		libroSeleccionado = libroesServiceImpl.mostrarLibroID(id);
		libroSeleccionado.setAutor(libro.getAutor());
		libroSeleccionado.setDescripcion(libro.getDescripcion());
		libroSeleccionado.setTitulo(libro.getTitulo());
		
		return libroModificado = libroesServiceImpl.modificarLibro(libroSeleccionado);
	}
	
	@DeleteMapping("libro/eliminar/{id}")
	public void eliminarEquioi(@PathVariable(name="id") String id) {
		libroesServiceImpl.eliminarLibro(id);
		
	}
	
}
