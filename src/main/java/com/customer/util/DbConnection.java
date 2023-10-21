package com.customer.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {

	public static Connection getConnection() {
		Connection connection = null;
		String jdbcUrl = "jdbc:oracle:thin:@localhost:1521:XE"; // JDBC URL for Oracle
		String username = "RAMA";
		String password = "aadhya";

		try {
			connection = DriverManager.getConnection(jdbcUrl, username, password);

		} catch (Exception e) {
			System.out.println("Exception from DB : " + e);
		}
		return connection;

	}

}
