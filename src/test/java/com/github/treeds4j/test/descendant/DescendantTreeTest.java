package com.github.treeds4j.test.descendant;

import java.util.ArrayList;
import java.util.List;

import com.github.treeds4j.node.Node;
import com.github.treeds4j.tree.Tree;

import org.junit.Test;

public class DescendantTreeTest {
	
	public List<Descendant> descendants = new ArrayList<Descendant>() {
		private static final long serialVersionUID = 1L;
		{
			add(new Descendant("Elizabeth", "-", 1926, "-", "Anglican", "F"));
			add(new Descendant("Charles", "Elizabeth", 1948, "-", "Anglican", "M"));
			add(new Descendant("William", "Charles", 1982, "-", "Anglican", "M"));
			add(new Descendant("George", "William", 2013, "-", "Anglican", "M"));
			add(new Descendant("Charlotte", "William", 2015, "-", "Anglican", "F"));
			add(new Descendant("Henry", "Charles", 1984, "-", "Anglican", "M"));
			add(new Descendant("Andrew", "Elizabeth", 1960, "-", "Anglican", "M"));
			add(new Descendant("Beatrice", "Andrew", 1988, "-", "Anglican", "F"));
			add(new Descendant("Eugenie", "Andrew", 1990, "-", "Anglican", "F"));
			add(new Descendant("Edward", "Elizabeth", 1964, "-", "Anglican", "M"));
			add(new Descendant("James", "Edward", 2007, "-", "Anglican", "M"));
			add(new Descendant("Louise ", "Edward", 2003, "-", "Anglican", "F"));
			add(new Descendant("Anne", "Elizabeth", 1950, "-", "Anglican", "F"));
		}
	};
	
	@Test
	public void test() {
		Node<Descendant> d = new DescendantTree(descendants).loadTree(new Descendant());
		Tree.traverse(d);
	}
}
