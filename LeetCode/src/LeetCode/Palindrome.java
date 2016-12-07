package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class Palindrome {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		if (isPalindrome2(1001)) {
			System.out.println("true");
		} else {
			System.out.println("false");
		}
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static boolean isPalindrome(int x) {
		String all = Integer.toString(x);
		int mid = all.length() / 2;
		if (all.length() % 2 > 0) {
			String pre = all.substring(0, mid);
			String tail = all.substring(mid + 1, all.length());
			return pre.equals(tail);
		} else {
			String pre = all.substring(0, mid);
			String tail = all.substring(mid, all.length());
			return pre.equals(tail);
		}
    }
	
	public static boolean isPalindrome2(int x) {
		if (x < 0) return false;
		int newNum = 0;
		int ori = x;
		while (x / 10 != 0 || x % 10 != 0) {
			int tmp = x % 10;
			newNum = newNum * 10 + tmp;
			x = x / 10;
		}
		return ori == newNum;
    }
    
}



