/**
 * 
 */
package com.shabo.api.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.shabo.api.dao.IUsuarioDAO;
import com.shabo.api.dto.Chat;
import com.shabo.api.services.ChatServiceImpl;
import com.shabo.api.services.UsuarioServiceImpl;

/**
 * @author Fenrir
 *
 */
@RestController
@RequestMapping("/api")
public class ChatController {
	
	private IUsuarioDAO iUsuarioDAO;
	
	@Autowired
	private ChatServiceImpl chatsServiceImpl;
	
	@GetMapping("/chats")
	public List<Chat> listarChat(){
		return chatsServiceImpl.mostrarChats();
	}
	
	@GetMapping("/chats/{id}")
	public Chat mostrarChatID(@PathVariable(name="id") long id){
		return chatsServiceImpl.mostrarChatID(id);
	}
	
	@PutMapping("/chats/crear")
	public Chat crearChat(@RequestBody String mensaje, @RequestBody String destinatario, Authentication authentication) {
		Chat nuevoChat = new Chat();

		nuevoChat.setEmisor(iUsuarioDAO.findByUsername(authentication.getName()));
		nuevoChat.setReceptor(iUsuarioDAO.findByUsername(destinatario));
		nuevoChat.setMensaje(mensaje);
		nuevoChat.setHoraEnviado(new Date(System.currentTimeMillis()));
		
		return chatsServiceImpl.crearChat(nuevoChat);
	}
	
	@DeleteMapping("chat/eliminar/{id}")
	public void eliminarEquioi(@PathVariable(name="id") long id) {
		chatsServiceImpl.eliminarChat(id);
		
	}
	
}
