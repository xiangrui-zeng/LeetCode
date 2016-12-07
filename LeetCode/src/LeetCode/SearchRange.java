package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class SearchRange {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {5,7,7,8,8,10};
		int target = 8;
		System.out.println(searchInsert(nums,target)[0] + "," + searchInsert(nums,target)[1]);
//		System.out.println(lengthOfLongestSubstring2("bbtablud"));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration);
	}
	public static int[] searchInsert(int[] nums, int target) {
		int[] result = {-1,-1};
		int index = 0;
        for (; index < nums.length; index++) {
        	if (nums[index] <= target) {
        		if (nums[index] == target) {
        			if (result[0] == -1) {
        				result[0] = index;
        			}
        			result[1] = index;
        		} 
        	} else {
    			return result;
    		}
        }
        return result;
    }
	
    
}



