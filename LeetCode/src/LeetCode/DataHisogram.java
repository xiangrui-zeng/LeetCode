package LeetCode;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.CharBuffer;
import java.util.*;

public class DataHisogram {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(System.in);
        //String line = sc.nextLine();
        Deque<Long> stack = new ArrayDeque<Long>();
        long [] result = new long[26];
        long scale = 1;
        stack.push((long) 1);
        char [] line = new char[32768];
        CharBuffer cb = CharBuffer.allocate(32768);
        long tmpNum = 0;
        char before = '-';
        int length = -1;
        boolean stopFlag = false;
        while(!stopFlag){
        	try {
				length = br.read(cb);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        	if(length == -1) {
        		try {
					br.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        		break;
        	}
        	line = cb.array();
        	
        	for(int i = 0; i < length; i++) {
            	char c = line[i];
            	if(c == '\n') {
            		stopFlag = true;
            		break;
            	}
            	if (isInt(c)) {
            		tmpNum *= 10;
            		tmpNum += new Long(line[i] - '0');
            	} else {
            		if(tmpNum != 0) {
            			stack.push(tmpNum);
            			tmpNum = 0;
            		}
            		
            		if (isLeftBracket(c)) {
                		scale *= stack.peek();
                	} else if (isRightBracket(c)) {
                		scale /= stack.pop();
                	} else {
                		if (isInt(before)) {
                			result[charPos(c)] += scale * stack.pop();
                			before = c;
                			continue;
                		}
                		result[charPos(c)] += scale;
                	}
            	}
            	before = c;
            }
        }
        
        for (int i = 0; i < 26; i++) {
    		System.out.println(posChar(i) + " " + result[i]);
        }
        
    }
    
    public static boolean isInt(char c) {
    	if (c >= '0' && c <= '9') {
    		return true;
    	}
    	return false;
    }
    
    public static int charPos(char c) {
    	return c - 'a';
    }
    
    public static char posChar(int i) {
    	return (char) ('a' + i);
    }
    
    public static boolean isLeftBracket(char c) {
    	return c == '(' ? true : false;
    }
    
    public static boolean isRightBracket(char c) {
    	return c == ')' ? true : false;
    }
    
    public static long getFullNumPos(String a, int index){
    	int resultPos = index;
    	for (int i = index; i < a.length(); i++) {
    		if (isInt(a.charAt(i))) {
    			resultPos = i;
    		} else {
    			break;
    		}
    	}
    	return resultPos;
    }
    
}

