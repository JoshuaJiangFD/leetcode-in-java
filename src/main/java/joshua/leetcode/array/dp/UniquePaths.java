package joshua.leetcode.array.dp;

public abstract class UniquePaths {

	/**
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

	   The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

       How many possible unique paths are there?

       Above is a 3 x 7 grid. How many possible unique paths are there?
      Note: m and n will be at most 100.
      
	 * @param m
	 * @param n
	 * @return
	 */
	public abstract int uniquePaths(int m, int n);

	/**
	 * for every grid (x,y) in the m x n grid.
	 * f(x,y) means number of  paths from the Top-Left grid to this grid.
	 * so f(x,y)=f(x-1,y)+f(x,y-1)[either walk from left or up grid]  
	 * so we calculate from top to bottom, left to right, row by row.
	 * for 3*t grid, the initial value is:
	 * [0,1,1,1,1,1,1] for first row
	 * then calculate the second row as:
	 * [1,2,3,4,5,6,7]
	 * ...
	 * the final (third) row is:
	 * [1,3,6,10,16,23] 
	 * 
	 * and 23 the final answer.
	 * @author joy
	 *
	 */
	static class Solution1 extends UniquePaths {

		@Override
		public int uniquePaths(int m, int n) {
			if (m == 0 && n == 0)
				return 0;
			if (m == 1 | n == 1)
				return 1;
			int[] result = new int[n];
			result[0] = 0;
			for (int i = 1; i < n; i++)
				result[i] = 1;
			// horizontal traverse
			for (int i = 1; i < m; i++) {
				int[] curResult = new int[n];
				curResult[0] = 1;
				for (int j = 1; j < n; j++) {
					curResult[j] = curResult[j - 1] + result[j];
				}
				result = curResult;
			}
			return result[n - 1];
		}

	}
}
