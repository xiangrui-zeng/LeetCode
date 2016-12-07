package LeetCode;

import java.util.*;
import java.util.Map.Entry;

public class test {
    public static void main(String[] args) {
        // 自分の得意な言語で
        // Let's チャレンジ！！
        Scanner sc = new Scanner(System.in);
        String line = sc.nextLine();
        String [] p = line.split(" ");
        int length = Integer.parseInt(p[0]);
        int xLength = Integer.parseInt(p[1]);
        int yLength = Integer.parseInt(p[2]);
        
        List<Map<Integer, Point>>  a = new ArrayList<Map<Integer, Point>>();
        for (int i = 0; i < xLength; i++){
        	//a.add(new HashMap<Integer, Point>());
        	a.add(new TreeMap<Integer, Point>(Collections.reverseOrder()));
        }
        
        for(int i = 0; i < yLength; i++) {
        	String s = sc.nextLine();
        	String [] p1 = s.split(" ");
            int x1 = Integer.parseInt(p1[0]) - 1;
            int y1 = Integer.parseInt(p1[1]) - 1;
            int y2 = Integer.parseInt(p1[2]) - 1;
            
            a.get(x1).put(y1, new Point(x1 + 1, y2));
            a.get(x1 + 1).put(y2, new Point(x1, y1));
        }
        
        
        Point start = new Point(0, length - 1);
        while(start.getY() != 0) {
        	Map<Integer, Point> map = a.get(start.x);
        	boolean flag = false;
        	for(Entry entry : map.entrySet()) {
        		if((Integer)entry.getKey() < start.getY()){
        			start = (Point)entry.getValue();
        			flag = true;
        			break;
        		}
        	}
        	if(!flag) {
        		break;
        	}
        	
        }
        
        System.out.println((int)start.getX() + 1);
    }
    
}

class Point {
	int x;
	int y;
	public Point(int x, int y){
		this.x = x;
		this.y = y;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
}



