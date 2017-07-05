package com.example.Spring.controllers;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.function.Consumer;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.Spring.component.LoginVerifier;
import com.example.Spring.model.Task;
import com.example.Spring.model.Usuario;
import com.example.Spring.repositories.UsersRepositories;

@Controller
public class LoginCotroller {
	
	@Autowired
	private UsersRepositories users;
	
	@Autowired
	private LoginVerifier loginVerifier;
	
	@RequestMapping("/")
	public String index(){
		return "login";
	}
	
	@RequestMapping("/login")
	public String login(Usuario user, HttpSession session, Model model){	
		boolean exists = false;
		if(user.getUsername() == null || user.getPassword() == null){
			model.addAttribute("error", "Empty username and password");
			return "forward:/";
		}
		Usuario userAux = loginVerifier.existUser(users.findAll(), user.getUsername(), user.getPassword());
		if(userAux != null){
			session.setAttribute("userID", userAux.getId());
			return "redirect:/home";
		}
		
		model.addAttribute("error", "Wrong username and password");
		return "forward:/";
		
	}
	
	@RequestMapping("/signup")
	public String signup(@Valid Usuario user, HttpSession session, BindingResult result, RedirectAttributes redirect){
		if(result.hasErrors()){
			redirect.addAttribute("error", "Some empty field");
			return "redirect:/";
		}
		Iterable<Usuario> obj = users.findAll();
		if(loginVerifier.existUser(obj, user.getUsername()) != null){
			redirect.addFlashAttribute("error", "User already exist");
			return "redirect:/";
		}
		if(loginVerifier.existUserEmail(obj, user.getEmail()) != null){			
			redirect.addFlashAttribute("error", "Email already exist");
			return "redirect:/";
		}
			
		user.setBalance(0);
		user.setWithdraw(0);
		user.setTasks(new ArrayList<>());
		user.getTasks().add(new Task("Create account",Calendar.getInstance().getTime()));
		users.save(user);
		session.setAttribute("userID", user.getId());
		return "redirect:/home";
	}
}
