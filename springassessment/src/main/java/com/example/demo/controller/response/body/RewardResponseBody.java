package com.example.demo.controller.response.body;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

public class RewardResponseBody {

	private int customerId;
	private Map<Integer, Integer> monthlyRewards;
	private double totalRewards;
	
	public RewardResponseBody() {
		
	}

	public RewardResponseBody(int customerId, Map<Integer, Integer> monthlyRewards, double totalRewards) {
		super();
		this.customerId = customerId;
		this.monthlyRewards = monthlyRewards;
		this.totalRewards = totalRewards;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public Map<Integer, Integer> getMonthlyRewards() {
		return monthlyRewards;
	}

	public void setMonthlyRewards(Map<Integer, Integer> monthlyRewards) {
		this.monthlyRewards = monthlyRewards;
	}

	public double getTotalRewards() {
		return totalRewards;
	}

	public void setTotalRewards(double totalRewards) {
		this.totalRewards = totalRewards;
	}
	
}
