package com.capgemini.Collectionframework.list;

import java.util.ArrayList;

public class TestarraylistExample1 {
	public static void main(String[] args) {
		ArrayList al=new ArrayList();
		al.add("Priya");
		al.add(2);
		al.add('F');
		al.add(5.6);

		for (Object object : al) {
			System.out.println(object);
		}
	}
}
