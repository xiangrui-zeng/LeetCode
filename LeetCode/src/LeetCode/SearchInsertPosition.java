package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class SearchInsertPosition {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {1,3,5,6};
		int target = 7;
		System.out.println(searchInsert(nums,target));
//		System.out.println(lengthOfLongestSubstring2("bbtablud"));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration);
	}
	public static int searchInsert(int[] nums, int target) {
		int index = 0;
        for (; index < nums.length; index++) {
        	if (nums[index] >= target) {
        		return index;
        	}
        }
        return index;
    }
	
    
}



