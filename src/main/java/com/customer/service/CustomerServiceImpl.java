package com.customer.service;

import java.util.List;


import com.customer.bean.Customer;
import com.customer.dao.CustomerDao;
import com.customer.dao.CustomerDaoImpl;


public class CustomerServiceImpl implements CustomerService {
    
	// Dependency Injection and spring create object
	private static CustomerDao customerDao = new CustomerDaoImpl();

	public List<Customer> getAllCustomers() {
		return customerDao.getAllCustomers();
	}

	public Customer getByCustomerById(int id) {
		return customerDao.getByCustomerById(id);
	}

	public Customer updateCustomer(Customer customer) {
		return customerDao.updateCustomer(customer);
	}

	public Customer createCustomer(Customer customer) {
		return customerDao.createCustomer(customer);
	}

	public boolean deleteCustomer(int id) {
		return customerDao.deleteCustomer(id);
	}

}
