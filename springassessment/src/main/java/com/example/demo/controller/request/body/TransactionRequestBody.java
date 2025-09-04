package com.example.demo.controller.request.body;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonFormat;

public class TransactionRequestBody {

	private int customerId;
	private double transAmount;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	private Date date;
	
	public TransactionRequestBody() {
		
	}

	public TransactionRequestBody(int customerId, double transAmount, Date date) {
		super();
		this.customerId = customerId;
		this.transAmount = transAmount;
		this.date = date;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getTransAmount() {
		return transAmount;
	}

	public void setTransAmount(double transAmount) {
		this.transAmount = transAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
