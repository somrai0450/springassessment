package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transaction;
import com.example.demo.repository.TransactionRepo;

@Service
public class TransactionsImpl {

	@Autowired
	public TransactionRepo repo;
	
	public ResponseEntity<List<Transaction>> getAllTransactions() {

		List<Transaction> result = repo.findAll();
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}

	
}
