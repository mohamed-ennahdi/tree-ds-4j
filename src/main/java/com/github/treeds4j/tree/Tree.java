package com.github.treeds4j.tree;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.github.treeds4j.node.Node;
import com.github.treeds4j.tree.bean.TreeBean;
/**
 * 
 * @author ENNAHDI EL IDRISSI, Mohamed
 * @version
 * <p>
 * 		Since 1.0, July 2018
 * </p>
 * <p>
 * 		1.1, July 2018
 * 		<p>
 * 			Enhancement of traverse method.
 * 		</p> 
 * </p>
 * <p>
 * 		2.0, August 2018
 * 		<p>
 * 			Adaptation due to the introducing InMemoryTree and SQLTree classes.
 * 			<br />
 * 			The former allows to handle a list of elements with coherent relationships with each other.
 * 			<br />
 * 			The latter handles data directly from the database, taking advantage of Primary Keys and Foreigns keys
 * 			in a Unary Relation within an SQL table.
 * 		</p>
 * </p>
 *
 */
public abstract class Tree<T extends TreeBean<T>> {
	
	private static final Logger logger = LogManager.getLogger(Tree.class);
	static StringBuffer sb = new StringBuffer();
    
	public Tree() {
	}
	
	public abstract Node<T> loadTree(T element);
	protected abstract List<T> loadChildren(Node<T> parent, List<T> list);
	
    public static void traverse(Node<?> obj) {
    	traverse(obj, 0);
    }
    
    private static void traverse(Node<?> obj, int indentLevel) {
		if (obj != null) {
			for (int i = 0; i < obj.getChildren().size(); i++) {
				StringBuffer indentation = Tree.toIndent(indentLevel);
				indentation.append(obj.getChildren().get(i).getData());
				logger.info(indentation.toString());
				traverse(obj.getChildren().get(i), indentLevel + 1);
			}
		}
	}
    
    public static StringBuffer toIndent(int indentLevel) {
    	StringBuffer sb = new StringBuffer();
    	for (int j = 0; j < indentLevel; j++) {
//    		logger.info("\t");
    		sb.append("\t");
		}
    	return sb;
    }
    
}