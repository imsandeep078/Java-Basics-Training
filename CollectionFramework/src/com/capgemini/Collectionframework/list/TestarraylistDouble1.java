package com.capgemini.Collectionframework.list;

import java.util.ArrayList;

public class TestarraylistDouble1 {
	public static void main(String[] args) {
		ArrayList<Double> al=new ArrayList<Double>();
		al.add(2.42);
		al.add(3.23);
		al.add(3.21);
		al.add(4.25);
		al.add(6.98);
		
		for (Double d : al) {
			System.out.println(d);			
		}
	}

}
