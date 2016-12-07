package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class CanWin {
	
	public static void main(String[] args) {
		System.out.println(canIWin(3, 6));
	}
	
    public static boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        
    	int totalStatus = 0;
    	int firstPos = 0;
    	for (int i = 1; i <= maxChoosableInteger; i++) {
    		totalStatus += i;
    		if (totalStatus >= desiredTotal && firstPos==0) {
    			firstPos = totalStatus;
    		}
    	}
    	
    	if (totalStatus < desiredTotal) {
    		return false;
    	}
    	
    	List<Integer> status = new ArrayList<>();
    	status.add(0);
    	for (int i = 1; i < totalStatus; i++) {
    		int tmp = 0;
    		for (int j = 1; j< status.size(); j++) {
    			tmp = tmp ^ status.get(j);
    		}
    		status.add(tmp);
    	}
    	
    	
    	return status.get(firstPos-1) == 0 ? false : true;
    }
    
}