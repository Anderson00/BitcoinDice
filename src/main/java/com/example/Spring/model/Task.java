package com.example.Spring.model;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable{
	
	private String msg;
	private Date data;
	
	public Task(){
		
	}
	
	public Task(String msg, Date data){
		this.msg = msg;
		this.data = data;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}
	
	
	
}
