package com.capgemini.Collectionframework.list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class TestVector {

	public static void main(String[] args) {
		Vector v=new Vector();
		v.add(12);
		v.add("sam");
		v.add(2.4);
		v.add('S');
		
		System.out.println("*********FOR LOOP************");
		for (int i = 0; i < 4; i++) {
			Object r=v.get(i);
			System.out.println(r);
			
		}
		
		System.out.println("*********FOR-EACH LOOP************");
		for (Object r : v) {
			System.out.println(r);
		}
		
		System.out.println("*********ITERATOR************");
		Iterator it=v.iterator();
		while (it.hasNext()) {
			Object r =it.next();
			System.out.println(r);
			
		}
		
		System.out.println("*********LISTITERATOR************");
		ListIterator lit=v.listIterator();
		System.out.println("---------->FORWARD");
		while (lit.hasNext()) {
			Object r =lit.next();
			System.out.println(r);
			
		}
		System.out.println("<----------BACKWARD");
		while(lit.hasPrevious()) {
			Object r =lit.previous();
			System.out.println(r);
		}
	}

}
