package com.capgemini.Collectionframework.list;

import java.util.ArrayList;

public class Testarraylist1 {
	public static void main(String[] args) {

		ArrayList<Object> al=new ArrayList<Object>();
		al.add(2);
		al.add("aman");
		al.add(3.2);
		al.add('A');

		for (Object ob : al) {
			System.out.println(ob);			
		}
	}

}
