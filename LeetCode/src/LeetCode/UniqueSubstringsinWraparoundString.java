package LeetCode;

import java.util.*;

public class UniqueSubstringsinWraparoundString {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {1, 2, 1, 3, 2, 5};
//		int[] nums = {0,1};
//		int[] nums = {-1};
//		int[] nums = {0,5,9};
//		System.out.println(findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
//		System.out.println(findSubstringInWraproundString("zab"));
		System.out.println(findSubstringInWraproundString("abaab"));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static int findSubstringInWraproundString(String p) {
		
		int[] result = new int[26];
		for (int i = 0; i < p.length(); i++) {
			int len = 1;
			for (int j = 1; j + i < p.length(); j++){
				if (p.charAt(i + j) - p.charAt(i + j -1) == 1 || (p.charAt(i + j -1) == 'z' && p.charAt(i + j) == 'a')) {
					len++;
				} else {
					break;
				}
			}
			if (result[p.charAt(i) - 'a'] < len) {
				result[p.charAt(i) - 'a'] = len;
			}
		}
		
		int sum = 0;
		for (int r : result) {
			sum += r;
		}
		return sum;
        
    }
	
}



