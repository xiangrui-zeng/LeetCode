package LeetCode;

public class UniquePaths {
	public static void main(String[] args) {
		long startTime = System.currentTimeMillis();
		System.out.println(uniquePaths2(36,7));
		long endTime = System.currentTimeMillis();
		long duration = (endTime - startTime);
		System.out.println(duration + "ms");
	}
	
	public static int uniquePaths(int m, int n) {
		if (m <= 2 || n <= 2) {
			if (m == 2 && n == 2) {
				return 2;
			} else {
				return 1;
			}
		}
		long mm = factorial(m+n-3);
		long nn = factorial(m-1);
		int result = (int) (mm/(nn*factorial(n-2)));
        return result;
    }
	
	public static long factorial(int n) {
		if (n == 1)
			return 1;
		return n*factorial(n-1);
	}
	
	public static int uniquePaths2(int m, int n) {
		int[][] result = new int[m][n];
		result[0][0] = 1;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) continue;
				int left = i - 1 >= 0 ? result[i - 1][j] : 0;
				int up = j - 1 >= 0 ? result[i][j -1] : 0;
				result[i][j] = left + up;
			}
		}
        return result[m-1][n-1];
    }
}
	   




