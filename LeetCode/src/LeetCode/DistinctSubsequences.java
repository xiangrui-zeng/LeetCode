package LeetCode;

import java.util.Arrays;

public class DistinctSubsequences {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(numDistinct("rabbbit","rabbit"));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	
	public static int numDistinct(String s, String t) {
        int[][] result = new int[t.length() + 1][s.length() + 1];
        
        //init result
        Arrays.fill(result[0], 1);
        for (int i = 1; i <= t.length(); i++) {
        	result[i][0] = 0;
        }
        
        //start DP, fill all result array
        for (int i = 1; i <= t.length(); i++) {
        	for (int j = 1; j <= s.length(); j++) {
        		if (t.charAt(i-1) == s.charAt(j-1)) {
        			//plus pre row value
        			result[i][j] = result[i-1][j-1] + result[i][j-1];
        		} else {
        			//same with pre value
        			result[i][j] = result[i][j-1];
        		}
        	}
        }
        
        
		return result[t.length()][s.length()];
    }
}
	   




