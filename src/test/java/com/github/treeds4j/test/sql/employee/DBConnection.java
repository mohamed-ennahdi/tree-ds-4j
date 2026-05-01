package com.github.treeds4j.test.sql.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	
	private static DBConnection instance;
	private Connection connection;
	
	public DBConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");
				connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","123456");  
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}

	public Connection getConnection() {
		return connection;
	}

//	private void setConnection(Connection connection) {
//		this.connection = connection;
//	}
	
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
