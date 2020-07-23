package com.Generic.list.LinkedList;

import java.util.LinkedList;

public class TestStudent {

	public static void main(String[] args) {
		Student s1 = new Student(1, "mani", 30.67);
		Student s2 = new Student(2, "bani", 54.67);
		Student s3 = new Student(3, "hani", 60.67);
		Student s4 = new Student(4, "sani", 80.67);
		Student s5 = new Student(5, "gani", 90.67);

		LinkedList<Student> sal = new LinkedList<Student>();
		sal.add(s1);
		sal.add(s2);
		sal.add(s3);
		sal.add(s4);
		sal.add(s5);
		
		Studenthelper h = new Studenthelper();
		 //h.display(sal);
		h.check(sal);
		//h.dist(sal);
	}

}
