package com.example.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Reward;
import com.example.demo.repository.RewardDetails;

@Service
public class CalculateRewards {

	@Autowired
	public RewardDetails rewardDetailsRepo;
	
	public Optional<Reward> getRewardsDetailsOfCustId(int customerId){
		
		Optional<Reward> response = rewardDetailsRepo.findById(customerId);
		
		return response;
	}
			
}
