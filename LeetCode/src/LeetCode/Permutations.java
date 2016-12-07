package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class Permutations {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {1,2,3};
		int target = 8;
		System.out.println(permute(nums));
//		System.out.println(lengthOfLongestSubstring2("bbtablud"));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration);
	}
	public static List<List<Integer>> permute(int[] nums) {
		
        List<List<Integer>> result = new ArrayList<List<Integer>>();
    	result.add(new ArrayList<Integer>());
     
    	for (int i = 0; i < nums.length; i++) {
    		Set<List<Integer>> currentSet = new HashSet<List<Integer>>();
    		for (List<Integer> r : result) {
    			for (int j = 0; j < r.size() + 1; j++) {
    				r.add(j, nums[i]);
    				List<Integer> l = new ArrayList<Integer>(r);
    				r.remove(j);
    				currentSet.add(l);
    			}
    		}
    		result = new ArrayList<List<Integer>>(currentSet);
    	}
     
    	return result;
    }
	
    
}



