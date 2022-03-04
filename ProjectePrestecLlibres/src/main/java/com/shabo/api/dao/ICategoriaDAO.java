/**
 * 
 */
package com.shabo.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shabo.api.dto.Categoria;

/**
 * @author Fenrir
 *
 */
public interface ICategoriaDAO extends JpaRepository<Categoria, String> {

}
