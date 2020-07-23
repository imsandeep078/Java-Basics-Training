package com.capgemini.Array.genric;

public class TestRecieveInteger {
	public static void main(String[] args) {
		int[] m= {10,20,30,40,50};
		recieve(m);
	}
	static void recieve(int[] a)
	{
		for(int i : a)
		{
			System.out.println(i);
		}
		
	}

}
