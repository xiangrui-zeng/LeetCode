package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class AssignCookies {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		if (isPalindrome2(111121111)) {
//			System.out.println("true");
//		} else {
//			System.out.println("false");
//		}
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        
        int child = 0;
        int cookie = 0;
        
        while (child<g.length && cookie<s.length) {
            if (g[child]<=s[cookie]) {
            	child++;
                cookie++;
            } else {
            	cookie++;
            }
        }
        
        return child;
    }
}
	   




