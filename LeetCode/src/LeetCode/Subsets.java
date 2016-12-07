package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Subsets {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] arr = {1,2,3};
		System.out.println(subsets(arr));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	
	public static List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> empty = new ArrayList<>();
		result.add(empty);
		for (int num : nums) {
			List<List<Integer>> subRes = new ArrayList<List<Integer>>();
			for (List<Integer> l : result) {
				List<Integer> tmp = new ArrayList<>();
				tmp.addAll(l);
				tmp.add(num);
				subRes.add(tmp);
			}
			result.addAll(subRes);
		}
        
		return result;
    }
}
	   




