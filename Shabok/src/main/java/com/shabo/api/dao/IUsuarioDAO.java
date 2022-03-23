/**
 * 
 */
package com.shabo.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shabo.api.dto.Usuario;

/**
 * @author Fenrir
 *
 */
public interface IUsuarioDAO extends JpaRepository<Usuario,  Long > {
	Usuario findByUsername(String nombre);
	Usuario findByNombre(String nombre);
}
