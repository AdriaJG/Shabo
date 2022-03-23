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

import com.shabo.api.dto.Categoria;
import com.shabo.api.services.CategoriaServiceImpl;
import com.shabo.api.services.UsuarioServiceImpl;

/**
 * @author Fenrir
 *
 */
@RestController
@RequestMapping("/api")
public class CategoriaController {
	
	@Autowired
	private CategoriaServiceImpl categoriasServiceImpl;
	
	@GetMapping("/categorias")
	public List<Categoria> listarCategoria(){
		return categoriasServiceImpl.mostrarCategorias();
	}
	
	@GetMapping("/categorias/{id}")
	public Categoria mostrarCategoriaID(@PathVariable(name="id") long id){
		return categoriasServiceImpl.mostrarCategoriaID(id);
	}
	
	@PutMapping("/categorias/crear")
	public Categoria crearCategoria(@RequestBody Categoria categoria) {
		return categoriasServiceImpl.crearCategoria(categoria);
	}
	
	@PostMapping("/categorias/modificar/{id}")
	public Categoria modificarCategoria(@PathVariable(name="id") long id, @RequestBody Categoria categoria) {
		Categoria categoriaSeleccionado = new Categoria();
		Categoria categoriaModificado = new Categoria();
		
		categoriaSeleccionado = categoriasServiceImpl.mostrarCategoriaID(id);
		categoriaSeleccionado.setCategoria(categoria.getCategoria());
		categoriaSeleccionado.setDescripcion(categoria.getDescripcion());
		
		return categoriaModificado = categoriasServiceImpl.modificarCategoria(categoriaSeleccionado);
	}
	
	@DeleteMapping("categoria/eliminar/{id}")
	public void eliminarEquioi(@PathVariable(name="id") long id) {
		categoriasServiceImpl.eliminarCategoria(id);
		
	}
	
}
