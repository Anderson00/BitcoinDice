package com.example.Spring.component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.springframework.stereotype.Component;

import com.example.Spring.model.Payments;
import com.example.Spring.repositories.PaymentsRepositories;

@Component
public class PaymentVerifier {
	
	public PaymentVerifier(){
		
	}
	
	public List<Payments> getPayments(PaymentsRepositories pays, long userID){
		List<Payments> aux = pays.findAll();
		List<Payments> lista = new ArrayList<>();
		Collections.reverse(aux);
		
		int leng = (aux.size() > 10)? 10 : aux.size();
		for(int i = 0; i < leng; i++){
			lista.add(aux.get(i));
		}
		
		return aux;
	}
}
