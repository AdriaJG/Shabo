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

import com.shabo.api.dto.CategoriaLibro;
import com.shabo.api.dto.CategoriaLibroID;
import com.shabo.api.services.CategoriaLibroServiceImpl;
import com.shabo.api.services.UsuarioServiceImpl;

/**
 * @author Fenrir
 *
 */
@RestController
@RequestMapping("/api")
public class CategoriaLibroController {
	
	@Autowired
	private CategoriaLibroServiceImpl categoriaLibrosServiceImpl;
	
	@GetMapping("/categoriaLibros")
	public List<CategoriaLibro> listarCategoriaLibro(){
		return categoriaLibrosServiceImpl.mostrarCategoriaLibros();
	}
	
	@GetMapping("/categoriaLibros/{id}")
	public CategoriaLibro mostrarCategoriaLibroID(@PathVariable(name="id") CategoriaLibroID id){
		return categoriaLibrosServiceImpl.mostrarCategoriaLibroID(id);
	}
	
	@PutMapping("/categoriaLibros/crear")
	public CategoriaLibro crearCategoriaLibro(@RequestBody CategoriaLibro categoriaLibro) {
		return categoriaLibrosServiceImpl.crearCategoriaLibro(categoriaLibro);
	}
	
	@PostMapping("/categoriaLibros/modificar/{id}")
	public CategoriaLibro modificarCategoriaLibro(@PathVariable(name="id") CategoriaLibroID id, @RequestBody CategoriaLibro categoriaLibro) {
		CategoriaLibro categoriaLibroSeleccionado = new CategoriaLibro();
		CategoriaLibro categoriaLibroModificado = new CategoriaLibro();
		
		categoriaLibroSeleccionado = categoriaLibrosServiceImpl.mostrarCategoriaLibroID(id);
		categoriaLibroSeleccionado.setCategoria(categoriaLibro.getCategoria());                                                     
		categoriaLibroSeleccionado.setLibro(categoriaLibro.getLibro());
		
		return categoriaLibroModificado = categoriaLibrosServiceImpl.modificarCategoriaLibro(categoriaLibroSeleccionado);
	}
	
	@DeleteMapping("categoriaLibro/eliminar/{id}")
	public void eliminarEquioi(@PathVariable(name="id") CategoriaLibroID id) {
		categoriaLibrosServiceImpl.eliminarCategoriaLibro(id);
		
	}
	
}
