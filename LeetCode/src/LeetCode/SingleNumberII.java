package LeetCode;

public class SingleNumberII {
	
	public static void main(String[] args) {
		int[] arr = {1,2,3,2,2,3,3};
		System.out.println(singleNumber(arr));
	}
	
	public static int singleNumber(int[] A) {
	     int x1 = 0;   
	     int x2 = 0; 
	     int x3  = 0;
	     int mask = 0;

	     for (int i : A) {
	        x3 ^= x2 & x1 & i;
	        x2 ^= x1 & i;
	        x1 ^= i;
	        mask = ~(x1 & ~x2 & x3);
	        x3 &= mask;
	        x2 &= mask;
	        x1 &= mask;
	     }

	     return x1;  // p = 3, in binary form p = '011', then p1 = p2 = 1, 
	                 // so we can return either x1 or x2; 
	                 // But if p = 4, in binary form p = '100', then only p3 = 1, 
	                 // which implies we can only return x3.
	}
    
}