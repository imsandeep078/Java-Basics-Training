package com.capgemini.Array.genric;

// functional interface
interface Sum {
	int add(int a,int b);
}

public class TestLembda {
	public static void main(String[] args) {
		
		Sum f=(a,b)-> a+b;
		
		int k=f.add(20,40);
		
		System.out.println("Sum is "+k);
	}

}
