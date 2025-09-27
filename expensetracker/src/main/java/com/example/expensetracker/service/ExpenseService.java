package com.example.expensetracker.service;

import com.example.expensetracker.dao.ExpenseDAO;
import com.example.expensetracker.model.Expense;

import java.util.List;

public class ExpenseService {
    private ExpenseDAO expenseDAO = new ExpenseDAO();

    public void addExpense(String description, double amount, String category) {
        Expense expense = new Expense(description, amount, category);
        expenseDAO.saveExpense(expense);
    }

    public List<Expense> getAllExpenses() {
        return expenseDAO.getAllExpenses();
    }

    public void deleteExpense(int id) {
        expenseDAO.deleteExpense(id);
    }

    public double getTotalExpenses() {
        return expenseDAO.getTotalExpenses();
    }

    public List<Expense> getExpensesByCategory(String category) {
        return expenseDAO.getExpensesByCategory(category);
    }
}

