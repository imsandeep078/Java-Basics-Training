package com.capgemini.Array.genric;

import java.util.Scanner;

public class TestScanner {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		
		System.out.println("enter the name");
		String name=sc.nextLine();
		
		System.out.println("enter the age");
		int age=sc.nextInt();
		
		System.out.println("enter the eight");
		double height=sc.nextDouble();
		
		System.out.println("Name is "+name);
		System.out.println("Age is "+age);
		System.out.println("Height is "+height);
	}
	

}
