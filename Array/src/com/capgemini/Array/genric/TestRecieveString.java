package com.capgemini.Array.genric;

public class TestRecieveString {
	public static void main(String[] args) {
		String[] m= {"apple","grapes","orange","mango"};
		recieve(m);
	}
	static void recieve(String[] a)
	{
		for(String i : a)
		{
			System.out.println(i);
		}
		
	}

}
