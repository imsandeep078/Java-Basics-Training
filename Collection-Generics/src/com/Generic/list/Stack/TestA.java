package com.Generic.list.Stack;

import java.util.Stack;
import java.util.Iterator;
import java.util.ListIterator;

public class TestA {

	public static void main(String[] args) {
		Stack<Integer> al=new Stack<Integer>();
		al.add(1);
		al.add(12);
		al.add(123);
		al.add(1234);
		al.add(12345);
		
		System.out.println("--------------For Loop------------");
		for (int i = 0; i < 5; i++) {
			Integer r=al.get(i);
			System.out.println(r);
		}
		
		System.out.println("--------------Foreach Loop------------");
		for (Integer d : al) {
			System.out.println(d);			
		}
		
		System.out.println("-------------Iterator--------------");
		Iterator<Integer> it=al.iterator();
		while (it.hasNext()) {
			Integer d =it.next();
			System.out.println(d);
			
		}
		
		System.out.println("-------------ListIterator--------------");
		ListIterator<Integer> lit=al.listIterator();
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
