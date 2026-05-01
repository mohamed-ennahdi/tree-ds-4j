package com.github.treeds4j.tree;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.github.treeds4j.node.Node;
import com.github.treeds4j.tree.bean.SQLTreeBean;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
/**
 * 
 * @author ENNAHDI EL IDRISSI, Mohamed
 * @version
 * <p>
 * 		Since 2.0, August 2018
 * 		<p>
 * 			Introducing SQLTree class.
 * 			<br />
 * 			It handles data directly from the database, taking advantage of Primary Keys and Foreigns keys
 * 			in a Unary Relation within an SQL table.
 * 		</p>
 * </p>
 * 
 */
public class SQLTree<T extends SQLTreeBean<T>> extends Tree<T> {
	private final Logger logger = LogManager.getLogger(getClass());
	public Node<T> loadTree(T element) {
		Node<T> root = new Node<T>(element, null);
		Connection c = null;
		try {
			c = SQLTreeBean.getConnection();
			this.loadChildren(root, element.getSubList());
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error(e);
			}
		} finally {
			try {
				if (c != null) {
					c.close();
				}
			} catch (SQLException e) {
				if (logger.isErrorEnabled()) {
					logger.error(e);
				}
			}
		}

		return root;
	}
	
	public List<T> loadChildren(Node<T> root, List<T> list) {
		if (list != null) {
			for (T t : list) {
				Node<T> n = new Node<T>(t, root);
				loadChildren(n, t.getSubList());
			}
		}
		return list;
	}
	
}
