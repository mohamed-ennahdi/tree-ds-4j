package com.github.treeds4j.test.sql.employee;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.testcontainers.containers.MySQLContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import com.github.treeds4j.node.Node;
import com.github.treeds4j.tree.SQLTree;
import com.github.treeds4j.tree.Tree;


@Testcontainers
class EmployeeSQLTest {
	private final Logger logger = LogManager.getLogger(getClass());
	
	
	@Container
    private static final MySQLContainer<?> mysql = new MySQLContainer<>("mysql:8.0.36")
            .withDatabaseName("testdb")
            .withUsername("testuser")
            .withPassword("testpass")
            .withUrlParam("useSSL", "false")
            .withInitScript("ddl/employees_script.sql"); // Runs once at container startup
	
	@Test
	void test() {
		
		logger.info("testing");
		
		
		try (Connection sqlConnection = DriverManager.getConnection(
                mysql.getJdbcUrl(),      // jdbc:mysql://localhost:32789/testdb
                mysql.getUsername(),     // testuser
                mysql.getPassword())) {
			Node<EmployeeSQL> d = new SQLTree<EmployeeSQL>().loadTree(new EmployeeSQL(sqlConnection));
			Tree.traverse(d);
		} catch (SQLException e) {
			logger.error("", e);
		}
	}
	
	@AfterAll
	static void destroy() {
		mysql.close();
	}
}
