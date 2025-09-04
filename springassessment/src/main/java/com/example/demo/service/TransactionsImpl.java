package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.controller.request.body.TransactionRequestBody;
import com.example.demo.model.Transaction;
import com.example.demo.repository.RewardDetails;
import com.example.demo.repository.TransactionRepo;

@Service
public class TransactionsImpl {

	@Autowired
	public TransactionRepo repo;
	
	@Autowired
	public RewardDetails rewardRepo;
	
	public ResponseEntity<List<Transaction>> getAllTransactions() {

		List<Transaction> result = repo.findAll();
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	public void insertRewards(TransactionRequestBody req) {
		double amount = req.getTransAmount();
		double totalReward = calculate(amount);
		try {
			repo.save(req.getCustomerId(), req.getDate(), req.getTransAmount());
			rewardRepo.save(req.getCustomerId(), req.getDate(), totalReward);
		}catch(Exception e) {
			System.out.println("Unable to insert data in the table.");
			throw e;
		}
		
	}

	private double calculate(double amount) {
		double point = 0;
		if(amount <= 50) {
			return 0;
		}else if(amount >= 50 && amount <= 100) {
			point = point + (amount - 50) * 1;
		}else if(amount > 100) {
			point = point + (amount - 100) * 2;
			point = point + 50;
		}
		return point;
	}

	
}
