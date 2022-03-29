/**
 * 
 */
package com.shabo.api.services;

import static java.util.Collections.emptyList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.shabo.api.dao.IUsuarioDAO;
import com.shabo.api.dto.Usuario;

/**
 * @author Fenrir
 *
 */
@Service
public class UsuarioDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	private IUsuarioDAO iUsuarioDAO;
	
	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = iUsuarioDAO.findByUsername(nombre);
		if(usuario == null) {
			throw new UsernameNotFoundException(nombre + "no existe en la base de datos");
		}
		return new User(usuario.getUsername(), usuario.getPassword(), emptyList());
	}

}
