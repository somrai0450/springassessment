package com.example.demo.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.graphql.GraphQlProperties.Http;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.model.Reward;
import com.example.demo.service.CalculateRewards;

@Controller
@RequestMapping("/api")
public class Rewards {
	
	@Autowired
	public CalculateRewards calReward;

	@GetMapping("/rewards")
	public ResponseEntity<Integer> getRewards() {
		
		int result = 50 * 2;
		
		return new ResponseEntity<>(result, HttpStatus.OK);
	}
	
	@GetMapping("rewards/{customerId}")
	public ResponseEntity<Reward> getRewardsOfCustId(@PathVariable int customerId) {
		
		Optional<Reward> response = calReward.getRewardsDetailsOfCustId(customerId);
		Reward reward = response.get();
		if(response.isPresent()) {
			return new ResponseEntity<>(reward, HttpStatus.OK);
		}else {
			return new ResponseEntity<>(reward, HttpStatus.NOT_FOUND);
		}
	}
}
