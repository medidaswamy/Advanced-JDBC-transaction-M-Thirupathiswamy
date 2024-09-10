package com.codegnan.CustomerDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.codegnan.beans.Customer;
import com.codegnan.connection.ConnectionHelper;

public class CustomerDao {
	
	private Connection connection;
	
	public CustomerDao() throws SQLException{
		connection = ConnectionHelper.getConnection();
	}
	public void addCustomer(Customer customer) throws SQLException{
		String sql = "insert into customer(name,accountnumber,balance) values(?,?,?)";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			
			statement.setString(1, customer.getName());
			
			statement.setString(2, customer.getAccountNumber());
			
			statement.setDouble(3, customer.getBalance());
			
			statement.executeUpdate();
		}
	}
	
	public List<Customer> getAllCustomers() throws SQLException{
		List<Customer> customers = new ArrayList();
		
		String sql = "select*from customer";
		try(PreparedStatement statement = connection.prepareStatement(sql)) {
			ResultSet resultSet = statement.executeQuery();
			
			while(resultSet.next()) {
				Customer customer  = new Customer();
				customer.setId(resultSet.getInt("id"));
				
				customer.setName(resultSet.getString("name"));
				
				customer.setAccountNumber(resultSet.getString("accountnumber"));
				
				customer.setBalance(resultSet.getDouble("balance"));
				
				customers.add(customer);
			}
		}
		return customers;
	}
	public void updateCustomer(Customer customer) throws SQLException{
		String sql= "update customer set name=?,balance=?, where accountnumber=?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, customer.getName());
			
			statement.setDouble(2, customer.getBalance());
			
			statement.setString(3, customer.getAccountNumber());
			
			statement.executeUpdate();
			
			
			
		}
	}
	public void deleteCustomer(String accountNumber) throws SQLException{
		String sql = "delete from customer where accountnumber=?";
		
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setString(1, accountNumber);
			
			statement.executeUpdate();
		}
	}

	public void deposit(String accountNumber,double amount) throws SQLException{
		String sql = "update customer set balance=balance+? where accountnumber=?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setDouble(1, amount);
			
			statement.setString(2,  accountNumber);
			
			statement.executeUpdate();
		}
	}
	public void withdraw(String accountNumber, double amount) throws SQLException{
		String sql = "update customer set balance=balance-? where accountnumber=?";
		try(PreparedStatement statement = connection.prepareStatement(sql)){
			statement.setDouble(1, amount);
			statement.setString(2, accountNumber);
			statement.executeUpdate();
		}
		
	}
	public void close() throws SQLException{
		if(connection != null) {
			connection.close();
		}
	}
}
