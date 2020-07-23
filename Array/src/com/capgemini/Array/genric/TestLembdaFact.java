package com.capgemini.Array.genric;

interface Factorial {
	int fact(int n);
}

public class TestLembdaFact {
	public static void main(String[] args) {
		
		Factorial f=n -> {
			int fac=1;
			for(int i=1;i<=n;i++)
			{
				fac=fac*i;
			}
			return fac;
			
		};
		
		System.out.println(f.fact(4));
	}

}
