package com.codegnan.beans;

public class Customer {
	private int id;
	private String name;
	private String accountNumber;
	private double balance;
	
	//no atg constructor
	public Customer() {
		
	}

// parametric constructor
	public Customer(int id, String name, String accountNumber, double balance) {
		super();
		this.id = id;
		this.name = name;
		this.accountNumber = accountNumber;
		this.balance = balance;
	}

// getter and setter methods
	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public double getBalance() {
		return balance;
	}


	public void setBalance(double balance) {
		this.balance = balance;
	}

// to string
	@Override
	public String toString() {
		return "Customer [id=" + id + ", name=" + name + ", accountNumber=" + accountNumber + ", balance=" + balance
				+ ", getId()=" + getId() + ", getName()=" + getName() + ", getAccountNumber()=" + getAccountNumber()
				+ ", getBalance()=" + getBalance() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	

}
