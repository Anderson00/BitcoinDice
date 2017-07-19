package com.example.Spring.controllers;


import java.util.Calendar;
import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Spring.component.PaymentVerifier;
import com.example.Spring.model.Payments;
import com.example.Spring.model.Task;
import com.example.Spring.model.Usuario;
import com.example.Spring.repositories.PaymentsRepositories;
import com.example.Spring.repositories.UsersRepositories;

@Controller
public class HomeController {
	
	@Autowired
	private UsersRepositories users;
	
	@Autowired
	private PaymentsRepositories payments;
	
	@Autowired
	private PaymentVerifier payVerifier;
	
	
	@RequestMapping("/home")
	public String home(Model model,HttpSession session){
		int id = (int) session.getAttribute("userID");
		model.addAttribute("user",users.findOne(id));
		
		return "home";
	}
	
	@RequestMapping("/payments")
	@ResponseBody
	public List<Payments> pays(HttpSession session){
		int id = (int) session.getAttribute("userID");
		
		return payVerifier.getPayments(payments, id);
	}
	
	@RequestMapping("/freebitcoin")
	@ResponseBody
	public String freeBitcoin(HttpSession session){
		int id = (int) session.getAttribute("userID");
		Usuario user = users.findOne(id);
		if(user.getBalance() == 0){
			user.setBalance(200);// 200 satoshi = 0.00000200 btc
			user.setTask(new Task("Won free btc", Calendar.getInstance().getTime()));
			users.save(user);
			return "{\"balance\":\"200\"}";
		}
		return "{\"error\":\"Balance must be zero to earn bitcoins\"}";
	}
	
	/*
	@RequestMapping("/error")
	@Order(Ordered.LOWEST_PRECEDENCE)
	public String error(){
		return "error";
	}*/
	
	@RequestMapping("/logout")
	public String logout(HttpSession session){
		session.invalidate();
		return "redirect:/";
	}
}
