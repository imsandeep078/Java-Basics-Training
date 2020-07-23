package com.capgemini.Collectionframework.list;

import java.util.ArrayList;
import java.util.Iterator;

public class Testarraylist2 {
	public static void main(String[] args) {

		ArrayList<Object> al=new ArrayList<Object>();
		al.add(2);
		al.add("aman");
		al.add(3.2);
		al.add('A');

		Iterator<Object> it=al.iterator();
		while(it.hasNext())
		{
			Object r=it.next();
			System.out.println(r);
		}
	}

}
