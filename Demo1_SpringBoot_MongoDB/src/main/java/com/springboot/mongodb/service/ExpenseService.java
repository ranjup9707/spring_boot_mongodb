package com.springboot.mongodb.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.springboot.mongodb.model.Expense;
import com.springboot.mongodb.repository.ExpenseRepository;

@Service
public class ExpenseService 
{	
	private final ExpenseRepository expenseRepository;
	
	public ExpenseService(ExpenseRepository expenseRepository) {
		super();
		this.expenseRepository = expenseRepository;
	}

	public void addExpense(Expense expense) {
		expenseRepository.insert(expense);
	}
	
	public void updateExpense(Expense expense) {
		Expense findExpense = expenseRepository.findById(expense.getId())
				.orElseThrow(() -> new RuntimeException(String.format("Cannot find expense id %s", expense.getId())));
		findExpense.setExpenseName(expense.getExpenseName());
		findExpense.setExpenseCategory(expense.getExpenseCategory());
		findExpense.setExpenseAmount(expense.getExpenseAmount());
		expenseRepository.save(findExpense);
	}
	
	public Expense getExpense(String name) {
		return expenseRepository.findByName(name).orElseThrow(() -> new RuntimeException("Cannot find expense detail"));
	}
	
	public List<Expense> getAllExpenses() {
		return expenseRepository.findAll();
	}
	
	public void deleteExpense(String id) {
		expenseRepository.deleteById(id);
	}
}
