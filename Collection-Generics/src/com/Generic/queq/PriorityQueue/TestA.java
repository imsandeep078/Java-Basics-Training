package com.Generic.queq.PriorityQueue;

import java.util.Iterator;
import java.util.PriorityQueue;

public class TestA {
	public static void main(String[] args) {
		PriorityQueue<Integer> p=new PriorityQueue<Integer>();
		p.add(10);
		p.add(6);
		p.add(4);
		p.add(9);
	
		
		System.out.println("--------------Foreach Loop------------");
		for (Integer d : p) {
			System.out.println(d);			
		}
		
		System.out.println("-------------Iterator--------------");
		Iterator<Integer> it=p.iterator();
		while (it.hasNext()) {
			Integer d =it.next();
			System.out.println(d);
			
		}
	}

}
