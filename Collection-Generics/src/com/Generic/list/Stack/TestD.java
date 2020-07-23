package com.Generic.list.Stack;

import java.util.Stack;
import java.util.Iterator;
import java.util.ListIterator;

public class TestD {

	public static void main(String[] args) {
		Stack<Character> al=new Stack<Character>();
		al.add('G');
		al.add('R');
		al.add('A');
		al.add('P');
		al.add('E');
		
		System.out.println("--------------For Loop------------");
		for (int i = 0; i < 5; i++) {
			Character r=al.get(i);
			System.out.println(r);
		}
		
		System.out.println("--------------Foreach Loop------------");
		for (Character d : al) {
			System.out.println(d);			
		}
		
		System.out.println("-------------Iterator--------------");
		Iterator<Character> it=al.iterator();
		while (it.hasNext()) {
			Character d =it.next();
			System.out.println(d);
			
		}
		
		System.out.println("-------------ListIterator--------------");
		ListIterator<Character> lit=al.listIterator();
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
