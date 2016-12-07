package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class MoveDice2 {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		long startTime = System.currentTimeMillis();
        char[] o = sc.nextLine().replace(" ", "").toCharArray();
        int [] wraper = new int [6];
        wraper[o[0] - '1'] = o[1] - '1';
        wraper[o[1] - '1'] = o[0] - '1';
        wraper[o[2] - '1'] = o[3] - '1';
        wraper[o[3] - '1'] = o[2] - '1';
        wraper[o[4] - '1'] = o[5] - '1';
        wraper[o[5] - '1'] = o[4] - '1';
        
        int step = Integer.parseInt(sc.nextLine());
        List<Integer> stepList = new ArrayList<>();
        for (int i = 0; i < step ; i++) {
        	String tmp = sc.nextLine();
        	stepList.add(Integer.parseInt(tmp) - 1);
        }
        
        int result = 0;
        for (int i = 0; i < stepList.size() - 1; i ++) {
        	int num1 = stepList.get(i);
        	int num2 = stepList.get(i + 1);
        	if (num1==num2)
        		continue;
        	if (wraper[num1] == num2) {
        		result += 2;
        	} else {
        		result++;
        	}
        }  
        
        System.out.println(result);
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	
    
}



