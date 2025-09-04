package com.example.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Reward {

	@Id
	private int customerId;
	private double totalReward;
	
	public Reward() {
		
	}

	public Reward(int customerId, double totalReward) {
		super();
		this.customerId = customerId;
		this.totalReward = totalReward;
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
