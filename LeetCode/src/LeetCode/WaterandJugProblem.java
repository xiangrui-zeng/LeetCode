package LeetCode;

import java.util.Arrays;

public class WaterandJugProblem {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		String A = "20EE:FGb8:85a3:0:0:8A2E:0370:7334";
		System.out.println(canMeasureWater(22003,31237,1));
		
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	public static boolean canMeasureWater(int x, int y, int z) {
        boolean[] result = new boolean[Math.max(x, y) + 1];
        if (z > x + y) {
        	return false;
        }
        if (z == 0) {
        	return true;
        }
        result[0] = true;
        result[x] = true;
        result[y] = true;
        for (int j = 0;j < result.length; j++) {
        	for (int i = 0;i < result.length; i++) {
            	if (result[i]) {
            		if (i - (Math.min(x, y)) > 0) {
            			result[i - (Math.min(x, y))] = true;
            		} else {
            			result[Math.max(x, y) + i - (Math.min(x, y))] = true;
            		}
            		if ((Math.min(x, y) + i) < Math.max(x, y)) {
            			result[Math.min(x, y) + i] = true;
            		} else {
            			result[(Math.min(x, y) + i) - Math.max(x, y)] = true;
            		}
            	}
            }
        }
        boolean[] r = new boolean[x + y + 1];
        
        for (int i = 0; i< result.length; i++) {
        	r[i] = result[i];
        }
        
        for (int i = Math.max(x, y) + 1; i < x + y + 1; i++) {
        	r[i] = result[Math.max(x, y)] && result[i - Math.max(x, y)];
        }
		
		return  r[z];
    }
    
	public static boolean canMeasureWater1(int x, int y, int z) {
	    //limit brought by the statement that water is finallly in one or both buckets
	    if(x + y < z) return false;
	    //case x or y is zero
	    if( x == z || y == z || x + y == z ) return true;
	    
	    //get GCD, then we can use the property of Bézout's identity
	    return z%GCD(x, y) == 0;
	}

	public static int GCD(int a, int b){
	    while(b != 0 ){
	        int temp = b;
	        b = a%b;
	        a = temp;
	    }
	    return a;
	}
	
}



