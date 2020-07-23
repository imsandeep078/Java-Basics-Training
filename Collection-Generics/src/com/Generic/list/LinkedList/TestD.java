package com.Generic.list.LinkedList;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestD {
	public static void main(String[] args) {
		LinkedList<Character> li=new LinkedList<Character>();
		li.add('R');
		li.add('Y');
		li.add('T');
		li.add('H');
		li.add('M');

		System.out.println("--------------For Loop------------");
		for (int i = 0; i < 5; i++) {
			Character r=li.get(i);
			System.out.println(r);
		}

		System.out.println("--------------Foreach Loop------------");
		for (Character d : li) {
			System.out.println(d);			
		}

		System.out.println("-------------Iterator--------------");
		Iterator<Character> it=li.iterator();
		while (it.hasNext()) {
			Character d =it.next();
			System.out.println(d);

		}

		System.out.println("-------------ListIterator--------------");
		ListIterator<Character> lit=li.listIterator();
		System.out.println("----------->Forward");
		while (lit.hasNext()) {
			Character d =lit.next();
			System.out.println(d);

		}
		System.out.println("<-----------Backward");
		while (lit.hasPrevious()) {
			Character d =lit.previous();
			System.out.println(d);

		}
	}

}
