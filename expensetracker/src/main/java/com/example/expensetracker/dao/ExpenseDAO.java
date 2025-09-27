package com.example.expensetracker.dao;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class ExpenseDAO {

    public void saveExpense(Expense expense) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            session.save(expense);
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public List<Expense> getAllExpenses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Expense", Expense.class).list();
        }
    }

    public void deleteExpense(int id) {
        Transaction tx = null;
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            tx = session.beginTransaction();
            Expense exp = session.get(Expense.class, id);
            if (exp != null) {
                session.delete(exp);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null) tx.rollback();
            e.printStackTrace();
        }
    }

    public double getTotalExpenses() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Double sum = session.createQuery("select sum(e.amount) from Expense e", Double.class)
                    .getSingleResult();
            return (sum != null) ? sum : 0.0;
        }
    }

    public List<Expense> getExpensesByCategory(String category) {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from Expense e where e.category = :cat", Expense.class)
                    .setParameter("cat", category)
                    .list();
        }
    }
}

