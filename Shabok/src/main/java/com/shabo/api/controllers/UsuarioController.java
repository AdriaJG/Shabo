/**
 * 
 */
package com.shabo.api.controllers;

import org.springframework.web.bind.annotation.RestController;

import com.shabo.api.dao.IUsuarioDAO;
import com.shabo.api.dto.Libro;
import com.shabo.api.dto.Usuario;
import com.shabo.api.dto.UsuarioLibro;

import static com.shabo.api.statics.Roles.*;

import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
/**
 * @author Fenrir
 *
 */
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT,RequestMethod.DELETE}, allowedHeaders = "*")
public class UsuarioController {
	Logger logger = LoggerFactory.getLogger("Pruebas");
	private Verificador verificador;
	
	private IUsuarioDAO iUsuarioDAO;

	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UsuarioController(IUsuarioDAO iUsuarioDAO, BCryptPasswordEncoder bCryptPasswordEncoder) {
		this.iUsuarioDAO = iUsuarioDAO;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}
	
	@GetMapping("/response-entity-builder-with-http-headers")
	public ResponseEntity<String> usingResponseEntityBuilderAndHttpHeaders() {
	    HttpHeaders responseHeaders = new HttpHeaders();
	    responseHeaders.set("Baeldung-Example-Header", 
	      "Value-ResponseEntityBuilderWithHttpHeaders");

	    return ResponseEntity.ok()
	      .headers(responseHeaders)
	      .body("Response with header using ResponseEntity");
	}
	
	@PostMapping("/usuarios")
	public Usuario saveUsuario(@RequestBody Usuario user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		iUsuarioDAO.save(user);
		return user;
	}
	
	@PostMapping("/register")
	public Usuario registrarUsuario(@RequestBody Usuario user) {
		
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));;
		
		Usuario crearUsuario = new Usuario(user.getUsername(), user.getPassword(), user.getNombre(), user.getEmail());
		crearUsuario.setRole(USER);
		iUsuarioDAO.save(crearUsuario);
		return crearUsuario;
	}

	@GetMapping("/usuarios")
	public List<Usuario> getAllUsuarios() {
		return iUsuarioDAO.findAll();
	}

	@GetMapping("/usuarios/{nombre}")
	public Usuario getUsuario(@PathVariable String nombre) {
		return iUsuarioDAO.findByUsername(nombre);
	}
	@GetMapping("/obtenerUsuario")
	public Usuario obtenerUsuarioAutenticado(Authentication authentication) {
		return iUsuarioDAO.findByUsername(authentication.getName());
	}
	
	@GetMapping("usuarios/libros")
	public List<UsuarioLibro> obtenerLibrosUsuario(Authentication authentication){
		return iUsuarioDAO.findByNombre(authentication.getName()).getListaLibros();
	}
	
	@GetMapping("usuariosID/{id}")
	public Usuario getUsuarioID(@PathVariable Long id) {
		return iUsuarioDAO.findById(id).get();
	}
	
	@GetMapping("/api/libroObtenerUsuarios/{usuario}")
	public List<Libro> mostrarLibrosUsuario(@PathVariable(name = "usuario") String usuario) {
		List<Libro> libros = new ArrayList<Libro>();
		Usuario datos = iUsuarioDAO.findByUsername(usuario);
		for (int i = 0; i < datos.getListaLibros().size(); i++) {
			libros.add(datos.getListaLibros().get(i).getLibro());
		}
		return libros;
		
	}
	
	@DeleteMapping("/usuarios/{id}")
	public void eliminarUser(@PathVariable(name="id")long id, Authentication authentication) {
		this.verificador.SetUsuarioAuth(authentication);
		if(verificador.isRecursoPropietario(iUsuarioDAO.getById(id))) {
		iUsuarioDAO.deleteById(id);
		}
	}
}
