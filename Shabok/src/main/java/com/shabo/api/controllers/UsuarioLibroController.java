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
	private Verificador verificador = new Verificador();
	
	IUsuarioDAO iUsuarioDAO;
	
	@Autowired
	private LibroServiceImpl libroServiceImpl;
	
	@Autowired
	private UsuarioLibroServiceImpl usuarioLibrosServiceImpl;
	
	public UsuarioLibroController(IUsuarioDAO iU) {
		// TODO Auto-generated constructor stub
		this.iUsuarioDAO = iU;
	}

	@GetMapping("/usuarioLibros")
	public List<UsuarioLibro> listarUsuarioLibro() {
		return usuarioLibrosServiceImpl.mostrarUsuarioLibros();
	}

	@GetMapping("/usuarioObtenerLibros/{id}")
	public UsuarioLibro mostrarUsuarioLibroID(@PathVariable(name = "id") long id) {
		return usuarioLibrosServiceImpl.mostrarUsuarioLibroID(id);
	}
	
	@GetMapping("/libroUsuarios/{libro}")
	public List<Usuario> mostrarUsuariosLibro(@PathVariable(name = "libro") long libro) {
		List<Usuario> usuarios = new ArrayList<>();
		List<UsuarioLibro> datos = libroServiceImpl.mostrarLibroID(libro).getListaPropietarios();
		for (int i = 0; i < datos.size(); i++) {
			usuarios.add(datos.get(i).getUsuario());
		}
		return usuarios;
	}

	@PostMapping("/usuarioLibros/crear/{isbn}")
	public UsuarioLibro crearUsuarioLibro(@PathVariable(name = "isbn") long isbn, Authentication authentication) {
		UsuarioLibro crearLibroUsuario = new UsuarioLibro();
		crearLibroUsuario.setUsuario(this.iUsuarioDAO.findByUsername(authentication.getName()));
		crearLibroUsuario.setLibro(this.libroServiceImpl.mostrarLibroID(isbn));
		return usuarioLibrosServiceImpl.crearUsuarioLibro(crearLibroUsuario);
	}

	@PutMapping("/usuarioLibros/modificar/{id}")
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
	
	@GetMapping("/libroObtenerUsuarios/{usuario}")
	public List<Libro> mostrarLibrosUsuario(@PathVariable(name = "usuario") String usuario) {
		List<Libro> libros = new ArrayList<Libro>();
		Usuario datos = iUsuarioDAO.findByUsername(usuario);
		List<UsuarioLibro> librosUsuario = usuarioLibrosServiceImpl.mostrarLibrosUsuario(datos);
		for (int i = 0; i < librosUsuario.size(); i++) {
			libros.add(librosUsuario.get(i).getLibro());
		}
		return libros;
		
	}

	@DeleteMapping("usuarioLibro/eliminar/{id}")
	public void eliminarUsuarioLibro(@PathVariable(name = "id") long id, Authentication authentication) {
		this.verificador.SetUsuarioAuth(authentication);
		if(this.verificador.isRecursoPropietario(usuarioLibrosServiceImpl.mostrarUsuarioLibroID(id).getUsuario())) {
		usuarioLibrosServiceImpl.eliminarUsuarioLibro(id);
		}
	}

}
