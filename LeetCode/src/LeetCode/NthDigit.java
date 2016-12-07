package LeetCode;

public class NthDigit {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(findNthDigit(2147483647));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
    public static int findNthDigit(int n) {
    	

//    	int pos = 0;
//    	int len = 0;
//    	int loop = 0;
//    	for (int i = 1; i <= n; i++) {
//    		if (i < loop) {
//    			//do noting
//    		} else {
//    			len = getNumLen(i);
//    			loop = (int) Math.pow(10,len);
//    		}
//    		if (pos + len >= n) {
//    			return getNumFromPos(n - pos, i);
//    		} else {
//    			pos += len;
//    		}
//    	}
    	
//    	int len = 0;
//    	int underNum = 0;
//    	int counter = 0;
//    	int pos = 0;
//    	while(true){
//
//    		counter++;
//	    	if (counter < underNum) {
//				//do noting
//			} else {
//				len++;
//				underNum = (int) Math.pow(10,len);
//			}
//    		pos += len;
//    		if (pos >= n) {
//    			System.out.println(counter);
//    			return getNumFromPos(pos - n, counter);
//    		}
//    		
//    	}
    	
    	// For 1, 2 .., 9, return the result directly
        if(n <= 9){
            return n;
        }
        
        int len = 1;

        // Determine the range 
        // 10, 11, ..., 99:  90 * 2 digits in total, base = 2
        // 101, 102, 103, ..., 999:  900 * 3  digits in total, base = 3
        // ...
        while(n > 9 * Math.pow(10, len - 1) * len)
        {
            n = n - 9 * (int)Math.pow(10, len - 1) * len;
            len++;
        }
        
        // Now we should find out which number the answer follows. eg. if the input is 15, the answer should follow on number "12", that's the variable number for.
        int num = (int)Math.pow(10, len - 1) + (n - 1) / len;

        // Then we should find out which specific in the number "12". that's what index for, for input 15, index = 0
        int pos = (n - 1) % len;

        // The answer is the index-th digit of the variable number
        return Integer.toString(num).charAt(pos) - '0';
    	
    }
    
    public static int getNum(int n) {
    	return String.valueOf(n).length() ;
    }
    
    public static int getNumFromPos(int pos, int n) {
    	String num = String.valueOf(n);
    	return num.charAt(num.length() - pos - 1) - '0';
    }
	
    
}



