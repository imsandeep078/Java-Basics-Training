package com.capgemini.Array.genric;

public class Testint {
	public static void main(String[] args) {
		
		int[] a=new int[4];
		a[0]=10;
		a[1]=20;
		a[2]=30;
		a[3]=40;
		
		for(int i=0;i<a.length;i++)
		{
			System.out.println(a[i]);
		}
		/* 2nd way to initialize array */
		int[] b= {1,2,3,4};
		
		System.out.println("..................");
		
		for(int i=0;i<a.length;i++)
		{
			System.out.println(b[i]);
		}
		
	}

}
