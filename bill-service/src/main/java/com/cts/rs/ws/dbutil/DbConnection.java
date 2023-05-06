package com.cts.rs.ws.dbutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnection {

	private DbConnection() {
	}

	private static Connection connection;

	private static final String JDBC_URL = "jdbc:mysql://localhost:3306/consumer_db";
	private static final String JDBC_USER_NAME = "root";
	private static final String JDBC_PASSWORD = "root";
	private static final String JDBC_DRIVER_CLASS = "com.mysql.cj.jdbc.Driver";

	public static Connection getConnection() {

		try {
			Class.forName(JDBC_DRIVER_CLASS);
			System.out.println("Driver loaded sucessfully..");
		} catch (ClassNotFoundException e) {
			System.err.println("Driver Loading Error: " + e);
		}

		try {
			connection = DriverManager.getConnection(JDBC_URL, JDBC_USER_NAME, JDBC_PASSWORD);
			System.out.println("Connection Done..");
		} catch (SQLException e) {
			System.out.println("Connection Error...\n" + e);
		}

		return connection;
	}

}
