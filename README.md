# 🧑‍💼 Employee Management System

## 📌 Project Overview

The Employee Management System is a Java-based backend application developed to manage employee information efficiently within an organization. The system provides role-based access control allowing administrators and employees to securely interact with employee records.

This project demonstrates backend development concepts such as database connectivity using JDBC, authentication handling, CRUD operations, and secure database interaction using PostgreSQL.

---

## 🚀 Features

* Role-based Login System (Admin & Employee)
* Secure Authentication
* Add Employee Records
* View Employee Details
* Update Employee Information
* Delete Employee Data
* CRUD Operations
* SQL Injection Prevention using PreparedStatement
* Structured Relational Database Design

---

## 🛠️ Technologies Used

* **Programming Language:** Java
* **Database Connectivity:** JDBC
* **Database:** PostgreSQL
* **Query Language:** SQL
* **Concepts:** Object-Oriented Programming (OOP)

---

## ⚙️ How the System Works

### 1️⃣ User Authentication

* Users log in using valid credentials.
* System verifies login details from the PostgreSQL database.
* Access is granted based on user role (Admin or Employee).

### 2️⃣ Admin Operations

Admin has full system access:

* Add new employee details
* View all employee records
* Update employee information
* Delete employee data

### 3️⃣ Employee Operations

Employee access is limited:

* View personal details
* Update allowed information

### 4️⃣ Database Interaction

* JDBC connects Java application with PostgreSQL database.
* SQL queries perform CRUD operations.
* Prepared Statements ensure secure query execution.

---

## 🗄️ Database Structure

Example Employee Table Fields:

* Employee ID
* Name
* Email
* Department
* Salary
* Role
* Login Credentials

---

## ▶️ How to Run the Project

### Step 1: Clone Repository

```bash
git clone https://github.com/your-username/Employee-Management-System.git
```

### Step 2: Open Project

* Import project into **Eclipse / IntelliJ IDEA / VS Code**

### Step 3: Setup Database

* Install PostgreSQL
* Create database:

```sql
CREATE DATABASE employee_db;
```

* Create required tables.

### Step 4: Configure Database Connection

Update database credentials inside Java file:

```java
String url = "jdbc:postgresql://localhost:5432/employee_db";
String user = "postgres";
String password = "your_password";
```

### Step 5: Run Application

* Execute the Main class file.
* Login as Admin or Employee.

---

## 📚 Learning Outcomes

* JDBC Database Connectivity
* Backend Application Development
* Role-Based Authorization
* Secure SQL Query Execution
* CRUD Operations Implementation

---

## 📈 Future Improvements

* Web-based UI using Spring Boot
* REST API Integration
* Password Encryption
* Cloud Database Deployment

---

## 👨‍💻 Author

**Aman Singh**
Full Stack Developer | Java Developer
GitHub: https://github.com/aman-singh
