# Smart Expense Tracker

A database design project for a Smart Expense Tracker developed using **MySQL**.

## 📌 Project Overview

The Smart Expense Tracker is designed to manage and track personal financial activities such as income, expenses, bank accounts, categories, and monthly budgets.

The database is designed using relational database concepts including:

- Primary Keys
- Foreign Keys
- Unique Constraints
- One-to-Many Relationships
- Entity Relationship Diagram (ERD)
- SQL Table Creation

## 🗄️ Database

**Database Name:** `expense_tracker`

### Tables

The database contains the following tables:

1. `users` – Stores user information.
2. `categories` – Stores income and expense categories.
3. `accounts` – Stores bank accounts and cards.
4. `transactions` – Stores income and expense transactions.
5. `budgets` – Stores monthly category-wise budgets.

## 🔗 Database Relationships

- User → Account : One-to-Many
- User → Budget : One-to-Many
- Account → Transaction : One-to-Many
- Category → Transaction : One-to-Many
- Category → Budget : One-to-Many

## 📊 Database Design

The project documentation includes:

- Entity and attribute descriptions
- Table structures
- Primary and Foreign Key definitions
- ER Diagram
- SQL database and table creation scripts

## 📄 Documentation

The complete database design documentation is available here:

**Smart Expense Tracker – Database Design**

## 🛠️ Technologies Used

- MySQL
- SQL
- PlantUML
- GitHub

## 👨‍💻 Project Status

**Database Design Completed ✅**

The Java application/backend will be developed in the next stage.
