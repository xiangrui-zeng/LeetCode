package LeetCode;


public class SingleNumberIII {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {1, 2, 1, 3, 2, 5};
//		int[] nums = {0,1};
//		int[] nums = {-1};
//		int[] nums = {0,5,9};
		System.out.println(singleNumber(nums));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration);
	}
	public static int[] singleNumber(int[] nums) {
        int[] result = new int[2];
        int xor = 0;
        for (int num : nums) {
        	xor = xor ^ num;
        }
        
        int mask = xor & ~ (xor - 1);
        
        int num1 = 0;
        int num2 = 0;
        for (int num : nums) {
        	if ((num & mask) > 0) {
        		num1 ^= num;
        	} else {
        		num2 ^= num;
        	}
        }
        result[0] = num1;
        result[1] = num2;
        
        return result;
    }
	
}



