package com.github.mohamedennahdi.treeds4j.tree;

import java.util.List;

import com.github.mohamedennahdi.treeds4j.node.Node;
import com.github.mohamedennahdi.treeds4j.tree.bean.InMemoryTreeBean;
/**
 * 
 * @author ENNAHDI EL IDRISSI, Mohamed
 * @version
 * <p>
 * 		Since 2.0, August 2018
 * </p>
 * <p>
 * 		Introducing InMemoryTree and SQLTree classes.
 * 		<br />
 * 		The former allows to handle a list of elements with coherent relationships with each other.
 * 		<br />
 * 		The latter handles data directly from the database, taking advantage of Primary Keys and Foreigns keys
 * 		in a Unary Relation within an SQL table.
 * </p>
 * 
 */
public abstract class InMemoryTree<T extends InMemoryTreeBean<T>> extends Tree<T> {

	private List<T> originalList;
	
	protected InMemoryTree(List<T> originalList) {
		this.originalList = originalList;
	}
	
	
	public Node<T> loadTree(T element) {
		Node<T> root = new Node<>(element, null);

		this.loadChildren(root, originalList);

		return root;
	}
  
	protected List<T> loadChildren(Node<T> parent, List<T> list) {
		if (list != null && !list.isEmpty()) {
			for (T element : list) {
				if (loadChildrenComparison(element, parent)) {
					Node<T> nextParent = new Node<>(element, parent);
					if (element.getOriginalList() == null) {
						element.setOriginalList(originalList);
					}
					loadChildren(nextParent, element.getSubList());
				}
			}
		}
		return list;
	}
	
	public abstract boolean loadChildrenComparison(T element, Node<T> parentKey);
}
