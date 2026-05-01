package com.github.treeds4j.tree.bean;

import java.util.ArrayList;
import java.util.List;
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
public abstract class InMemoryTreeBean<T> extends TreeBean<T> {
	private List<T> originalList;

	public List<T> getOriginalList() {
		return originalList;
	}

	public void setOriginalList(List<T> originalList) {
		this.originalList = originalList;
	}

	@Override
	public List<T> getSubList() {
		List<T> list = new ArrayList<T>();
		
		for (T d : originalList) {
			if (subListComparison(d)) {
				list.add(d);
			}
		}
		
		return list;
	}
	
	public abstract boolean subListComparison(T element);
    
}
