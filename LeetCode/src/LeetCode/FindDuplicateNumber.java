package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class FindDuplicateNumber {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		if (isPalindrome2(111121111)) {
//			System.out.println("true");
//		} else {
//			System.out.println("false");
//		}
		int[] nums = {1,2,3,4,5,6,7,8,9,6};
		System.out.println(findDuplicate(nums));
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	
	public static int findDuplicate(int[] nums) {
		int duplicate = 0;
		for (int i = 0; i < nums.length; i++) {
			duplicate = nums[i];
			while (i != duplicate - 1) {
				if (nums[duplicate - 1] == duplicate) {
					return duplicate;
				} else {
					nums[i] = nums[duplicate - 1];
					nums[duplicate - 1] = duplicate;
					duplicate = nums[i];
				}
			}
			
		}
		return duplicate;
        
    }
	
}




