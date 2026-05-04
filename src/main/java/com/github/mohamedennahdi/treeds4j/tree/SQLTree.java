package com.github.mohamedennahdi.treeds4j.tree;

import java.sql.Connection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.mohamedennahdi.treeds4j.node.Node;
import com.github.mohamedennahdi.treeds4j.tree.bean.SQLTreeBean;
/**
 * 
 * @author ENNAHDI EL IDRISSI, Mohamed
 * @version
 * <p>
 * 		Since 2.0, August 2018
 * 	</p>
 * <p>
 * 		Introducing SQLTree class.
 * 		<br />
 * 		It handles data directly from the database, taking advantage of Primary Keys and Foreigns keys
 * 		in a Unary Relation within an SQL table.
 * </p>
 * 
 */
public class SQLTree<T extends SQLTreeBean<T>> extends Tree<T> {
	private final Logger logger = LogManager.getLogger(getClass());
	public Node<T> loadTree(T element) {
		Node<T> root = new Node<>(element, null);
		
		try (Connection c = SQLTreeBean.getConnection()) {
			this.loadChildren(root, element.getSubList());
		} catch (Exception e) {
			if (logger.isErrorEnabled()) {
				logger.error("SQLTree Error", e);
			}
		}

		return root;
	}
	
	public List<T> loadChildren(Node<T> root, List<T> list) {
		if (list != null) {
			for (T t : list) {
				Node<T> n = new Node<>(t, root);
				loadChildren(n, t.getSubList());
			}
		}
		return list;
	}
	
}
