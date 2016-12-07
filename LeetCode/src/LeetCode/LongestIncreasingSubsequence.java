package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] arr = {1,2,3,4,5,6,6};
		System.out.println(lengthOfLIS(arr));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static int lengthOfLIS(int[] nums) {
		int[] lis = new int[nums.length];
		int resLen = 0;
		for (int n : nums) {
			int index = Arrays.binarySearch(lis, 0, resLen, n);
			if (index < 0) {
				index = - (index + 1);
				lis[index] = n;
			}
			if (index == resLen) {
				resLen++;
			}
		}
		return resLen;
        
    }
}
	   




