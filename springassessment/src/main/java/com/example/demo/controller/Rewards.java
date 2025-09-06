package com.example.demo.controller;

import java.util.List;

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
	
	@Autowired
	public CalculateRewards calReward;

	@GetMapping("/rewards")
	public ResponseEntity<List<RewardResponseBody>> getRewards() {
		
		List<RewardResponseBody> resp = calReward.getRewards();
		
		return new ResponseEntity<List<RewardResponseBody>>(resp, HttpStatus.OK); 
	}
	
	@GetMapping("rewards/{customerId}")
	public ResponseEntity<List<Reward>> getRewardsOfCustId(@PathVariable int customerId) {
		
		ResponseEntity<List<Reward>> resp = calReward.getRewardsDetailsOfCustId(customerId);
		
		return resp;
	}
}
