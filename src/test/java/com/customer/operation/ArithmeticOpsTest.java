package com.customer.operation;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;

public class ArithmeticOpsTest {
	
	static ArithmeticOps arithmeticOps;
	@BeforeClass
	public static void init() {
		arithmeticOps = new ArithmeticOps();
	}
	
	@Test
	public void testAddTwoNumbers() {
		int a = 10;
		int b = 20;
		int add = arithmeticOps.add(a, b);
		assertEquals(30, add);
	}
	@Test
	public void testAddNegativeNumbers() {
		int a = -10;
		int b = -20;
		int add = arithmeticOps.add(a, b);
		assertEquals(-30, add);
	}
	//@Ignore
	@Test
	public void testAddNegativeAndPositiveNumbers() {
		int a = 10;
		int b = -20;
		int add = arithmeticOps.add(a, b);
		assertEquals(-10, add);
	}

	public static void destroy() {
		arithmeticOps = null;
	}

}
