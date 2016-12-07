package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class FizzBuzz {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(fizzBuzz(15));
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static List<String> _fizzBuzz(int n) {
        int threeCount = 3;
        int fiveCount = 0;
        int fifteenCount = 0;
        int counter = 0;
        List<String> result = new ArrayList<>();
        while (counter < n) {
        	threeCount = threeCount == 3 ? 1 : threeCount + 1;
        	fiveCount = fiveCount == 5 ? 1 : fiveCount + 1;
        	fifteenCount = fifteenCount == 15 ? 1 : fifteenCount + 1;
        	counter++;
        	String rs = fifteenCount == 15 ? "FizzBuzz" : threeCount == 3 ? "Fizz" : fiveCount == 5 ? "Buzz"  : "" + counter;
        	result.add(rs);
        }
        return result;
    }
	
	public static List<String> fizzBuzz(int n) {
		int i = 1;
		List<String> result = new ArrayList<>();
		while (i <= n) {
			if (i % 3 == 0) {
				if (i % 5 == 0) {
					result.add("FizzBuzz");
				} else {
					result.add("Fizz");
				}
			} else if (i % 5 == 0) {
				result.add("Buzz");
			}
			result.add(String.valueOf(i));
			i++;
			
		}
		return result;
		
	}

	
    
}



