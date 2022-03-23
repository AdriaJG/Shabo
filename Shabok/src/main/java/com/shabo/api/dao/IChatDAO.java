/**
 * 
 */
package com.shabo.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shabo.api.dto.Chat;

/**
 * @author Fenrir
 *
 */
public interface IChatDAO extends JpaRepository<Chat,  Long > {

}
