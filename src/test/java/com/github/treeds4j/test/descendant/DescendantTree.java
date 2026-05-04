package com.github.treeds4j.test.descendant;

import java.util.List;

import com.github.treeds4j.node.Node;
import com.github.treeds4j.tree.InMemoryTree;

public class DescendantTree extends InMemoryTree<Descendant> {

	public DescendantTree(List<Descendant> originalList) {
		super(originalList);
	}

	@Override
	public boolean loadChildrenComparison(Descendant element,
			Node<Descendant> parentKey) {
		if (element.parent != null)
			return element.parent.equals(parentKey.getData().name);
		else
			return element.parent == parentKey.getData().name;
	}
}
