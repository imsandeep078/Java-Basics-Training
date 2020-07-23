package com.capgemini.Collectionframework.list;

import java.util.ArrayList;
import java.util.Iterator;

public class TestarraylistExample {

	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		al.add("Priya");
		al.add(2);
		al.add('F');
		al.add(5.6);
		
		Iterator i=al.iterator();
		while(i.hasNext())
		{
			Object o=i.next();
			System.out.println(o);
		}
		
	}

}
