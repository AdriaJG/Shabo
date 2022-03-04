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
public interface IUsuarioDAO extends JpaRepository<Usuario, Integer> {
	Usuario findByUsername(String nombre);
}
