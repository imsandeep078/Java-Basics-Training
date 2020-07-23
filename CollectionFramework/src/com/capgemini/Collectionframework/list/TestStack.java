package com.capgemini.Collectionframework.list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class TestStack {

	public static void main(String[] args) {
		Stack st=new Stack();
		st.add(2.1);
		st.add("abc");
		st.add(22);
		st.add('M');
		
		System.out.println("*********FOR LOOP************");
		for (int i = 0; i < 4; i++) {
			Object r=st.get(i);
			System.out.println(r);
			
		}
		
		System.out.println("*********FOR-EACH LOOP************");
		for (Object r : st) {
			System.out.println(r);
		}
		
		System.out.println("*********ITERATOR************");
		Iterator it=st.iterator();
		while (it.hasNext()) {
			Object r =it.next();
			System.out.println(r);
			
		}
		
		System.out.println("*********stSTITERATOR************");
		ListIterator lit=st.listIterator();
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
