package com.capgemini.Collectionframework.list;

import java.util.ArrayList;

public class Testarraylist {

	public static void main(String[] args) {
		
		ArrayList<Object> al=new ArrayList<Object>();
		al.add(24);
		al.add("chinnu");
		al.add(2.5);
		al.add('g');
		
		for(int i=0;i<4;i++)
		{
			Object r=al.get(i);
			System.out.println(r);
		}
	}

}
