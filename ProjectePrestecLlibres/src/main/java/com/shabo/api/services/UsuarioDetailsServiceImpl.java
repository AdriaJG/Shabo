/**
 * 
 */
package com.shabo.api.services;

import static java.util.Collections.emptyList;

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
	
	private IUsuarioDAO iUsuarioDAO;
	
	public UsuarioDetailsServiceImpl(IUsuarioDAO iUsuarioDAO) {
		this.iUsuarioDAO = iUsuarioDAO;
	}
	
	@Override
	public UserDetails loadUserByUsername(String nombre) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		Usuario usuario = iUsuarioDAO.findByUsername(nombre);
		if(usuario == null) {
			throw new UsernameNotFoundException(nombre + "no existe en la base de datos");
		}
		return new User(usuario.getNombre(), usuario.getPassword(), emptyList());
	}

}
