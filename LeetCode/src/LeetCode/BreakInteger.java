package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class BreakInteger {
	public static void main(String[] args) {
		System.out.println(integerBreak(10));
	}
	public static int integerBreak(int n) {
		if (n == 2) {
			return 1;
		} else if (n == 3) {
			return 2;
		}
		int result = 1;
		int tmp = n % 3;
		int threeNum = tmp == 1 ? n / 3 - 1 : n / 3;
		int twoNum = tmp == 0 ? 0 : tmp == 1 ? 2 : 1; 
		while (threeNum > 0) {
			result *= 3;
			threeNum --;
		}
		while (twoNum > 0) {
			result *= 2;
			twoNum --;
		}
		return result;
        
    }
    
}



