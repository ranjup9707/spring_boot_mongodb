package com.springboot.mongodb.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.mongodb.model.Expense;
import com.springboot.mongodb.service.ExpenseService;

@RestController
@RequestMapping("/api/expense")
public class ExpenseController 
{
	private final ExpenseService expenseService;
	
	public ExpenseController(ExpenseService expenseService) {
		super();
		this.expenseService = expenseService;
	}

	@PostMapping
	public ResponseEntity addExpense(@RequestBody Expense expense) {
		expenseService.addExpense(expense);
		return ResponseEntity.status(HttpStatus.CREATED).build();
	}
	
	@PutMapping
	public ResponseEntity updateExpense(@RequestBody Expense expense) {
		expenseService.updateExpense(expense);
		return ResponseEntity.ok().build();
	}
	
	@GetMapping("/{name}")
	public ResponseEntity getExpense(@PathVariable String name) {
		return ResponseEntity.ok(expenseService.getExpense(name));
		
	}
	
	@GetMapping
	public ResponseEntity getAllExpenses() {
		return ResponseEntity.ok(expenseService.getAllExpenses());
		
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity deleteExpense(@PathVariable String id) {
		expenseService.deleteExpense(id);
		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
	}
}
