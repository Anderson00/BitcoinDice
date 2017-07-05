package com.example.Spring.component;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.Spring.model.Usuario;

@Component
@Primary
public class LoginVerifier {
	
	public LoginVerifier(){
		
	}
	
	public Usuario existUser(Iterable<Usuario> iter, String username){
		for(Usuario user : iter){
			if(user.getUsername().equals(username)){
				return user;
			}
		}
		return null;
	}
	
	public Usuario existUserEmail(Iterable<Usuario> iter, String email){
		for(Usuario user : iter){
			if(user.getEmail().equals(email)){
				return user;
			}
		}
		return null;
	}
	
	public Usuario existUser(Iterable<Usuario> iter, String username, String password){
		for(Usuario user : iter){
			if(user.getUsername().equals(username) && user.getPassword().equals(password)){
				return user;
			}
		}
		return null;
	}
}
