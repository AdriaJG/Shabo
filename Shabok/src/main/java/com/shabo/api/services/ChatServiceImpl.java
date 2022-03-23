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
	public Chat mostrarChatID(long id) {
		// TODO Auto-generated method stub
		return iChatDAO.findById(id).get();
	}

	@Override
	public Chat crearChat(Chat chat) {
		// TODO Auto-generated method stub
		return iChatDAO.save(chat);
	}

	@Override
	public Chat modificarChat(Chat chat) {
		// TODO Auto-generated method stub
		return iChatDAO.save(chat);
	}

	@Override
	public void eliminarChat(long id) {
		iChatDAO.deleteById(id);
		
	}
	
	
}
