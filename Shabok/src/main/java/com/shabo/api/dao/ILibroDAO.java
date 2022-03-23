/**
 * 
 */
package com.shabo.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shabo.api.dto.Libro;

/**
 * @author Fenrir
 *
 */
public interface ILibroDAO extends JpaRepository<Libro, Integer> {

}
