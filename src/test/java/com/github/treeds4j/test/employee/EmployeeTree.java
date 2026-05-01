package com.github.treeds4j.test.employee;

import java.util.List;

import com.github.treeds4j.node.Node;
import com.github.treeds4j.tree.InMemoryTree;

public class EmployeeTree extends InMemoryTree<Employee> {

	public EmployeeTree(List<Employee> originalList) {
		super(originalList);
	}

	@Override
	public boolean loadChildrenComparison(Employee element, Node<Employee> parentKey) {
		if (element.bossId != null)
			return element.bossId.equals(parentKey.getData().id);
		else
			return element.bossId == parentKey.getData().id;
	}

}
