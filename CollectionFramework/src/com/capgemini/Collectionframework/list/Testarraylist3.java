package com.capgemini.Collectionframework.list;

import java.util.ArrayList;
import java.util.ListIterator;

public class Testarraylist3 {

	public static void main(String[] args) {
		ArrayList<Object> al=new ArrayList<Object>();
		al.add(2);
		al.add("aman");
		al.add(3.2);
		al.add('A');

		ListIterator<Object> m=al.listIterator();
		System.out.println("----------->FORWARD");
		while(m.hasNext())
		{
			Object r=m.next();
			System.out.println(r);
		}
		System.out.println("<----------BACKWARD");
		while(m.hasPrevious())
		{
			Object r=m.previous();
			System.out.println(r);
		}
	}

}
