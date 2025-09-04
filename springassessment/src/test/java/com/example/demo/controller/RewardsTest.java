package com.example.demo.controller;

import static org.mockito.Mockito.*;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import com.example.demo.controller.response.body.RewardResponseBody;
import com.example.demo.model.Reward;
import com.example.demo.service.CalculateRewards;

import java.util.Arrays;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class RewardsTest {

    @Mock
    private CalculateRewards calculateRewards;

    @InjectMocks
    private Rewards rewardsController;

    @Test
    void testGetRewards() {
        
        RewardResponseBody response1 = new RewardResponseBody();
        response1.setCustomerId(101);
        RewardResponseBody response2 = new RewardResponseBody();
        response2.setCustomerId(102);
        
        List<RewardResponseBody> mockList = Arrays.asList(response1, response2);

        when(calculateRewards.getRewards()).thenReturn(mockList);

        ResponseEntity<List<RewardResponseBody>> response = rewardsController.getRewards();

        //Assertions
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).hasSize(2);
        assertThat(response.getBody().get(0).getCustomerId()).isEqualTo(101);

        verify(calculateRewards, times(1)).getRewards();
    }

    @Test
    void testGetRewardsOfCustId() {
        
        Reward reward = new Reward();
        reward.setCustomerId(101);
        
        List<Reward> mockRewards = Arrays.asList(reward);

        when(calculateRewards.getRewardsDetailsOfCustId(1))
                .thenReturn(ResponseEntity.ok(mockRewards));

        ResponseEntity<List<Reward>> response = rewardsController.getRewardsOfCustId(1);

        //Assertion
        assertThat(response.getStatusCode().is2xxSuccessful()).isTrue();
        assertThat(response.getBody()).hasSize(1);
        assertThat(response.getBody().get(0).getCustomerId()).isEqualTo(101);

        verify(calculateRewards, times(1)).getRewardsDetailsOfCustId(1);
    }
}