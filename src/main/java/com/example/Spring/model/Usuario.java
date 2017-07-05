package com.example.Spring.model;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Usuarios")
public class Usuario {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@NotNull
	private String username;
	@NotNull
	private String email;
	@NotNull
	private String password;
	private String mensagens;
	private ArrayList<Task> tasks;
	
	private long balance; // Satoshi
	private long withdraw; // Satoshi
	private String depositAdress; // Endereco bitcoin para depositar na conta
	private String withdrawAdress; // Endereco para retirar BTC da conta
	
	
	public Usuario(){
		
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getEmail(){
		return email;
	}
	
	public void setEmail(String email){
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getMensagens() {
		return mensagens;
	}

	public void setMensagens(String mensagens) {
		this.mensagens = mensagens;
	}

	public int getId() {
		return id;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public ArrayList<Task> getTasks() {
		return tasks;
	}

	public void setTasks(ArrayList<Task> tasks) {
		this.tasks = tasks;
	}

	public long getWithdraw() {
		return withdraw;
	}

	public void setWithdraw(long withdraw) {
		this.withdraw = withdraw;
	}	
	
	public String getBalanceBTC(){
		BigDecimal decimal = new BigDecimal(1e-8);
		decimal = decimal.multiply(new BigDecimal(this.balance));
		decimal = decimal.setScale(8,RoundingMode.DOWN);
		return decimal.toPlainString();
	}
	
	public String getWithdrawBTC(){
		BigDecimal decimal = new BigDecimal(1e-8);
		decimal = decimal.multiply(new BigDecimal(this.withdraw));
		decimal = decimal.setScale(8,RoundingMode.DOWN);
		return decimal.toPlainString();
	}
	
}
