package com.github.treeds4j.test.descendant;

import com.github.treeds4j.tree.bean.InMemoryTreeBean;

public class Descendant extends InMemoryTreeBean<Descendant> {
    String name;
    String parent;
    int birth;
    String death;
    String religion;
    String gender;
    
    public Descendant() {
		this.parent = "-";
		this.name = "-";
	}
    
    public Descendant(String name, String parent, int birth, String death, String religion, String gender) {
        this.name = name;
        this.parent = parent;
        this.birth = birth;
        this.death = death;
        this.religion = religion;
        this.gender = gender;
    }
    @Override
    public String toString() {
    	return name + " " + parent + " " + birth + " " + death + " " + religion + " " + gender;
    }

	@Override
	public boolean subListComparison(Descendant element) {
		return this.name.equals(element.parent);
	}

}
