package LeetCode;

public class IslandPerimeter {
    public int islandPerimeter(int[][] grid) {
    	int length = 0;
        for(int i = 0; i < grid.length; i++) {
        	int now = 0;
        	for(int j = 0; j < grid[i].length; j++) {
        		if(grid[i][j] != now) {
        			length++;
        			now = grid[i][j];
        		}
        	}
        	if(now == 1) {
        		length++;
        	}
        }
        for(int j = 0; j < grid[0].length; j++) {
        	int now = 0;
        	for(int i = 0; i < grid.length; i++) {
        		if(grid[i][j] != now) {
        			length++;
        			now = grid[i][j];
        		}
        	}
        	if(now == 1) {
        		length++;
        	}
        }
        
        return length;
    }
}