package com.Generic.list.LinkedList;

import java.util.LinkedList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestB {
	public static void main(String[] args) {
		LinkedList<Double> li=new LinkedList<Double>();
		li.add(1.1);
		li.add(12.12);
		li.add(123.123);
		li.add(1234.1234);
		li.add(12345.12345);

		System.out.println("--------------For Loop------------");
		for (int i = 0; i < 5; i++) {
			Double r=li.get(i);
			System.out.println(r);
		}

		System.out.println("--------------Foreach Loop------------");
		for (Double d : li) {
			System.out.println(d);			
		}

		System.out.println("-------------Iterator--------------");
		Iterator<Double> it=li.iterator();
		while (it.hasNext()) {
			Double d =it.next();
			System.out.println(d);

		}

		System.out.println("-------------ListIterator--------------");
		ListIterator<Double> lit=li.listIterator();
		System.out.println("----------->Forward");
		while (lit.hasNext()) {
			Double d =lit.next();
			System.out.println(d);

		}
		System.out.println("<-----------Backward");
		while (lit.hasPrevious()) {
			Double d =lit.previous();
			System.out.println(d);

		}
	}

}
