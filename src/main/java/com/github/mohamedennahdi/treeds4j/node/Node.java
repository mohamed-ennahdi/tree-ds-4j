package com.github.mohamedennahdi.treeds4j.node;

import java.util.ArrayList;
import java.util.List;
/**
 * 
 * @author ENNAHDI EL IDRISSI, Mohamed
 * @version
 * <p>
 * 		Since 1.0, July 2018
 * </p>
 * 
 */
public class Node<T> {
    private List<Node<T>> children = new ArrayList<>();
    private Node<T> parent = null;
    private T data = null;
    
    public Node() {
	}
    
    public Node(T data) {
        this.data = data;
    }

    public Node(T data, Node<T> parent) {
        this.data = data;
        this.parent = parent;
        if(parent != null) {
			this.parent.getChildren().add(this);
        }
    }

    public List<Node<T>> getChildren() {
        return children;
    }

    public void setParent(Node<T> parent) {
        this.parent = parent;
    }

    public void addChild(T data) {
        Node<T> child = new Node<>(data);
        child.setParent(this);
        this.children.add(child);
    }

    public void addChild(Node<T> child) {
        child.setParent(this);
        this.children.add(child);
    }

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public Node<T> getParent() {
		return parent;
	}

	public void setChildren(List<Node<T>> children) {
		this.children = children;
	}
    
    
}
