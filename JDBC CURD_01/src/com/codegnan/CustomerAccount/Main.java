package com.codegnan.CustomerAccount;

import java.sql.SQLException;

import com.codegnan.CustomerDao.CustomerDao;
import com.codegnan.beans.Customer;

public class Main {

	public static void main(String[] args)  {
		// TODO Auto-generated method stub
		try {
		
		CustomerDao customerDao = new CustomerDao();
		
		Customer customer = new Customer();
		
		customer.setName("swamy");
		customer.setAccountNumber("1233455635");
		customer.setBalance(1000.0);
		
		customerDao.addCustomer(customer);
		
		System.out.println("customer details added successfully ");
		
		//deposit money into account
		
		customerDao.deposit("123456789", 500.0);
		System.out.println("amount deposited successfully");
		
		//withdraw money from the account
		customerDao.withdraw("123456781", 200.0);
		System.out.println("customer amount withdraw successfully ");
		
		//update customer detalil
		
		customer.setName("swamy");
		customerDao.updateCustomer(customer);
		System.out.println("customer details update successfully ");
		
		//delete a customer
		
		customerDao.deleteCustomer("123456784");
		
		System.out.println("customer account deleted successfully ");
		
		// close the resources
		customerDao.close();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}

	}

}
