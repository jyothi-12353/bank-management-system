package com.jyothi.bankmanagementsystem;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "accounts")
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String accountNumber;
    private String name;
    private String email;
    private String phone;
    private String password;
    private double balance;
    private String accountType;

    public Account() {
    }

    public Account(String accountNumber,
                   String name,
                   String email,
                   String phone,
                   String password,
                   double balance,
                   String accountType) {

        this.accountNumber = accountNumber;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.balance = balance;
        this.accountType = accountType;
    }

    public int getId() {
        return id;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public String getPassword() {
        return password;
    }

    public double getBalance() {
        return balance;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }
}