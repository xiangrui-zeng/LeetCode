package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class CoinChange {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] arr = {2};
		System.out.println(isPowerOfFour(1));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	
	public static boolean isPowerOfFour(int num) {
		return num != 0 && (num & 0x55555555) == num && num == (num & -num);
    }
}
	   




