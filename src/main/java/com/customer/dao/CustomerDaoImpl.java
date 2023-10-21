package com.customer.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


import com.customer.bean.Customer;
import com.customer.util.DbConnection;

// @Repository indicates that its a class talk with DB.
public class CustomerDaoImpl implements CustomerDao {

	public List<Customer> getAllCustomers() {
		String sql = "SELECT ID,FIRST_NAME,LAST_NAME FROM CUSTOMER";
		List<Customer> customerList = new ArrayList<Customer>();
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {

				int id = resultSet.getInt("ID");
				String firstName = resultSet.getString("FIRST_NAME");
				String lastName = resultSet.getString("LAST_NAME");
				Customer cust = new Customer(id, firstName, lastName);
				customerList.add(cust);
			}

		} catch (Exception e) {
			System.out.println(" Error while SQL : " + e);
		}
		return customerList;
	}

	public Customer getByCustomerById(int id) {
		String sql = "SELECT ID,FIRST_NAME,LAST_NAME FROM CUSTOMER WHERE ID = ?";
		Customer customer = null;
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			ResultSet resultSet = prepareStatement.executeQuery();
			while (resultSet.next()) {
				int custId = resultSet.getInt("ID");
				String firstName = resultSet.getString("FIRST_NAME");
				String lastName = resultSet.getString("LAST_NAME");
				customer = new Customer(custId, firstName, lastName);
			}

		} catch (Exception e) {
			System.out.println(" Error while SQL : " + e);
		}
		return customer;
	}

	public Customer updateCustomer(Customer customer) {

		String sql = "UPDATE CUSTOMER SET FIRST_NAME = ?, LAST_NAME = ? WHERE ID = ?";
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
		
			prepareStatement.setString(1, customer.getFirstName());
			prepareStatement.setString(2, customer.getLastName());
			prepareStatement.setInt(3, (int) customer.getId());
			prepareStatement.executeUpdate();
			return customer;

		} catch (Exception e) {
			System.out.println(" Error while SQL : " + e);
		}
		return null;
	}

	public Customer createCustomer(Customer customer) {
		String sql = "INSERT INTO CUSTOMER(ID, FIRST_NAME, LAST_NAME) VALUES (?, ?, ?)";
		try {
			Connection connection = DbConnection.getConnection();
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, (int) customer.getId());
			prepareStatement.setString(2, customer.getFirstName());
			prepareStatement.setString(3, customer.getLastName());
			prepareStatement.executeUpdate();
			return customer;

		} catch (Exception e) {
			System.out.println(" Error while SQL : " + e);
		}
		return null;
	}

	public boolean deleteCustomer(int id) {
		String sql = "DELETE FROM CUSTOMER WHERE ID = ?";
		boolean isDeleted = false;
		try {
			Connection connection = DbConnection.getConnection();
			// connection.setAutoCommit(false);
			PreparedStatement prepareStatement = connection.prepareStatement(sql);
			prepareStatement.setInt(1, id);
			prepareStatement.executeUpdate();
			isDeleted = true;
			// connection.commit();
		} catch (Exception e) {
			System.out.println(" Error while SQL : " + e);
		}
		return isDeleted;
	}

}
