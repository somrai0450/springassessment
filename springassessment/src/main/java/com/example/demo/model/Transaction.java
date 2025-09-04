package com.example.demo.model;



import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Transaction {

	@Id
	private int customerId;
    private double amount;
    private Date date;
    
    public Transaction() {
    	
    }
    
	public Transaction(int customerId, double amount, Date date) {
		super();
		this.customerId = customerId;
		this.amount = amount;
		this.date = date;
	}

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
}
