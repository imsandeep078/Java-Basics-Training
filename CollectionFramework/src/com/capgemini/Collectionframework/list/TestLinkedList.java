package com.capgemini.Collectionframework.list;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class TestLinkedList {

	public static void main(String[] args) {
		LinkedList li=new LinkedList();
		li.add(2.1);
		li.add("abc");
		li.add(22);
		li.add('M');
		
		System.out.println("*********FOR LOOP************");
		for (int i = 0; i < 4; i++) {
			Object r=li.get(i);
			System.out.println(r);
			
		}
		
		System.out.println("*********FOR-EACH LOOP************");
		for (Object r : li) {
			System.out.println(r);
		}
		
		System.out.println("*********ITERATOR************");
		Iterator it=li.iterator();
		while (it.hasNext()) {
			Object r =it.next();
			System.out.println(r);
			
		}
		
		System.out.println("*********LISTITERATOR************");
		ListIterator lit=li.listIterator();
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
