package com.practice;

class Solution {
	
	public static int int_string(String a, String b) {
		
		int result;
		if(a.contains(b)) {
			result = 1;
		} else {
			result = 0;
		}
		return result;
		
	}
}

public class SubString {

	public static void main(String[] args) {
	
		int ans = Solution.int_string("abcd", "abcde");
		
		if(ans == 1) {
			System.out.println("YES");
		} else {
			System.out.println("NO");
		}
	}

}
