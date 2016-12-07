package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class Triangle {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		List<Integer> tmp1 = new ArrayList<>();
		tmp1.add(2);
		List<Integer> tmp2 = new ArrayList<>();
		tmp2.add(3);
		tmp2.add(4);
		List<Integer> tmp3 = new ArrayList<>();
		tmp3.add(6);
		tmp3.add(5);
		tmp3.add(7);
		List<Integer> tmp4 = new ArrayList<>();
		tmp4.add(4);
		tmp4.add(1);
		tmp4.add(8);
		tmp4.add(3);
		result.add(tmp1);
		result.add(tmp2);
		result.add(tmp3);
		result.add(tmp4);
		System.out.println(minimumTotal(result));
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	
	//solve it by Dynamic Programming
	public static int minimumTotal(List<List<Integer>> triangle) {
        
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		result.add(triangle.get(triangle.size() - 1));
		for (int i = triangle.size() - 2; i >= 0; i--) {
			List<Integer> tmp = new ArrayList<>();
			for (int j = 0; j < triangle.get(i).size(); j++) {
				tmp.add(triangle.get(i).get(j) + Math.min(result.get(result.size()-1).get(j), result.get(result.size()-1).get(j+1)));
			}
			result.add(tmp);
		}
		
		
		return result.get(result.size()-1).get(0);
    }
	

	
    
}



