package com.capgemini.Array.genric;

public class TestRecieveDouble {
	public static void main(String[] args) {
		double[] m= {10.10,20.20,30.30,40.40,50.50};
		recieve(m);
	}
	static void recieve(double[] a)
	{
		for(double i : a)
		{
			System.out.println(i);
		}
		
	}

}
