/**
 * 
 */
package com.shabo.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shabo.api.dto.CategoriaLibro;
import com.shabo.api.dto.CategoriaLibroID;

/**
 * @author Fenrir
 *
 */
public interface ICategoriaLibroDAO extends JpaRepository<CategoriaLibro, CategoriaLibroID> {

}
