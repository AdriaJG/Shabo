/**
 * 
 */
package com.shabo.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shabo.api.dto.UsuarioLibro;

/**
 * @author Fenrir
 *
 */
public interface IUsuarioLibroDAO extends JpaRepository<UsuarioLibro,  Long > {

}
