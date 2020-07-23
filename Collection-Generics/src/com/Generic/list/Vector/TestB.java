package com.Generic.list.Vector;

import java.util.Vector;
import java.util.Iterator;
import java.util.ListIterator;

public class TestB {

	public static void main(String[] args) {
		Vector<Double> al=new Vector<Double>();
		al.add(2.42);
		al.add(3.23);
		al.add(3.21);
		al.add(4.25);
		al.add(6.98);
		
		System.out.println("--------------For Loop------------");
		for (int i = 0; i < 5; i++) {
			Double r=al.get(i);
			System.out.println(r);
		}
		
		System.out.println("--------------Foreach Loop------------");
		for (Double d : al) {
			System.out.println(d);			
		}
		
		System.out.println("-------------Iterator--------------");
		Iterator<Double> it=al.iterator();
		while (it.hasNext()) {
			Double d =it.next();
			System.out.println(d);
			
		}
		
		System.out.println("-------------ListIterator--------------");
		ListIterator<Double> lit=al.listIterator();
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
