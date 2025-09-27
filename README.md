
# Expense Tracker (Java + Hibernate + MySQL)

A simple **console-based Expense Tracker** built with:
- Java
- Hibernate (ORM)
- MySQL (Database)
- Maven (Build tool)

## 🚀 Features
- Add new expenses (with description, category, amount)
- View all expenses
- Delete expenses
- Show total expenses
- Filter expenses by category
- Data stored in **MySQL database**

## 🛠️ Tech Stack
- **Java 17+**
- **Hibernate 6**
- **MySQL 8**
- **Maven**

## 📂 Project Structure
expense-tracker/
├── src/main/java/com/example/expensetracker/
│ ├── model/ # Hibernate entities (Expense.java)
│ ├── dao/ # Data Access Layer
│ ├── service/ # Business logic
│ ├── util/ # HibernateUtil.java
│ └── App.java # Main console app
├── src/main/resources/
│ └── hibernate.cfg.xml
├── pom.xml
├── README.md
└── .gitignore


## ⚙️ Setup
1. Clone this repo:
   ```sh
   git clone https://github.com/YOUR_USERNAME/expense-tracker.git
   cd expense-tracker
   
2.Update hibernate.cfg.xml with your MySQL credentials.

3.Run the app:

mvn clean install
mvn exec:java -Dexec.mainClass="com.example.expensetracker.App"

📸 Demo

Console menu:

=== Expense Tracker ===
1. Add Expense
2. Show All Expenses
3. Delete Expense
4. Show Total Expenses
5. Show Expenses by Category
6. Exit

📝 Future Improvements

Add Swing/JavaFX UI

Export expenses to CSV/PDF

User authentication
