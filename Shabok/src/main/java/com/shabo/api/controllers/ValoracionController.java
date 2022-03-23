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

import com.shabo.api.dto.Valoracion;
import com.shabo.api.services.ValoracionServiceImpl;
import com.shabo.api.services.UsuarioServiceImpl;

/**
 * @author Fenrir
 *
 */
@RestController
@RequestMapping("/api")
public class ValoracionController {

	private Verificador verificador;

	@Autowired
	private ValoracionServiceImpl valoracionesServiceImpl;

	@GetMapping("/valoraciones")
	public List<Valoracion> listarValoracion() {
		return valoracionesServiceImpl.mostrarValoracions();
	}

	@GetMapping("/valoraciones/{id}")
	public Valoracion mostrarValoracionID(@PathVariable(name = "id") long id) {
		return valoracionesServiceImpl.mostrarValoracionID(id);
	}

	@PutMapping("/valoraciones/crear")
	public Valoracion crearValoracion(@RequestBody Valoracion valoracion) {
		return valoracionesServiceImpl.crearValoracion(valoracion);
	}

	@PostMapping("/valoraciones/modificar/{id}")
	public Valoracion modificarValoracion(@PathVariable(name = "id") long id, @RequestBody Valoracion valoracion,
			Authentication authentication) {

		this.verificador.SetUsuarioAuth(authentication);
		if (verificador.isRecursoPropietario(valoracionesServiceImpl.mostrarValoracionID(id).getUsuario())) {
			Valoracion valoracionSeleccionado = new Valoracion();
			Valoracion valoracionModificado = new Valoracion();
			valoracionSeleccionado = valoracionesServiceImpl.mostrarValoracionID(id);
			valoracionSeleccionado.setValoracion(valoracion.getValoracion());
			return valoracionModificado = valoracionesServiceImpl.modificarValoracion(valoracionSeleccionado);

		}
		return null;
	}

	@DeleteMapping("valoracion/eliminar/{id}")
	public void eliminarEquioi(@PathVariable(name = "id") long id, Authentication authentication) {
		this.verificador.SetUsuarioAuth(authentication);
		if (verificador.isRecursoPropietario(valoracionesServiceImpl.mostrarValoracionID(id).getUsuario())) {
			valoracionesServiceImpl.eliminarValoracion(id);
		}
	}

}
