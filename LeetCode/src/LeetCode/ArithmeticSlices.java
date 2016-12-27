package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class ArithmeticSlices {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] A = {1,2,3,1,1,1};
		System.out.println(numberOfArithmeticSlices(A));
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static int numberOfArithmeticSlices(int[] A) {
        List<Integer> pre = new ArrayList<>();
        int dis = A[1] - A[0];
        int num = 2;
		for (int i = 2; i < A.length; i++) {
        	if (A[i] - A[i - 1] == dis) {
        		num++;
        	} else {
        		if (num > 2) {
        			pre.add(num);
        		}
        		num = 2;
        		dis = A[i] - A[i - 1];
        	}
        }
		if (num > 2) {
			pre.add(num);
		}
		int result = 0;
		for (int loop : pre) {
			result += 1; 
			for (int i = 4; i < loop + 1; i++) {
				result += i - 2;
			}
		}
		return result;
    }
	
	
    
}



