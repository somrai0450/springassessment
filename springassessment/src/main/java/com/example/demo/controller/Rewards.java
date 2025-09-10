package com.example.demo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.controller.response.body.RewardResponseBody;
import com.example.demo.model.Reward;
import com.example.demo.service.CalculateRewards;

@RestController
@RequestMapping("/api")
public class Rewards {
	
	private static final Logger logger = LoggerFactory.getLogger(Rewards.class);
	
	@Autowired
	public CalculateRewards calReward;

	@GetMapping("/rewards")
	public ResponseEntity<List<RewardResponseBody>> getRewards() {
		
		List<RewardResponseBody> resp = calReward.getRewards();
		logger.info("Reward List are: ", resp);
		return new ResponseEntity<List<RewardResponseBody>>(resp, HttpStatus.OK); 
	}
	
	@GetMapping("rewards/{customerId}")
	public ResponseEntity<List<Reward>> getRewardsOfCustId(@PathVariable int customerId) {
		
		ResponseEntity<List<Reward>> resp = calReward.getRewardsDetailsOfCustId(customerId);
		logger.info("Reward of the customer of customerid {} is: {}", customerId, resp);
		return resp;
	}
}
