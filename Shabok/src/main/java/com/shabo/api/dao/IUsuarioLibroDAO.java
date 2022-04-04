/**
 * 
 */
package com.shabo.api.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shabo.api.dto.Usuario;
import com.shabo.api.dto.UsuarioLibro;

/**
 * @author Fenrir
 *
 */
public interface IUsuarioLibroDAO extends JpaRepository<UsuarioLibro,  Long > {
	public List<UsuarioLibro> findByUsuario(Usuario usuario);
}
