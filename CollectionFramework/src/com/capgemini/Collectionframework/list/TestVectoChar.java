package com.capgemini.Collectionframework.list;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.Vector;

public class TestVectoChar {

	public static void main(String[] args) {
		Vector<Character> v=new Vector();
		v.add('A');
		v.add('P');
		v.add('P');
		v.add('L');
		v.add('E');
		
		System.out.println("*********FOR LOOP************");
		for (int i = 0; i < 5; i++) {
			Character r=v.get(i);
			System.out.println(r);
			
		}
		
		System.out.println("*********FOR-EACH LOOP************");
		for (Character r : v) {
			System.out.println(r);
		}
		
		System.out.println("*********ITERATOR************");
		Iterator<Character> it=v.iterator();
		while (it.hasNext()) {
			Character r =it.next();
			System.out.println(r);
			
		}
		
		System.out.println("*********LIST-ITERATOR************");
		ListIterator<Character> lit=v.listIterator();
		System.out.println("---------->FORWARD");
		while (lit.hasNext()) {
			Character r =lit.next();
			System.out.println(r);
			
		}
		System.out.println("<----------BACKWARD");
		while(lit.hasPrevious()) {
			Character r =lit.previous();
			System.out.println(r);
		}
	}

}
