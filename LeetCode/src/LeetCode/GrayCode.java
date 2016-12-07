package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class GrayCode {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(grayCode(0));
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if (n == 0) {
			result.add(0);
			return result;
		}
		int max = 0xFFFFFFFF;
		max = max >>> (32-n);
		int i = 0;
		while (max >= i) {
			result.add(i);
			i++;
		}
		return result;
    }

	
    
}



