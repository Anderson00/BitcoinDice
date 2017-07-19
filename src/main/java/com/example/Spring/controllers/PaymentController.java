package com.example.Spring.controllers;

import java.util.Calendar;

import javax.servlet.http.HttpSession;

import org.hibernate.annotations.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.Spring.model.Payments;
import com.example.Spring.model.Task;
import com.example.Spring.model.Usuario;
import com.example.Spring.repositories.PaymentsRepositories;
import com.example.Spring.repositories.UsersRepositories;

@Controller
public class PaymentController {

	@Autowired
	private UsersRepositories users;
	
	@Autowired
	private PaymentsRepositories pays;
	
	@PostMapping("/withdraw")
	@ResponseBody
	public String withdraw(int amount,String address, HttpSession session){
		int id = (int) session.getAttribute("userID");
		Usuario user = users.findOne(id);
		System.out.println(">>>>> "+amount+" >>>>>>>> "+address);
		if(address == null || address.equals(""))
			return "{\"error\":\"Address not specified\"}";
		if(amount > user.getBalance())
			return "{\"error\":\"Amount > Balance\"}";
		if(amount <= 0)
			return "{\"error\":\"Amount <= 0\"}";
		Payments payment = new Payments();
		payment.setUserID(id);		
		payment.setAmount(amount);
		payment.setAddress(address);
		payment.setDate(Calendar.getInstance().getTime());
		pays.save(payment);
		user.setBalance(user.getBalance()-amount);
		user.setWithdraw(user.getWithdraw()+amount);
		user.setTask(new Task("Withdraw",Calendar.getInstance().getTime()));
		users.save(user);
		return "{\"msg\":\"Wait the masters\"}";
	}
}
