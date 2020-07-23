package com.Generic.list.LinkedList;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestC {
	public static void main(String[] args) {
		LinkedList<String> li=new LinkedList<String>();
		li.add("Mad");
		li.add("Dad");
		li.add("Sad");
		li.add("Cad");
		li.add("Pad");

		System.out.println("--------------For Loop------------");
		for (int i = 0; i < 5; i++) {
			String r=li.get(i);
			System.out.println(r);
		}

		System.out.println("--------------Foreach Loop------------");
		for (String d : li) {
			System.out.println(d);			
		}

		System.out.println("-------------Iterator--------------");
		Iterator<String> it=li.iterator();
		while (it.hasNext()) {
			String d =it.next();
			System.out.println(d);

		}

		System.out.println("-------------ListIterator--------------");
		ListIterator<String> lit=li.listIterator();
		System.out.println("----------->Forward");
		while (lit.hasNext()) {
			String d =lit.next();
			System.out.println(d);

		}
		System.out.println("<-----------Backward");
		while (lit.hasPrevious()) {
			String d =lit.previous();
			System.out.println(d);

		}
	}

}
