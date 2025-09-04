package com.example.demo.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Transaction;

import jakarta.transaction.Transactional;

@Repository
public interface TransactionRepo extends JpaRepository<Transaction, Long> {

	@Transactional
	@Modifying
	@Query(value = "insert into transaction (amount, customer_Id, date) values (:amount, :customerId, :date)", nativeQuery = true)
	void save(@Param(value = "customerId") int customerId, @Param(value = "date") Date date, @Param(value = "amount") double amount);

}
