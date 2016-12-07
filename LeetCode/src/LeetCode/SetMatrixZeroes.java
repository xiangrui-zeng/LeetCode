package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SetMatrixZeroes {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		int[][] arr = {{1,0}};
//		int[][] arr = {{1,2,3},{1,0,3},{1,2,3}};
		setZeroes(arr);
		System.out.println(arr.toString());
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	
	public static void setZeroes(int[][] matrix) {
		List<Integer> n = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
        	boolean flag = false;
        	for (int j = 0; j < matrix[i].length; j++) {
        		if (matrix[i][j] == 0) {
        			n.add(j);
        			flag = true;
        		}
        	}
        	if (flag) {
        		Arrays.fill(matrix[i], 0);
        	}
        }
        for (int idx : n) {
        	for (int i = 0; i < matrix.length; i++) {
            	matrix[i][idx] = 0;
            }
    	}
    }
}
	   




