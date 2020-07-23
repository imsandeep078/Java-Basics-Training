package com.Genric.set.HashSet;

import java.util.HashSet;
import java.util.Iterator;

public class TestD {
	public static void main(String[] args) {
		HashSet<Character> x=new HashSet<Character>();
		x.add('A');
		x.add('P');
		x.add('P');
		x.add('L');
		x.add('E');

		System.out.println("------FOR_EACH LOOP-----------");
		for (Character r : x) {
			System.out.println(r);
		}

		System.out.println("------Iterator-----------");
		Iterator<Character> it=x.iterator();
		while(it.hasNext())
		{
			Character r=it.next();
			System.out.println(r);
		}

	}
}
