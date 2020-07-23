package com.capgemini.Collectionframework.list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Stack;

public class TestStackString {

	public static void main(String[] args) {
		Stack<String> st=new Stack<String>();
		st.add("abc");
		st.add("def");
		st.add("ghi");
		st.add("jkl");
		
		System.out.println("*********FOR LOOP************");
		for (int i = 0; i < 4; i++) {
			String r=st.get(i);
			System.out.println(r);
			
		}
		
		System.out.println("*********FOR-EACH LOOP************");
		for (String r : st) {
			System.out.println(r);
		}
		
		System.out.println("*********ITERATOR************");
		Iterator<String> it=st.iterator();
		while (it.hasNext()) {
			String r =it.next();
			System.out.println(r);
			
		}
		
		System.out.println("*********stSTITERATOR************");
		ListIterator<String> lit=st.listIterator();
		System.out.println("---------->FORWARD");
		while (lit.hasNext()) {
			String r =lit.next();
			System.out.println(r);
			
		}
		System.out.println("<----------BACKWARD");
		while(lit.hasPrevious()) {
			String r =lit.previous();
			System.out.println(r);
		}
	}

}
