package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class RepeatedSubstringPattern2 {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
//		System.out.println(repeatedSubstringPattern("abab"));
		System.out.println(repeatedSubstringPattern("ababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaa"));
//		System.out.println(lengthOfLongestSubstring2("bbtablud"));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration);
	}
	public static boolean repeatedSubstringPattern(String str) {
		char[] charArr = str.toCharArray();
		int subPos = 1;
		int currentPos = 0;
		int diffStr = 0;
		for (int i = 1; i < str.length(); i++) {
			if (i == 50) {
				i = 50;
			}
			if (charArr[i] == charArr[currentPos]) {
				
				if (i == str.length() - 1 && currentPos == subPos - 1) {
					return true;
				}
				if (currentPos == subPos - 1) {
					currentPos = 0;
				}
				currentPos++;
				continue;
			} else {
				subPos = str.indexOf(charArr[0], subPos);
				i = subPos - 1;
				currentPos = 0;
			}
		}
        return false;
    }
	
    
}



