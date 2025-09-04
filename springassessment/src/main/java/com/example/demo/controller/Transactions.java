package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionsImpl;

@Controller
@RequestMapping("/api")
public class Transactions {

	@Autowired
	public TransactionsImpl transactions;
	
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTransactions(){
		
		ResponseEntity<List<Transaction>> response = transactions.getAllTransactions();
		
		return response;
	}
}
