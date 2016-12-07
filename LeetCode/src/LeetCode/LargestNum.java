package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class LargestNum {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {0,0};
		System.out.println(largestNumber(nums));
//		System.out.println(lengthOfLongestSubstring2("bbtablud"));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration);
	}
	public static String largestNumber(int[] nums) {
		String result = "";
		List<String> temp = new ArrayList<>();
		for (int num : nums) {
			String tmp = String.valueOf(num);
			temp.add(tmp);
		}
		Collections.sort(temp,new Comparator<String>(){

			@Override
			public int compare(String o1, String o2) {
				int o1Len = o1.length();
				int o2Len = o2.length();
				char[] o1Array = o1.toCharArray();
				char[] o2Array = o2.toCharArray();
				int loopNum = o1Len >= o2Len ? o1Len : o2Len;
				for (int i = 0; i< loopNum; i++) {
					if (i >= o1Len) {
						return compare(o1, o2.substring(i));
					}
					if (i >= o2Len) {
						return compare(o1.substring(i), o2);
					}
					if (o1Array[i] > o2Array[i]) {
						return -1;
					}
					if (o1Array[i] < o2Array[i]) {
						return 1;
					}
				}
				return 0;
			}});
		for (int i = 0; i < temp.size(); i++) {
			if (result.isEmpty() && temp.get(i).equals("0")) {
				continue;
			}
			result += temp.get(i);
		}
		return result.isEmpty() ? "0" : result;
        
    }
	
}



