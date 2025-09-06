package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.request.body.TransactionRequestBody;
import com.example.demo.model.Transaction;
import com.example.demo.service.TransactionsImpl;

@RestController
@RequestMapping("/api")
public class Transactions {

	@Autowired
	public TransactionsImpl transactions;
	
	@PostMapping("/calcRewards")
	public ResponseEntity<String> calculateAndInsertRewards(@RequestBody TransactionRequestBody req) {
		
		ResponseEntity<String> resp = transactions.insertRewards(req);
		
		return resp;
	}
	
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTransactions(){
		
		ResponseEntity<List<Transaction>> response = transactions.getAllTransactions();
		
		return response;
	}
}
