package com.capgemini.Collectionframework.list;

import java.util.ArrayList;
import java.util.ListIterator;

public class TestarraylistDouble4 {

	public static void main(String[] args) {
		ArrayList<Double> al=new ArrayList<Double>();
		al.add(2.42);
		al.add(3.23);
		al.add(3.21);
		al.add(4.25);
		al.add(6.98);

		ListIterator<Double> it=al.listIterator();
		System.out.println("----------->Forward");
		while (it.hasNext()) {
			Double d =it.next();
			System.out.println(d);

		}
		System.out.println("<-----------Backward");
		while (it.hasPrevious()) {
			Double d =it.previous();
			System.out.println(d);

		}

	}
}
