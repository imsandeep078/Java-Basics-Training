package com.Generic.list.LinkedList;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestA {
	public static void main(String[] args) {
		LinkedList<Integer> li=new LinkedList<Integer>();
		li.add(1);
		li.add(12);
		li.add(123);
		li.add(1234);
		li.add(12345);

		System.out.println("--------------For Loop------------");
		for (int i = 0; i < 5; i++) {
			Integer r=li.get(i);
			System.out.println(r);
		}

		System.out.println("--------------Foreach Loop------------");
		for (Integer d : li) {
			System.out.println(d);			
		}

		System.out.println("-------------Iterator--------------");
		Iterator<Integer> it=li.iterator();
		while (it.hasNext()) {
			Integer d =it.next();
			System.out.println(d);

		}

		System.out.println("-------------ListIterator--------------");
		ListIterator<Integer> lit=li.listIterator();
		System.out.println("----------->Forward");
		while (lit.hasNext()) {
			Integer d =lit.next();
			System.out.println(d);

		}
		System.out.println("<-----------Backward");
		while (lit.hasPrevious()) {
			Integer d =lit.previous();
			System.out.println(d);

		}
	}

}
