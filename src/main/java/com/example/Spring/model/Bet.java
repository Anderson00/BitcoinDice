package com.example.Spring.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Bets")
public class Bet {
	@Id
	@NotNull
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long betID;
	
	@NotNull
	private long userId;
	private Date date;
	@NotNull
	private long amount;// Satoshi apostado
	private boolean high;
	private float payout;
	private float chance;
	private String roll;
	private long profit;// Satoshi ganho
	public long getUserId() {
		return userId;
	}
	public void setUserId(long userId) {
		this.userId = userId;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public long getAmount() {
		return amount;
	}
	public void setAmount(long amount) {
		this.amount = amount;
	}
	public boolean isHigh() {
		return high;
	}
	public void setHigh(boolean high) {
		this.high = high;
	}
	public float getPayout() {
		return payout;
	}
	public void setPayout(float payout) {
		this.payout = payout;
	}
	public float getChance() {
		return chance;
	}
	public void setChance(float chance) {
		this.chance = chance;
	}
	public String getRoll() {
		return roll;
	}
	public void setRoll(String roll) {
		this.roll = roll;
	}
	public long getProfit() {
		return profit;
	}
	public void setProfit(long profit) {
		this.profit = profit;
	}
	public long getBetID() {
		return betID;
	}
	
}
