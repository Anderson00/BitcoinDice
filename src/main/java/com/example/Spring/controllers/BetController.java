package com.example.Spring.controllers;

import java.util.HashMap;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Spring.component.BetVerifica;
import com.example.Spring.model.Bet;
import com.example.Spring.model.Usuario;
import com.example.Spring.repositories.BetsRepositories;
import com.example.Spring.repositories.UsersRepositories;

@Controller
public class BetController {
	
	@Autowired
	private UsersRepositories users;
	
	@Autowired
	private BetsRepositories bets;
	
	@Autowired
	private BetVerifica betVerifica;

	@RequestMapping("/bet")
	public String bet(Model model,HttpSession session){
		int id = (int) session.getAttribute("userID");
		model.addAttribute("user",users.findOne(id));
		return "bet";
	}
	
	@RequestMapping("/betinfo")
	@ResponseBody
	public List<Bet> betinfo(HttpSession session){
		int id = (int) session.getAttribute("userID");				
		return betVerifica.findBets(bets, id);
	}
	
	@RequestMapping("/betinfo/{num}")// n apostas mais recentes
	@ResponseBody
	public List<Bet> betinfo(HttpSession session,@PathVariable("num") int num){
		int id = (int) session.getAttribute("userID");				
		return betVerifica.findBets(bets, id, num);
	}
	
	@RequestMapping(value="/bet",method={RequestMethod.POST})
	@ResponseBody
	public String bet(Bet bet,HttpSession session){
		int id = (int) session.getAttribute("userID");
		Usuario user = users.findOne(id);
		if(bet.getAmount() > user.getBalance()){
			return "{\"amountBigger\":\"1\",\"error\":\"Amount bigger than balance\"}";
		}
		if(!betVerifica.payoutIsValid(bet.getPayout())){
			return "{\"payoutInvalid\":\"1\",\"error\":\"Payout is invalid\"}";
		}
		
		return betVerifica.placeBet(bets, users, user, bet);
	}
}
