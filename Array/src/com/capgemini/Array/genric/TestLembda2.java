package com.capgemini.Array.genric;

interface Circlearea {
	double area(double r);
}

public class TestLembda2 {
	public static void main(String[] args) {
		double pi=3.142;
		Circlearea c=r -> pi*r*r;
		
		double d=c.area(3);
		
		System.out.println(d);
	}

}
