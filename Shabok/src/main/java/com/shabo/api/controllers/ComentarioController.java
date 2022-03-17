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

import com.shabo.api.dto.Comentario;
import com.shabo.api.services.ComentarioServiceImpl;
import com.shabo.api.services.UsuarioServiceImpl;

/**
 * @author Fenrir
 *
 */
@RestController
@RequestMapping("/api")
public class ComentarioController {

	private Verificador verificador;

	@Autowired
	private ComentarioServiceImpl comentariosServiceImpl;

	@GetMapping("/comentarios")
	public List<Comentario> listarComentario() {
		return comentariosServiceImpl.mostrarComentarios();
	}

	@GetMapping("/comentarios/{id}")
	public Comentario mostrarComentarioID(@PathVariable(name = "id") int id) {
		return comentariosServiceImpl.mostrarComentarioID(id);
	}

	@PutMapping("/comentarios/crear")
	public Comentario crearComentario(@RequestBody Comentario comentario) {
		return comentariosServiceImpl.crearComentario(comentario);
	}

	@PostMapping("/comentarios/modificar/{id}")
	public Comentario modificarComentario(@PathVariable(name = "id") int id, @RequestBody String comentario,
			Authentication authentication) {

		this.verificador.SetUsuarioAuth(authentication);
		if (verificador.isRecursoPropietario(comentariosServiceImpl.mostrarComentarioID(id).getUsuario())) {
			Comentario comentarioSeleccionado = new Comentario();
			Comentario comentarioModificado = new Comentario();

			comentarioSeleccionado = comentariosServiceImpl.mostrarComentarioID(id);
			comentarioSeleccionado.setMensaje(comentario);

			return comentarioModificado = comentariosServiceImpl.modificarComentario(comentarioSeleccionado);
		}
		return null;
	}

	@DeleteMapping("comentario/eliminar/{id}")
	public void eliminarEquioi(@PathVariable(name = "id") int id, Authentication authentication) {
		this.verificador.SetUsuarioAuth(authentication);
		if (verificador.isRecursoPropietario(comentariosServiceImpl.mostrarComentarioID(id).getUsuario())) {
			comentariosServiceImpl.eliminarComentario(id);
		}
	}

}
