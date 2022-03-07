/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import com.shabo.api.dto.Chat;

/**
 * @author Fenrir
 *
 */
public interface IChatService {
	public List<Chat> mostrarChats();
	
	public  Chat mostrarChatID(int id);
	
	public Chat crearChat(Chat chat);
	
	public Chat modificarChat(Chat chat);
	
	public void eliminarChat(int id);
}
