package com.Genric.set.TreeSet;

import java.util.TreeSet;
import java.util.Iterator;

public class TestC {
	public static void main(String[] args) {
		TreeSet<String> x=new TreeSet<String>();
		x.add("Sam");
		x.add("Dam");
		x.add("Game");
		x.add("Same");
		x.add("Lame");

		System.out.println("------FOR_EACH LOOP-----------");
		for (String r : x) {
			System.out.println(r);
		}

		System.out.println("------Iterator-----------");
		Iterator<String> it=x.iterator();
		while(it.hasNext())
		{
			String r=it.next();
			System.out.println(r);
		}

	}
}
