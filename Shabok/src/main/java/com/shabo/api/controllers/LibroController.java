/**
 * 
 */
package com.shabo.api.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	Logger logger = LoggerFactory.getLogger("Pruebas");
	@Autowired
	private LibroServiceImpl librosServiceImpl;
	
	@GetMapping("/libros")
	public List<Libro> listarLibro(){
		return librosServiceImpl.mostrarLibros();
	}
	
	@GetMapping("/libros/{id}")
	public Libro mostrarLibroID(@PathVariable(name="id") long id){
		return librosServiceImpl.mostrarLibroID(id);
	}
	
	@PutMapping("/libros/crear")
	public Libro crearLibro(@RequestBody minilibro libro) {
		logger.info(String.valueOf(libro.getISBN()));
		Libro crearLibro = new Libro(libro.getISBN(), libro.getNombre(), libro.getDescripcion(), libro.getAutor());
		return librosServiceImpl.crearLibro(crearLibro);
	}
	
	@PostMapping("/libros/modificar/{id}")
	public Libro modificarLibro(@PathVariable(name="id") long id, @RequestBody Libro libro) {
		Libro libroSeleccionado = new Libro();
		Libro libroModificado = new Libro();
		
		libroSeleccionado = librosServiceImpl.mostrarLibroID(id);
		libroSeleccionado.setAutor(libro.getAutor());
		libroSeleccionado.setDescripcion(libro.getDescripcion());
		libroSeleccionado.setTitulo(libro.getTitulo());
		
		return libroModificado = librosServiceImpl.modificarLibro(libroSeleccionado);
	}
	
	@DeleteMapping("libro/eliminar/{id}")
	public void eliminarEquioi(@PathVariable(name="id") long id) {
		librosServiceImpl.eliminarLibro(id);
		
	}
	
}

class minilibro{
	long ISBN;
	String nombre;
	String autor;
	String descripcion;
	
	public minilibro() {
		super();
	}
	public minilibro(long ISBN, String nombre, String autor, String descripcion) {
		super();
		this.ISBN = ISBN;
		this.nombre = nombre;
		this.autor = autor;
		this.descripcion = descripcion;
	}
	public long getISBN() {
		return ISBN;
	}
	public void setISBN(long iSBN) {
		ISBN = iSBN;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getAutor() {
		return autor;
	}
	public void setAutor(String autor) {
		this.autor = autor;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}