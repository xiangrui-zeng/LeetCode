package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class FourNum {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
//		if (isPalindrome2(111121111)) {
//			System.out.println("true");
//		} else {
//			System.out.println("false");
//		}
//		int[] nums = {1, 0, -1, 0, -2, 2};
//		int[] nums = {0,0,0,0};
//		int[] nums = {-2,0,5,-1,-5,5,3};
//		int[] nums = {-1,2,2,-5,0,-1,4};
		int[] nums = {0,1,5,0,1,5,5,-4};
		List<List<Integer>> result = fourSum(nums, 11);
		
		System.out.println(result.toString());
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> results = new ArrayList<List<Integer>>();
		if (nums == null || nums.length < 4) {
			return results;
		}

		Arrays.sort(nums);

		for (int i = 0; i < nums.length - 3; i++) {
			if (i == 0 || nums[i] > nums[i - 1]) {
				for (int j = i + 1; j < nums.length - 2; j++) {
					if (j == i + 1 || nums[j] > nums[j - 1]) {
						int reverseTarget = target - nums[i] - nums[j];
						int start = j + 1;
						int end = nums.length - 1;
						while (start < end) {
							if (nums[start] + nums[end] == reverseTarget) {
								List<Integer> result = new ArrayList<Integer>();
								result.add(nums[i]);
								result.add(nums[j]);
								result.add(nums[start]);
								result.add(nums[end]);
								start = start + 1;
								end = end - 1;
								results.add(result);

								// compare current start and previous start, if
								// same keep going
								while (start < end && nums[start] == nums[start - 1]) {
									start = start + 1;
								}
								while (start < end && nums[end] == nums[end + 1]) {
									end = end - 1;
								}
							} else if (nums[start] + nums[end] < reverseTarget) {
								start = start + 1;
							} else {
								end = end - 1;
							}
						}
					}
				}
			}
		}
		return results;
	}
	
	public static Map<String,Integer> getCombine2List(List<Integer> list) {
		Map<String,Integer> result = new HashMap<String, Integer>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				int sum = list.get(i) + list.get(j);
				String key = list.get(i) + "," + list.get(j);
				String reKey = list.get(j) + "," + list.get(i);
				if (result.containsKey(key) || result.containsKey(reKey)) {
					continue;
				}
				result.put(key, sum);
			}
		}
		return result;
	}
	
	public static Map<String,Integer> getCombine3List(List<Integer> list) {
		Map<String,Integer> result = new HashMap<String, Integer>();
		for (int i = 0; i < list.size(); i++) {
			for (int j = i+1; j < list.size(); j++) {
				for (int k = j+1; k < list.size(); k++) {
					int sum = list.get(i) + list.get(j) + list.get(k);
					String key = list.get(i) + "," + list.get(j) + ","  + list.get(k);
					String reKey1 = list.get(i) + "," + list.get(j) + ","  + list.get(k);
					String reKey2 = list.get(j) + "," + list.get(k) + ","  + list.get(i);
					String reKey3 = list.get(j) + "," + list.get(i) + ","  + list.get(k);
					String reKey4 = list.get(k) + "," + list.get(j) + ","  + list.get(i);
					String reKey5 = list.get(k) + "," + list.get(i) + "," + list.get(j);
					if (result.containsKey(key) || result.containsKey(reKey1) || result.containsKey(reKey2)
							|| result.containsKey(reKey3) || result.containsKey(reKey4) || result.containsKey(reKey5)) {
						continue;
					}
					result.put(key, sum);
				}
			}
		}
		return result;
	}
	
	
    
}




