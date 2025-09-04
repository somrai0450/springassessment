package com.example.demo.service;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.controller.response.body.RewardResponseBody;
import com.example.demo.model.Reward;
import com.example.demo.repository.RewardDetails;

@Service
public class CalculateRewards {

	@Autowired
	public RewardDetails rewardDetailsRepo;
	
	public ResponseEntity<List<Reward>> getRewardsDetailsOfCustId(int customerId){
		
		List<Reward> response = rewardDetailsRepo.findByCustId(customerId);
		
		return new ResponseEntity<List<Reward>>(response, HttpStatus.OK);
	}

	public List<RewardResponseBody> getRewards() {
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM");
		
		List<Reward> rewardList = rewardDetailsRepo.findAll();
		
		Map<Integer, List<Reward>> rewardsMap = rewardList.stream().collect(Collectors.groupingBy(Reward::getCustomerId));
		
		List<RewardResponseBody> rewardResult = new ArrayList<>();
		
		for(Map.Entry<Integer, List<Reward>> entry : rewardsMap.entrySet()) {
			Integer customerId = entry.getKey();
			Map<Integer, Integer> monthlyRewards = new HashMap<>();
            int total = 0;
            for (Reward tx : entry.getValue()) {
                double custRewards = tx.getTotalReward();
                Integer month = tx.getDate().getMonth();

                monthlyRewards.put(month, (int) (monthlyRewards.getOrDefault(month, 0) + custRewards));
                
                total += custRewards;
            }

            rewardResult.add(new RewardResponseBody(customerId, monthlyRewards, total));
		}
		
		return rewardResult;
	}
			
}
