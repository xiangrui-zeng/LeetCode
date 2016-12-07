package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class MoveDice {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		Scanner sc = new Scanner(System.in);
        String[] o = sc.nextLine().split(" ");
        List<String> wraper = new ArrayList<>();
        wraper.add(o[0] + "," + o[1]);
        wraper.add(o[2] + "," + o[3]);
        wraper.add(o[4] + "," + o[5]);
        wraper.add(o[1] + "," + o[0]);
        wraper.add(o[3] + "," + o[2]);
        wraper.add(o[5] + "," + o[4]);
        
        int step = Integer.parseInt(sc.nextLine());
        List<String> stepList = new ArrayList<>();
        for (int i = 0; i < step ; i++) {
        	String tmp = sc.nextLine();
        	stepList.add(tmp);
        }
        
        int result = 0;
        for (int i = 0; i < stepList.size() - 1; i ++) {
        	String str1 = stepList.get(i);
        	String str2 = stepList.get(i + 1);
        	if (str1.equals(str2))
        		continue;
        	if (wraper.contains(str1 + "," + str2)) {
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



