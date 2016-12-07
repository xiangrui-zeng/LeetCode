package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class RepeatedSubstringPattern {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		System.out.println(repeatedSubstringPattern("abab"));
		//System.out.println(repeatedSubstringPattern("ababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaaababbaaaaa"));
//		System.out.println(lengthOfLongestSubstring2("bbtablud"));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration);
	}
	public static boolean repeatedSubstringPattern(String str) {
		if(splitString(str, 2)) {
			return true;
		}
		if(splitString(str, 3)) {
			return true;
		}
		if(splitString(str, 5)) {
			return true;
		}
		if(splitString(str, 7)) {
			return true;
		}
		
		return false;
	}
	
	public static boolean splitString(String str, int splitNum){
		if(str.length() % splitNum != 0){
			return false;
		}
		int length = str.length() / splitNum;
		String str1 = str.substring(0, length);
		for(int i = 1; i < splitNum; i++) {
			if(!str.substring(i * length, (i + 1) * length).equals(str1)) {
				return false;
			}
		}
		return true;
	}
}



