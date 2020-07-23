package com.capgemini.Array.genric;

interface Gm {
	void gm();
}

public class TestLembda3 {
	public static void main(String[] args) {
		
		Gm m=() -> System.out.println("Good morning");
		
		m.gm();
		
	}

}
