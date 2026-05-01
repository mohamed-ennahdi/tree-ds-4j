package com.github.treeds4j.tree;

import java.util.List;

import com.github.treeds4j.node.Node;
import com.github.treeds4j.tree.bean.InMemoryTreeBean;
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
public abstract class InMemoryTree<T extends InMemoryTreeBean<T>> extends Tree<T> {

	private List<T> originalList;
	
	public InMemoryTree(List<T> originalList) {
		this.originalList = originalList;
	}
	
	
	public Node<T> loadTree(T element) {
		Node<T> root = new Node<T>(element, null);

		this.loadChildren(root, originalList);

		return root;
	}
  
	protected List<T> loadChildren(Node<T> parent, List<T> list) {
		if (list != null && !list.isEmpty()) {
			for (T element : list) {
				if (loadChildrenComparison(element, parent)) {
					Node<T> nextParent = new Node<T>(element, parent);
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
