package com.customer.service;

import java.util.List;

import com.customer.bean.Customer;

public interface CustomerService {
	public List<Customer> getAllCustomers();
	public Customer getByCustomerById(int id);
	public Customer updateCustomer(Customer customer);
	public Customer createCustomer(Customer customer);
	public boolean deleteCustomer(int id);


}
