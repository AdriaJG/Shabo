/**
 * 
 */
package com.shabo.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shabo.api.dto.Prestamo;

/**
 * @author Fenrir
 *
 */
public interface IPrestamoDAO extends JpaRepository<Prestamo, Integer> {

}
