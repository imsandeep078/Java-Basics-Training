package com.practice;

import java.util.Scanner;

public class DeleteElement {

	public static void main(String[] args) {

		int a[] = new int[5], num = 0;
		int len = a.length;
		int b[] = new int[len];
		for (int i = 0; i < len; i++) {
			num = i + 1;
			System.out.print("Enter " + num + " element : ");
			a[i] = new Scanner(System.in).nextInt();
		}
		System.out.println("Enter your element to be deleted : ");
		int del = new Scanner(System.in).nextInt();
		for (int i = 0; i < len; i++) {
			if (del != a[i]) {
				for (int j = i; j < len; j++) {
					b[j] = a[i];
				}
			} else {
				continue;
			}
		}
		for (int j = 0; j < b.length; j++) {

			System.out.print(b[j] + " ");
		}

	}

}
