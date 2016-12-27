package LeetCode;

import java.util.Arrays;
import java.util.Comparator;

public class OnesAndZero {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String[] A = {"10", "0001", "111001", "1", "0"};
		String[] B = {"10", "1", "0"};
		System.out.println(findMaxForm(B,1,1));
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	
	//issue
	public static int findMaxForm1(String[] strs, int m, int n) {
		int result = 0;
		Arrays.sort(strs, new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				
				return o1.length() - o2.length();
			}
			
		});
        for (String str : strs) {
        	if (str.length() > m + n) {
        		break;
        	}
        	int numOf1 = 0;
        	for (int i = 0; i < str.length(); i++) {
        		if (str.charAt(i) == '0') {
        			numOf1++;
        		}
        	}
        	if (numOf1 <= m && str.length() - numOf1 <= n) {
        		result++;
        		m -= numOf1;
        		n -= str.length() - numOf1;
        	}
        }
		
		return result;
    }
	
	public static int findMaxForm(String[] strs, int m, int n) {
		int[][] result = new int[m+1][n+1];
        for (String str : strs) {
        	int[] tmp = count(str);
        	for (int i = m; i >= tmp[0]; i--) {
        		for (int j = n; j >= tmp[1]; j--) {
        			result[i][j] = Math.max(1 + result[i-tmp[0]][j-tmp[1]], result[i][j]);
        		}
        	}
        }
		
		return result[m][n];
    }
	
	public static int[] count(String str) {
		int[] r = new int[2];
		for(char c : str.toCharArray()){
			r[c-'0']++;
		}
		return r;
	}
	
    
}



