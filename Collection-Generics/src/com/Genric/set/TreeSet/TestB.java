package com.Genric.set.TreeSet;

import java.util.TreeSet;
import java.util.Iterator;

public class TestB {
	public static void main(String[] args) {
		TreeSet<Double> x=new TreeSet<Double>();
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
