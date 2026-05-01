package com.github.treeds4j.tree.bean;

import java.sql.Connection;
import java.sql.SQLException;
/**
 * 
 * @author ENNAHDI EL IDRISSI, Mohamed
 * @version
 * <p>
 * 		Since 2.0, August 2018
 * 		<p>
 * 			Introducing InMemoryTree and SQLTree classes.
 * 			<br />
 * 			The former allows to handle a list of elements with coherent relationships with each other.
 * 			<br />
 * 			The latter handles data directly from the database, taking advantage of Primary Keys and Foreigns keys
 * 			in a Unary Relation within an SQL table.
 * 		</p>
 * </p>
 *
 */
public abstract class SQLTreeBean<T> extends TreeBean<T> {
	
	private static Connection connection;
	
	public SQLTreeBean() throws SQLException {
	}
	
	public SQLTreeBean(Connection connection) {
		setConnection(connection);
	}
	
	public static Connection getConnection() {
		return connection;
	}

	public static void setConnection(Connection connection) {
		SQLTreeBean.connection = connection;
	}
	
}
