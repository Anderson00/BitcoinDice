package com.example.Spring.controllers;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Spring.model.Usuario;
import com.example.Spring.repositories.UsersRepositories;

@Controller
public class HomeController {
	
	@Autowired
	private UsersRepositories users;
	
	@RequestMapping("/home")
	public String home(Model model,HttpSession session){
		int id = (int) session.getAttribute("userID");
		model.addAttribute("user",users.findOne(id));
		
		return "home";
	}
	
	@RequestMapping("/freebitcoin")
	@ResponseBody
	public String freeBitcoin(HttpSession session){
		int id = (int) session.getAttribute("userID");
		Usuario user = users.findOne(id);
		if(user.getBalance() == 0){
			user.setBalance(200);// 200 satoshi
			users.save(user);
			return "{\"balance\":\"200\"}";
		}
		return "{\"error\":\"Balance must be zero to earn bitcoins\"}";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
