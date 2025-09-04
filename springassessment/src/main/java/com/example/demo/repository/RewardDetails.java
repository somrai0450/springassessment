package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Reward;

import jakarta.transaction.Transactional;

@Repository
public interface RewardDetails extends JpaRepository<Reward, Integer>{

	@Transactional
	@Modifying
	@Query(value = "insert into reward (total_reward, customer_Id, date) values (:totalReward, :customerId, :date)", nativeQuery = true)
	void save(@Param(value = "customerId") int customerId, @Param(value = "date") Date date, @Param(value = "totalReward") double totalReward);

}
