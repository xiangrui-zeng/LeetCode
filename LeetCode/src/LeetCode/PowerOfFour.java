package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class PowerOfFour {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] arr = {2};
		System.out.println(coinChange(arr, 3));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	
	public static int coinChange(int[] coins, int amount) {
		if (amount < 1) return 0;
	    int[] dp = new int[amount + 1]; 
	    Arrays.fill(dp, Integer.MAX_VALUE);
	    dp[0] = 0;
	    for (int coin : coins) {
	        for (int i = coin; i <= amount; i++) {
	            if (dp[i - coin] != Integer.MAX_VALUE) {
	                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
	            }
	        }
	    }
	    return dp[amount] == Integer.MAX_VALUE ? -1 : dp[amount];
	}
}
	   




