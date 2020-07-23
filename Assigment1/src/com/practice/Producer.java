package com.practice;

import java.util.Scanner;

public class Producer {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int a[] = new int[5];
		System.out.println(a.length);
		
		int b[] = {5,6,7,8,9};
		int c[] = {4,5,6,7,8};
		
		for (int i = 0; i < a.length; i++) {
			if(b[i] >= c[i]) {
				System.out.print(1);
			} else {
				System.out.print(0);
			}
		}

	}

}
