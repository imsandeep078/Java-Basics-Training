package com.Generic.list.Arraylist;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestC {

	public static void main(String[] args) {
		ArrayList<String> al=new ArrayList<String>();
		al.add("Ram");
		al.add("Shyam");
		al.add("Gopal");
		al.add("Mohan");
		al.add("Sohan");
		
		System.out.println("--------------For Loop------------");
		for (int i = 0; i < 5; i++) {
			String r=al.get(i);
			System.out.println(r);
		}
		
		System.out.println("--------------Foreach Loop------------");
		for (String d : al) {
			System.out.println(d);			
		}
		
		System.out.println("-------------Iterator--------------");
		Iterator<String> it=al.iterator();
		while (it.hasNext()) {
			String d =it.next();
			System.out.println(d);
			
		}
		
		System.out.println("-------------ListIterator--------------");
		ListIterator<String> lit=al.listIterator();
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
