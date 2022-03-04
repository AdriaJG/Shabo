/**
 * 
 */
package com.shabo.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shabo.api.dto.Comentario;

/**
 * @author Fenrir
 *
 */
public interface IComentarioDAO extends JpaRepository<Comentario, Integer> {

}
