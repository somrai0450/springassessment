package com.example.demo.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
public class Reward {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private int customerId;
	private double totalReward;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	
	public Reward() {
		
	}

	public Reward(int id, int customerId, double totalReward, Date date) {
		super();
		this.id = id;
		this.customerId = customerId;
		this.totalReward = totalReward;
		this.date = date;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getTotalReward() {
		return totalReward;
	}

	public void setTotalReward(double totalReward) {
		this.totalReward = totalReward;
	}
}
