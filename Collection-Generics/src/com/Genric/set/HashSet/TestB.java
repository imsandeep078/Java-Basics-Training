package com.Genric.set.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class TestB {
	public static void main(String[] args) {
		HashSet<Double> x=new HashSet<Double>();
		x.add(1.1);
		x.add(2.2);
		x.add(3.3);
		x.add(4.4);
		x.add(5.5);

		System.out.println("------FOR_EACH LOOP-----------");
		for (Double r : x) {
			System.out.println(r);
		}

		System.out.println("------Iterator-----------");
		Iterator<Double> it=x.iterator();
		while(it.hasNext())
		{
			Double r=it.next();
			System.out.println(r);
		}

	}
}
