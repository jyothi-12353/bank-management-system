# 🏦 Bank Management System

A web-based Bank Management System developed using **Java, Spring Boot, MySQL, and Thymeleaf**. This application allows users to create bank accounts, log in, manage their account balance, and view transaction history.

## 🚀 Features

- User Registration
- User Login and Logout
- Account Dashboard
- Account Number Generation
- Account Balance Management
- Deposit Money
- Withdraw Money
- Transaction History
- MySQL Database Integration
- Responsive User Interface

## 🛠️ Technology Stack

| Technology | Purpose |
|---|---|
| Java 21 | Backend Programming |
| Spring Boot | Backend Framework |
| Spring Data JPA | Database Operations |
| MySQL | Database |
| Thymeleaf | Frontend Template Engine |
| HTML5 | Web Structure |
| CSS3 | Styling |
| Maven | Dependency Management |
| VS Code | Development Environment |
| MySQL Workbench | Database Management |

## 📂 Project Structure

```text
bankmanagementsystem/
│
├── src/
│   ├── main/
│   │   ├── java/com/jyothi/bankmanagementsystem/
│   │   │   ├── Account.java
│   │   │   ├── AccountRepository.java
│   │   │   ├── HomeController.java
│   │   │   ├── Transaction.java
│   │   │   ├── TransactionRepository.java
│   │   │   └── BankmanagementsystemApplication.java
│   │   │
│   │   └── resources/
│   │       ├── templates/
│   │       │   ├── index.html
│   │       │   ├── login.html
│   │       │   ├── register.html
│   │       │   └── dashboard.html
│   │       └── application.properties
│   │
│   └── test/
│
├── pom.xml
└── README.md
```

## ⚙️ Installation and Setup

### Prerequisites

- Java JDK 21
- MySQL Server
- MySQL Workbench
- Maven
- Git

### 1. Clone the Repository

```bash
git clone https://github.com/jyothi-12353/bank-management-system.git
```

### 2. Open the Project

```bash
cd bank-management-system
```

### 3. Create MySQL Database

Open MySQL Workbench and execute:

```sql
CREATE DATABASE bank_management;
```

### 4. Configure Database

Create `application.properties` inside:

`src/main/resources/`

Use the following configuration:

```properties
spring.application.name=bankmanagementsystem

spring.datasource.url=jdbc:mysql://localhost:3306/bank_management
spring.datasource.username=YOUR_MYSQL_USERNAME
spring.datasource.password=YOUR_MYSQL_PASSWORD

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.format_sql=true

spring.thymeleaf.cache=false

server.port=8081
```

Replace the database username and password with your own MySQL credentials.

### 5. Run the Application

On Windows:

```bash
mvnw.cmd spring-boot:run
```

Alternatively:

```bash
mvn spring-boot:run
```

### 6. Open in Browser

```text
http://localhost:8081
```

## 📸 Application Pages

- Home Page
- Registration Page
- Login Page
- Account Dashboard
- Deposit and Withdrawal
- Transaction History

## 👩‍💻 Developer

**Jyothi Bandila**

GitHub: [jyothi-12353](https://github.com/jyothi-12353)

Project Repository: [Bank Management System](https://github.com/jyothi-12353/bank-management-system)

---

*Developed as a Java Full Stack Development project.*

**Note:** This project is intended for learning and demonstration. Additional security hardening is required before real-world banking use.
