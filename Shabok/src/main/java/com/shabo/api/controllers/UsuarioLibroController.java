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

import com.shabo.api.dto.UsuarioLibro;
import com.shabo.api.services.UsuarioLibroServiceImpl;
import com.shabo.api.services.UsuarioServiceImpl;

/**
 * @author Fenrir
 *
 */
@RestController
@RequestMapping("/api")
public class UsuarioLibroController {

	private Verificador verificador;

	@Autowired
	private UsuarioLibroServiceImpl usuarioLibrosServiceImpl;

	@GetMapping("/usuarioLibros")
	public List<UsuarioLibro> listarUsuarioLibro() {
		return usuarioLibrosServiceImpl.mostrarUsuarioLibros();
	}

	@GetMapping("/usuarioLibros/{id}")
	public UsuarioLibro mostrarUsuarioLibroID(@PathVariable(name = "id") long id) {
		return usuarioLibrosServiceImpl.mostrarUsuarioLibroID(id);
	}

	@PutMapping("/usuarioLibros/crear")
	public UsuarioLibro crearUsuarioLibro(@RequestBody UsuarioLibro usuarioLibro) {
		return usuarioLibrosServiceImpl.crearUsuarioLibro(usuarioLibro);
	}

	@PostMapping("/usuarioLibros/modificar/{id}")
	public UsuarioLibro modificarUsuarioLibro(@PathVariable(name = "id") long id, @RequestBody UsuarioLibro usuarioLibro,
			Authentication authentication) {

		this.verificador.SetUsuarioAuth(authentication);
		if (this.verificador.isRecursoPropietario(usuarioLibro.getUsuario())) {
			UsuarioLibro usuarioLibroSeleccionado = new UsuarioLibro();
			UsuarioLibro usuarioLibroModificado = new UsuarioLibro();

			usuarioLibroSeleccionado = usuarioLibrosServiceImpl.mostrarUsuarioLibroID(id);
			usuarioLibroSeleccionado.setLibro(usuarioLibro.getLibro());
			usuarioLibroSeleccionado.setPrestamos(usuarioLibro.getPrestamos());

			return usuarioLibroModificado = usuarioLibrosServiceImpl.modificarUsuarioLibro(usuarioLibroSeleccionado);
		}
		return null;
	}

	@DeleteMapping("usuarioLibro/eliminar/{id}")
	public void eliminarUsuarioLibro(@PathVariable(name = "id") long id, Authentication authentication) {
		this.verificador.SetUsuarioAuth(authentication);
		if(this.verificador.isRecursoPropietario(usuarioLibrosServiceImpl.mostrarUsuarioLibroID(id).getUsuario())) {
		usuarioLibrosServiceImpl.eliminarUsuarioLibro(id);
		}
	}

}
