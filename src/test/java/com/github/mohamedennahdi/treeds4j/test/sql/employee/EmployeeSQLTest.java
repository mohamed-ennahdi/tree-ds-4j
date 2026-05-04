package com.github.mohamedennahdi.treeds4j.test.sql.employee;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

import com.github.mohamedennahdi.treeds4j.node.Node;
import com.github.mohamedennahdi.treeds4j.tree.SQLTree;
import com.github.mohamedennahdi.treeds4j.tree.Tree;


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
	void traversalTest() {
		try (Connection sqlConnection = DriverManager.getConnection(mysql.getJdbcUrl(),mysql.getUsername(),mysql.getPassword())) {
			Node<EmployeeSQL> d = new SQLTree<EmployeeSQL>().loadTree(new EmployeeSQL(sqlConnection));
			Tree.traverse(d);

			assertTrue(d.getChildren().get(0).getChildren().isEmpty());
			assertEquals(10002, d.getChildren().get(1).getChildren().get(0).getData().getManagerId());
			assertEquals(10007, d.getChildren().get(1).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getData().getManagerId());
			assertEquals(10007, d.getChildren().get(1).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(1).getData().getManagerId());
			assertEquals(10007, d.getChildren().get(1).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(0).getChildren().get(2).getData().getManagerId());
		} catch (SQLException e) {
			if (logger.isErrorEnabled()) {
				logger.error("", e);
			}
		}
	}
	
	@AfterAll
	static void destroy() {
		mysql.close();
	}
}
