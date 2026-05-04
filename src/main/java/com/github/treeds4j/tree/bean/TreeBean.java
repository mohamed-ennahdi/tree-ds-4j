package com.github.treeds4j.tree.bean;

import java.util.List;
/**
 * 
 * @author ENNAHDI EL IDRISSI, Mohamed
 * @version
 * <p>
 * 		Since 1.0, July 2018
 * </p>
 * <p>
 * 		1.1, July 2018
 * <p>
 * 		Enhancement of traverse method.
 * </p> 
 * <p>
 * 		2.0, August 2018
 * <p>
 * <p>
 * 		Adding subList() method due to the introducing InMemoryTree and SQLTree classes.
 * </p>
 */
public abstract class TreeBean<T> {
	public TreeBean() {
	}
	
	public abstract List<T> getSubList();
}
