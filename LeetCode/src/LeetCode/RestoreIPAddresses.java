package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class RestoreIPAddresses {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[] nums = {0,0};
		System.out.println(restoreIpAddresses("101023"));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration);
	}
	public static List<String> restoreIpAddresses(String s) {
        
		List<String> result = new ArrayList<>();
		if (s.length() > 12 || s.length() < 4) return result;
		for (int i = 0; i < 3; i++) {
			String firstStr = s.substring(0, i + 1);
			if (firstStr.length() > 1 && firstStr.startsWith("0")) break;
			int first = Integer.valueOf(firstStr);
			if (first > 255) break;
			for (int j = i + 1; j < 4 + i && j < s.length(); j ++) {
				String secondStr = s.substring(i + 1, j + 1);
				if (secondStr.length() > 1 && secondStr.startsWith("0")) break;
				int second = Integer.valueOf(secondStr);
				if (second > 255) break;
				for (int m = j + 1; m < 5 + j && m < s.length(); m ++) {
					String thirdStr = s.substring(j + 1, m + 1);
					if (thirdStr.length() > 1 && thirdStr.startsWith("0")) break;
					int third = Integer.valueOf(thirdStr);
					if (third > 255 || m + 1 >= s.length()) break;
					String fourthStr = s.substring(m + 1, s.length());
					if (fourthStr.length() > 1 && fourthStr.startsWith("0")) continue;
					int fourth = Integer.valueOf(fourthStr);
					if (fourth > 255) 
						continue;
					else {
						String r = first + "." + second + "." + third + "." + fourth;
						if(result.indexOf(r) == -1){
							result.add(r);
						}
					}
				}
			}
		}
		
		return result;
    }
	
}



