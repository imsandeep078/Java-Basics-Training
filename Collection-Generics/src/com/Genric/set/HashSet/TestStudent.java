package com.Genric.set.HashSet;

import java.util.HashSet;

public class TestStudent {
	public static void main(String[] args) {
		Student s1 = new Student(1, "mani", 30.67);
		Student s2 = new Student(2, "bani", 54.67);
		Student s3 = new Student(3, "hani", 60.67);
		Student s4 = new Student(4, "sani", 80.67);
		Student s5 = new Student(5, "gani", 90.67);

		HashSet<Student> sal = new HashSet<Student>();
		sal.add(s1);
		sal.add(s2);
		sal.add(s3);
		sal.add(s4);
		sal.add(s5);

		Studenthelper h = new Studenthelper();
		h.display(sal);
		// h.check(sal);
		//h.dist(sal);

	}
}
