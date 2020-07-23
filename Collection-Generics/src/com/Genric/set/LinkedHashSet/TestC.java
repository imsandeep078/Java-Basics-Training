package com.Genric.set.LinkedHashSet;

import java.util.LinkedHashSet;
import java.util.Iterator;

public class TestC {
	public static void main(String[] args) {
		LinkedHashSet<String> x=new LinkedHashSet<String>();
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
