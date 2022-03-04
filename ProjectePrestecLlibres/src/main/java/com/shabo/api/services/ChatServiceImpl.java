/**
 * 
 */
package com.shabo.api.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shabo.api.dao.IChatDAO;
import com.shabo.api.dto.Chat;

/**
 * @author Fenrir
 *
 */
@Service
public class ChatServiceImpl implements IChatService {
	
	@Autowired
	IChatDAO iChatDAO;

	@Override
	public List<Chat> mostrarChats() {
		// TODO Auto-generated method stub
		return iChatDAO.findAll();
	}

	@Override
	public Chat mostrarChatID(int id) {
		// TODO Auto-generated method stub
		return iChatDAO.findById(id).get();
	}

	@Override
	public Chat crearChat(Chat chat) {
		// TODO Auto-generated method stub
		return iChatDAO.save(chat);
	}

	@Override
	public Chat modificarChat(int id, Chat chat) {
		// TODO Auto-generated method stub
		return iChatDAO.save(chat);
	}

	@Override
	public void eliminarChat(int id) {
		iChatDAO.deleteById(id);
		
	}
	
	
}
