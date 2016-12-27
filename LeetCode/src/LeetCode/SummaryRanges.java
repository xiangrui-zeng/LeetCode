package LeetCode;

import java.util.*;

public class SummaryRanges {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {0,1,2,4,5,7};
//		int[] nums = {0,1};
//		int[] nums = {-1};
//		int[] nums = {0,5,9};
		System.out.println(summaryRanges(nums));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration);
	}
	public static List<String> summaryRanges(int[] nums) {
		List<String> result = new ArrayList<>();
		if (nums.length == 0) return result;
		if (nums.length == 1) {
			result.add(nums[0] + "");
			return result;
		}
		int tmp = nums[0] - 0;
		String str = "" + nums[0];
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] - tmp == i) {
				if (i == nums.length - 1) {
					str += "->" + String.valueOf(nums[i]);
					result.add(str);
					break;
				}
				continue;
			} else {
				if (nums[i-1] - tmp != Integer.valueOf(str)) {
					str += "->" + String.valueOf(nums[i-1]);
				}
				result.add(str);
				str = "" + nums[i];
				tmp = nums[i] - i;
				if (i == nums.length - 1) {
					result.add(str);
				}
			}
		}
		
		return result;
    }
	
	public List<String> summaryRanges2(int[] nums) {
		List<String> list = new ArrayList<>();
		for (int i = 0, len = nums.length, k; i < len; i = k + 1) {
			k = help(nums, i, len);
			if (i != k)
				list.add("" + nums[i] + "->" + nums[k]);
			else
				list.add("" + nums[i]);
		}
		return list;
	}

	private int help(int[] nums, int l, int r) {
		while (l + 1 < r) {
			int m = (l + r) / 2;
			if (nums[m] - nums[l] == m - l)
				l = m;
			else
				r = m;
		}
		return l;
	}
	
}



