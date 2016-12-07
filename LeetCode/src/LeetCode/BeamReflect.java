package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class BeamReflect {
	public static void main(String[] args) {
//		long startTime = System.currentTimeMillis();
		//init data
		Scanner sc = new Scanner(System.in);
        String[] xy = sc.nextLine().split(" ");
        int x = Integer.parseInt(xy[1]);
        int y = Integer.parseInt(xy[0]);
        List<char []> o = new ArrayList<>();
        for (int i = 0; i < y ; i ++) {
        	String line = sc.nextLine();
        	o.add(line.toCharArray());
        }
        int result = calculateBeamStep(o, x, y);
        System.out.println(result);
//		long endTime = System.currentTimeMillis();
//		long duration = (endTime - startTime);
//		System.out.println(duration);
	}
	
	public static int calculateBeamStep(List<char []> path, int xWidth, int yWidth){
		int moveType = 1;
		int x = 0;
		int y = 0;
		int step = 0;
		// 1 : right
		// 2 : left
		// 3 : up
		// 4 : down
		while( x >= 0 && y >= 0 && x < xWidth && y < yWidth){
		    if(path.get(y)[x] == '\\'){
		        if(moveType == 1){
		        	moveType = 4;
		        } else if(moveType == 2){
		        	moveType = 3;
		        } else if(moveType == 3){
		        	moveType = 2;
		        } else if(moveType == 4){
		        	moveType = 1;
		        }
		    } else if(path.get(y)[x] == '/'){
		        if(moveType == 1){
		        	moveType = 3;
		        } else if(moveType == 2){
		        	moveType = 4;
		        } else if(moveType == 3){
		        	moveType = 1;
		        } else if(moveType == 4){
		        	moveType = 2;
		        }
		    }
		    if(moveType == 1){
		        x++;
		    } else if(moveType == 2){
		        x--;
		    } else if(moveType == 3){
		        y--;
		    } else if(moveType == 4){
		        y++;
		    }
		    step++;
		}
		return step;
	}
	
	
}



