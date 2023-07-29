package com.springboot.mongodb.repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import com.springboot.mongodb.model.Expense;

public interface ExpenseRepository extends MongoRepository<Expense, String>{
	
	/*
	 * To get details from name and amount
	 * 
	 * @Query("{'name': ?0, 'amount': ?1}") 
	 * public Optional<Expense> findByName(String name, String amount);
	 */
	
	@Query("{'name': ?0}")
	public Optional<Expense> findByName(String name);
}