package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class DescOrder {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        List<String> input = new ArrayList<>();
        int totalLength = 0;
        for (int i = 0; i < Integer.parseInt(line); i ++) {
        	String str = sc.nextLine();
        	if (str.length() < 50) {
        		for (int j = 0; j < 50 - str.length(); j ++) {
        			str += "|";
        		}
        	}
        	input.add(str);
        	totalLength += str.length();
        }
        Collections.sort(input);
//        Collections.reverse(input);
        String result = "";
        for (int i = 0; i < totalLength; i ++) {
        	String lastChar = getLastestChar(input);
        	if (lastChar != null) {
        		result += lastChar;
        	} else {
        		break;
        	}
        }
        
//        String reverseResult = new StringBuilder(result).reverse().toString();
        System.out.println(result);
    }
    
    public static String getLastestChar(List<String> input) {
    	String result = null;
    	int deleteIndex = -1;
    	char str = 'z';
    	int onlyOneChar = 0;
    	for (int i = 0; i < input.size(); i ++) {
    		if (!input.get(i).isEmpty()) {
    			String tmp = input.get(i);
    			if (tmp.substring(0,1).toCharArray()[0] == '|') {
    				continue;
    			}
    			if (tmp.substring(0,1).toCharArray()[0] < str || deleteIndex == -1) {
    				str = tmp.substring(0,1).toCharArray()[0];
    				deleteIndex = i;
    			}
    			result = String.valueOf(str);
    		} else {
    			continue;
    		}
    	}
    	if (result != null) {
    		String newStr = input.get(deleteIndex).substring(1,input.get(deleteIndex).length()) + "|";
    		input.set(deleteIndex, newStr);
    		Collections.sort(input);
    	}
    	return result;
    }
    
}



