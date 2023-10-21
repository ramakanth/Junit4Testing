package com.customer.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;
import java.util.Random;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import com.customer.bean.Customer;

public class CustomerServiceTest {

	private static CustomerService service = null;
    private static int id = 0;

	@BeforeClass
	public static void init() {
		Random random = new Random();
		int nextInt = random.nextInt(100);
	
		service = new CustomerServiceImpl();
		Customer customer = new Customer();
		customer.setId(nextInt);
		customer.setFirstName("AAA");
		customer.setLastName("BBB");
		customer.setEmail("aaa"+nextInt+"@gmail.com");
		service.createCustomer(customer);
		id = nextInt;

	}
	
	@Test
	public void testCreateCustomer() {
		Customer customer = new Customer();
		customer.setId(1000);
		customer.setFirstName("BAAA");
		customer.setLastName("CBBB");
		customer.setEmail("aaa1000@gmail.com");
		Customer createCustomer = service.createCustomer(customer);
		assertNotNull(createCustomer);
	}

	@Test
	public void testGetByCustomerById() {
		Customer customer = service.getByCustomerById(id);
		assertEquals("AAA", customer.getFirstName());
		assertEquals("BBB", customer.getLastName());
	}

	@Test
	public void testGetByCustomerByIdEmpty() {
		Customer customer = service.getByCustomerById(200);
		assertNull(customer);
	}

	@Test
	public void testGetAllCustomers() {
		List<Customer> allCustomers = service.getAllCustomers();
		assertTrue(allCustomers.size() > 0);
	}

	@AfterClass
	public static void destroy() {
		service = null;
	}
}
