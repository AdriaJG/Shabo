/**
 * 
 */
package com.shabo.api.controllers;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shabo.api.dao.IUsuarioDAO;
import com.shabo.api.dto.Libro;
import com.shabo.api.dto.Usuario;
import com.shabo.api.dto.UsuarioLibro;
import com.shabo.api.services.LibroServiceImpl;
import com.shabo.api.services.UsuarioLibroServiceImpl;
import com.shabo.api.services.UsuarioServiceImpl;

/**
 * @author Fenrir
 *
 */
@RestController
@RequestMapping("/api")
public class UsuarioLibroController {
	Logger logger = LoggerFactory.getLogger("Pruebas");
	private Verificador verificador;
	
	@Autowired
	private LibroServiceImpl libroServiceImpl;
	
	@Autowired
	private UsuarioServiceImpl usuarioServiceImpl;
	
	@Autowired
	private UsuarioLibroServiceImpl usuarioLibrosServiceImpl;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/usuarioLibros")
	public List<UsuarioLibro> listarUsuarioLibro() {
		return usuarioLibrosServiceImpl.mostrarUsuarioLibros();
	}

	@GetMapping("/usuarioObtenerLibros/{id}")
	public UsuarioLibro mostrarUsuarioLibroID(@PathVariable(name = "id") long id) {
		return usuarioLibrosServiceImpl.mostrarUsuarioLibroID(id);
	}
	
	@GetMapping("/libroObtenerUsuarios/{usuario}")
	public List<Libro> mostrarLibrosUsuario(@PathVariable(name = "usuario") String usuario) {
		List<Libro> libros = new ArrayList<>();
		this.logger.info(usuario);
		List<UsuarioLibro> datos = usuarioServiceImpl.buscarUsuarioUsername(usuario).getListaLibros();
		for (int i = 0; i < datos.size(); i++) {
			libros.add(datos.get(i).getLibro());
		}
		return libros;
	}
	
	@GetMapping("/libroUsuarios/{libro}")
	public List<Usuario> mostrarUsuariosLibro(@PathVariable(name = "libro") Long libro) {
		List<Usuario> usuarios = new ArrayList<>();
		List<UsuarioLibro> datos = libroServiceImpl.mostrarLibroID(libro).getListaPropietarios();
		for (int i = 0; i < datos.size(); i++) {
			usuarios.add(datos.get(i).getUsuario());
		}
		return usuarios;
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
