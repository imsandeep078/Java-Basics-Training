package com.capgemini.Array.genric;

// functional interface--Having only one abstract method.
interface Sqr {
	int square(int i);
}
public class TestLembda1 {
	public static void main(String[] args) {
		
		Sqr s=i -> i*i;
		
		int k=s.square(5);
		
		System.out.println(k);
	}

}
