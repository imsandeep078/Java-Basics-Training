package com.Genric.set.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class Studenthelper {
	void display(HashSet<Student> k) {
		for (Student s : k) {
			System.out.println("Name is " + s.name);
			System.out.println("ID is " + s.id);
			System.out.println("Percentage is " + s.percentage);
			System.out.println("..........................");
		}
	}

	void check(HashSet<Student> p) {
		Iterator<Student> it = p.iterator();
		while (it.hasNext()) {
			Student st = it.next();
			if (st.percentage > 35) {
				System.out.println("Name is " + st.name);
				System.out.println("ID is " + st.id);
				System.out.println("Percentage is " + st.percentage);
				System.out.println("..........................");
			}
		}
	}

	void dist(HashSet<Student> p) {
		Iterator<Student> it = p.iterator();
		while (it.hasNext()) {
			Student st = it.next();
			if (st.percentage > 70) {
				System.out.println("Name is " + st.name);
				System.out.println("ID is " + st.id);
				System.out.println("Percentage is " + st.percentage);
				System.out.println("..........................");
			}
		}
	}

}
