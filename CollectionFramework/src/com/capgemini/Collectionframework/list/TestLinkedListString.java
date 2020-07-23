package com.capgemini.Collectionframework.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TestLinkedListString {

	public static void main(String[] args) {
		LinkedList<String> li=new LinkedList();
		li.add("abc");
		li.add("def");
		li.add("ghi");
		li.add("xyz");
		
		System.out.println("*********FOR LOOP************");
		for (int i = 0; i < 4; i++) {
			String r=li.get(i);
			System.out.println(r);
			
		}
		
		System.out.println("*********FOR-EACH LOOP************");
		for (String r : li) {
			System.out.println(r);
		}
		
		System.out.println("*********ITERATOR************");
		Iterator<String> it=li.iterator();
		while (it.hasNext()) {
			String r =it.next();
			System.out.println(r);
			
		}
		
		System.out.println("*********LIST-ITERATOR************");
		ListIterator<String> lit=li.listIterator();
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
