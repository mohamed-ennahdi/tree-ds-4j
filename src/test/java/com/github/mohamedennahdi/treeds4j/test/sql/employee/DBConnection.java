package com.github.mohamedennahdi.treeds4j.test.sql.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class DBConnection {
	
	private final Logger logger = LogManager.getLogger(getClass());
	
	private static DBConnection instance;
	private Connection connection;
	
	public DBConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");  
			} catch (ClassNotFoundException | SQLException e) {
				logger.error("DBConnection Error", e);
			}
	}

	public Connection getConnection() {
		return connection;
	}

	public static Connection getInstance() throws SQLException {
		if (instance == null) {
			instance = new DBConnection();
		} else {
			if (instance.getConnection().isClosed()) {
				instance = new DBConnection();
			}
		}
		return instance.connection;
	}
}
