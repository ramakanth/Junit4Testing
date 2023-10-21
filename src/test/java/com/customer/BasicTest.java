package com.customer;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class BasicTest {
	
	public BasicTest(){
		//System.out.println("constructor has been called....");
	}
	@BeforeClass
	public static void init() {
		// Create any db connections or create object or collections, any resources creation
		System.out.println("@BeforeClass Init method has been called....");
	}
	
	@Before
	public void initEachMethod() {
		System.out.println("@Before initEachMethod method has been called....");
	}
	
	/* 
	 * Unit test case for test the customer if exist or not.
	 */
	@Test
	public void testGetByCustomerById() {
		System.out.println("testGetByCustomerById() method has been called....");
		int expectedData = 1;
		int actualData = 1;
		
		//expected data, actual data
		assertEquals(expectedData, actualData);
	}
	@Test
	public void testGetByCustomerByIdNegative() {
		System.out.println("testGetByCustomerByIdNegative() method has been called....");
		int expectedData = 1;
		int actualData = 1;
		
		//expected data, actual data
		assertEquals(expectedData, actualData);
	}
	
	@After
	public void destroyAfterEach() {
		System.out.println("@After destroyAfterEach method has been called....");
	}
	@AfterClass
	public static void destroy() {
		// Destroy any db connections or create object or collections, any resources creation
		System.out.println("@AfterClass destroy method has been called....");
	}

}
