/**
 * 
 */
package com.shabo.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shabo.api.dto.Valoracion;

/**
 * @author Fenrir
 *
 */
public interface IValoracionDAO extends JpaRepository<Valoracion, Integer> {

}
