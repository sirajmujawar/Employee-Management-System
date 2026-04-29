# 🧑‍💼 Employee Management System

A console-based **Employee Management System** built with **Java** and **JDBC**, using **PostgreSQL** as the database backend. This project demonstrates core JDBC concepts including database connectivity, CRUD operations, and a layered architecture pattern.

---

## 📋 Table of Contents

- [Overview](#overview)
- [Features](#features)
- [Project Structure](#project-structure)
- [Prerequisites](#prerequisites)
- [Database Setup](#database-setup)
- [Configuration](#configuration)
- [How to Run](#how-to-run)
- [Usage](#usage)
- [Technologies Used](#technologies-used)

---

## Overview

This application allows users to manage employee records through an interactive command-line menu. It connects to a PostgreSQL database using JDBC and supports full **Create, Read, Update, and Delete (CRUD)** operations on employee data.

---

## ✨ Features

| # | Feature |
|---|---------|
| 1 | Add a new employee |
| 2 | View all employees |
| 3 | Search employee by ID |
| 4 | Delete employee by ID |
| 5 | Update employee name by ID |
| 6 | Exit the application |

---

## 🗂️ Project Structure

```
employee_management_system/
├── pom.xml
└── src/
    └── main/
        └── java/
            └── com/qsp/employee_management_sysyem/
                ├── connectionlayer/
                │   └── Getconnection.java       # Manages JDBC database connection
                ├── entitylayer/
                │   └── Employee.java            # Employee POJO / model class
                ├── daolayer/
                │   └── EmployeeDao.java         # Data Access Object – all DB operations
                └── controllerlayer/
                    └── EmployeeController.java  # Main class – user menu & application flow
```

### Layer Descriptions

- **Connection Layer** – Establishes and returns a JDBC `Connection` object to the PostgreSQL database.
- **Entity Layer** – The `Employee` POJO holding fields: `empid`, `name`, `email`, `salary`, and `age`.
- **DAO Layer** – Contains all SQL queries (INSERT, SELECT, DELETE, UPDATE) using `PreparedStatement`.
- **Controller Layer** – Entry point (`main` method) that drives the interactive console menu.

---

## ✅ Prerequisites

Make sure you have the following installed before running this project:

- **Java JDK 8+**
- **Apache Maven 3.x**
- **PostgreSQL** (running locally on port `5432`)
- An IDE such as **Eclipse** or **IntelliJ IDEA** (optional but recommended)

---

## 🗄️ Database Setup

1. Open **pgAdmin** or the **psql** terminal and create the database:

```sql
CREATE DATABASE ems_db;
```

2. Connect to `ems_db` and create the `employee` table:

```sql
CREATE TABLE employee (
    empid   INT PRIMARY KEY,
    name    VARCHAR(100),
    email   VARCHAR(100),
    salary  DOUBLE PRECISION,
    age     INT
);
```

---

## ⚙️ Configuration

The database connection details are configured in:

```
src/main/java/com/qsp/employee_management_sysyem/connectionlayer/Getconnection.java
```

Update the following values to match your local PostgreSQL setup:

```java
String url  = "jdbc:postgresql://localhost:5432/ems_db";
String user = "postgres";
String pwd  = "your_password_here";
```

---

## ▶️ How to Run

### Using Maven

```bash
# Navigate to the project directory
cd employee_management_system

# Compile the project
mvn compile

# Run the application (replace with your main class path)
mvn exec:java -Dexec.mainClass="com.qsp.employee_management_sysyem.controllerlayer.EmployeeController"
```

### Using Eclipse IDE

1. Import the project as an **Existing Maven Project**.
2. Right-click `EmployeeController.java` → **Run As → Java Application**.

---

## 🖥️ Usage

Once the application starts, you will see the following menu:

```
welcome to employee management system
=========================================
1. for insert employee details
2. for fetch all employee details
3. for fetch employee details based on Id
4. for delete employee by id
5. for update employee by ID
6. for exit from application

please enter your choice:
```

Enter the number corresponding to the action you want to perform and follow the on-screen prompts.

### Example – Adding an Employee

```
please enter your choice: 1
---------please enter empid-----------
101
---------please enter empname-----------
John Doe
---------please enter empemail-----------
john.doe@example.com
---------please enter empsalary-----------
55000.0
---------please enter empage-----------
28
data is inserted---
```

---

## 🛠️ Technologies Used

| Technology | Purpose |
|------------|---------|
| Java | Core programming language |
| JDBC | Database connectivity API |
| PostgreSQL | Relational database |
| Apache Maven | Dependency management & build tool |
| PostgreSQL JDBC Driver `42.7.3` | JDBC driver for PostgreSQL |

---

## 📦 Maven Dependency

The PostgreSQL JDBC driver is declared in `pom.xml`:

```xml
<dependency>
    <groupId>org.postgresql</groupId>
    <artifactId>postgresql</artifactId>
    <version>42.7.3</version>
</dependency>
```

---

## 👤 Author

**Siraj Mujawar**  
Group ID: `com.qsp`  
Project: `employee_management_system`
