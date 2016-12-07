package LeetCode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CombinationSumIII {
	
	public static void main(String[] args) {
		System.out.println(combinationSum3(3, 9));
	}
	
	public static List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		for (int i = 1; i<=9; i++) {
			if (i <= n) {
				List<Integer> l = new ArrayList<Integer>();
				l.add(i);
				result.add(l);
			}
		}
		for (int i = 2; i <= k; i++) {
			List<List<Integer>> tmp = new ArrayList<List<Integer>>();
			for (int j = i; j <= 9; j++) {
				for (List<Integer> nums : result) {
					int sum = 0;
					for (int num : nums) {
						sum += num;
					}
					List<Integer> tn = new ArrayList<>();
					if (i < k) {
						if (sum + j < n) {
							if (!nums.contains(j)) {
								tn.add(j);
								tn.addAll(nums);
								Collections.sort(tn);
								if (!tmp.contains(tn)) {
									tmp.add(tn);
								}
							}
						}
					} else {
						if (sum + j == n) {
							if (!nums.contains(j)) {
								tn.add(j);
								tn.addAll(nums);
								Collections.sort(tn);
								if (!tmp.contains(tn)) {
									tmp.add(tn);
								}
							}
						}
					}
				}
			}
			result.clear();
			result.addAll(tmp);
		}
        return result;
    }
    
}