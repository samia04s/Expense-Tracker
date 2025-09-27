package com.example.expensetracker;

import com.example.expensetracker.model.Expense;
import com.example.expensetracker.service.ExpenseService;

import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        ExpenseService service = new ExpenseService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Expense Tracker ===");
            System.out.println("1. Add Expense");
            System.out.println("2. Show All Expenses");
            System.out.println("3. Delete Expense");
            System.out.println("4. Show Total Expenses");
            System.out.println("5. Show Expenses by Category");
            System.out.println("6. Exit");
            System.out.print("Choose option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter description: ");
                    String desc = scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amt = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter category: ");
                    String cat = scanner.nextLine();
                    service.addExpense(desc, amt, cat);
                    System.out.println("✅ Expense saved!");
                    break;

                case 2:
                    List<Expense> expenses = service.getAllExpenses();
                    if (expenses.isEmpty()) {
                        System.out.println("No expenses found.");
                    } else {
                        for (Expense e : expenses) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter expense ID to delete: ");
                    int id = scanner.nextInt();
                    service.deleteExpense(id);
                    System.out.println("✅ Expense deleted!");
                    break;

                case 4:
                    System.out.println("💰 Total Expenses: " + service.getTotalExpenses());
                    break;

                case 5:
                    System.out.print("Enter category: ");
                    String category = scanner.nextLine();
                    List<Expense> catExpenses = service.getExpensesByCategory(category);
                    if (catExpenses.isEmpty()) {
                        System.out.println("No expenses found in this category.");
                    } else {
                        for (Expense e : catExpenses) {
                            System.out.println(e);
                        }
                    }
                    break;

                case 6:
                    System.out.println("👋 Exiting...");
                    scanner.close();
                    System.exit(0);

                default:
                    System.out.println("❌ Invalid option.");
            }
        }
    }
}
