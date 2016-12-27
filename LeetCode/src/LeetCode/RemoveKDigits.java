package LeetCode;

import java.util.*;

public class RemoveKDigits {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {1, 2, 1, 3, 2, 5};
//		int[] nums = {0,1};
//		int[] nums = {-1};
//		int[] nums = {0,5,9};
//		System.out.println(findSubstringInWraproundString("abcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyzabcdefghijklmnopqrstuvwxyz"));
//		System.out.println(findSubstringInWraproundString("zab"));
		System.out.println(removeKdigits("100",1));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static String removeKdigits(String num, int k) {
		if (num.length() == k) return "0"; 
		for (int i = 0; i < k; i++) {
			for (int j = 0; j < num.length() - 1; j++) {
				if (num.charAt(j) > num.charAt(j + 1)) {
					num = num.substring(0, j) + num.substring(j + 1, num.length());
					break;
				} else {
					if (j == num.length() - 2) {
						num = num.substring(0, num.length() - 1);
					} else {
						continue;
					}
				}
			}
		}
		for (int i = 0; i < num.length(); i++) {
			if (num.charAt(i) != '0') {
				num = num.substring(i);
				break;
			}
		}
		if (num.startsWith("0")) return "0"; 
        
		return num.isEmpty() ? "0" : num;
    }
	
}



