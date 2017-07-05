package com.example.Spring.component;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import com.example.Spring.model.Bet;
import com.example.Spring.model.Usuario;
import com.example.Spring.repositories.BetsRepositories;
import com.example.Spring.repositories.UsersRepositories;

@Component
@Primary
public class BetVerifica {
	private long satoshi = 100000000;// 1 satoshi = 0.00000001 BTC
	private float basePayout = 2;
	private float baseChance = 49.5f;
	private final float minPayout = 1.010f;
	private final float maxPayout = 9900;
	private final float minChance = 0.01f;
	private final float maxChance = 98;
	
	private final float minRollValue = 0.01f;
	private final float maxRollValue = 99.99f;
	
	public BetVerifica(){
		
	}
	
	public float payoutToChance(float payout){
		return (basePayout*baseChance)/payout;
	}
	
	public float chanceToPayout(float chance){
		return (baseChance*basePayout)/chance;
	}
	
	public boolean payoutIsValid(float payout){
		return (payout >= minPayout && payout <= maxPayout)? true : false;
	}
	
	public boolean chanceIsValid(float chance){
		return (chance >= minPayout && chance <= maxPayout)? true : false;
	}
	
	public BigDecimal calculateRoll(boolean high, float chance){
		if(high){
			BigDecimal d = new BigDecimal(maxRollValue);
			d = d.subtract(new BigDecimal(chance));
			d = d.setScale(2, RoundingMode.CEILING);
			return d;
		}
			
		return new BigDecimal(chance);
	}
	
	public long calculateProfit(long value,float payout){
		return new BigDecimal((value*payout)-value).setScale(0, RoundingMode.DOWN).longValue();
	}
	
	public String placeBet(BetsRepositories bets, UsersRepositories users, Usuario user,Bet bet){		
		//BigDecimal d = new BigDecimal(value);
		//d = d.setScale(2, RoundingMode.DOWN);

		BigDecimal roll = calculateRoll(bet.isHigh(), payoutToChance(bet.getPayout()));
		double value = ThreadLocalRandom.current().nextDouble(minRollValue, maxRollValue);
		BigDecimal random = new BigDecimal(value);
		long profit = calculateProfit(bet.getAmount(), bet.getPayout());
		if(bet.isHigh())
			profit *= (roll.compareTo(random) <= 0)? 1 : -1;
		else
			profit *= (roll.compareTo(random) >= 0)? 1 : -1;
		
		if(profit <= 0){ // perdeu
			profit = -1*bet.getAmount();
		}
		
		bet.setUserId(user.getId());
		bet.setChance(payoutToChance(bet.getPayout()));
		bet.setRoll(random.setScale(2, RoundingMode.CEILING).toPlainString());
		bet.setProfit(profit);
		bet.setDate(Calendar.getInstance().getTime());
		
		user.setBalance(user.getBalance()+profit);
		
		SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		
		bets.save(bet);
		users.save(user);
		return "{\"betID\":"+bet.getBetID()+",\"date\":\""+format.format(bet.getDate())+"\",\"amount\":"+bet.getAmount()+""
				+ ",\"payout\":\""+bet.getPayout()+"\""
				+ ",\"chance\":\""+bet.getChance()+"\",\"roll\":\""+bet.getRoll()+"\",\"profit\":"+bet.getProfit()+"}";
	}
}
