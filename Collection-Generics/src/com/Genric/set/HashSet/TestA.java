package com.Genric.set.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class TestA {
	public static void main(String[] args) {
		HashSet<Integer> x=new HashSet<Integer>();
		x.add(1);
		x.add(2);
		x.add(3);
		x.add(4);
		x.add(5);

		System.out.println("------FOR_EACH LOOP-----------");
		for (Integer r : x) {
			System.out.println(r);
		}

		System.out.println("------Iterator-----------");
		Iterator<Integer> it=x.iterator();
		while(it.hasNext())
		{
			Integer r=it.next();
			System.out.println(r);
		}

	}
}
