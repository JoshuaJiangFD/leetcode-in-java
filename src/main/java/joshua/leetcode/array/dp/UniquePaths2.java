package joshua.leetcode.array.dp;

/**
 * 63	Unique Paths II
 * @see <a href="https://leetcode.com/problems/unique-paths-ii/">leetcode link</a>
 * 
 * @author joy
 *
 */
public abstract class UniquePaths2 {

	/**
	 * Follow up for "Unique Paths":
	   Now consider if some obstacles are added to the grids. How many unique paths would there be?
	   An obstacle and empty space is marked as 1 and 0 respectively in the grid.	
	   For example,
	   There is one obstacle in the middle of a 3x3 grid as illustrated below.
		[
		  [0,0,0],
		  [0,1,0],
		  [0,0,0]
		]
		The total number of unique paths is 2.
		
	 * @param obstacleGrid
	 * @return
	 */
	public abstract int uniquePathsWithObstacles(int[][] obstacleGrid);

	/**
	 * similar to {@link joshua.leetcode.array.dp.UniquePaths.Solution1}
	 * @author joy
	 *
	 */
	static class Solution1 extends UniquePaths2 {

		@Override
		public int uniquePathsWithObstacles(int[][] obstacleGrid) {
			if (obstacleGrid == null || obstacleGrid.length == 0
					|| obstacleGrid[0] == null || obstacleGrid[0].length == 0)
				return 0;	
			
			int m = obstacleGrid.length;
			int n = obstacleGrid[0].length;
			if(m==1 && n==1)
				return obstacleGrid[0][0]!=1?1:0;
			if(obstacleGrid[0][0]==1)
				return 0;
			int[] pathNum = new int[n];
			pathNum[0] = 0;
			for (int i = 1; i < n; i++) {
				if (obstacleGrid[0][i] == 1)
					pathNum[i] = 0;
				else/*you can get from [0][0] to [0][i] only when  you can get [0][i-1] and obstacleGrid[0][i]!=1*/
					pathNum[i] = (i == 1) ? 1 : pathNum[i - 1];
			}
			// horizontal traverse
			for (int i = 1; i < m; i++) {
				int[] curResult = new int[n];
				/*you can get from [i-1][0] to [i][0] only when you can get to [i-1][0] and obstacleGrid[i][0]!=1*/
				curResult[0] = obstacleGrid[i][0] != 1 ? ((i == 1) ? 1
						: pathNum[0]) : 0;
				for (int j = 1; j < n; j++) {
					if (obstacleGrid[i][j] == 1)
						curResult[j] = 0;
					else
						curResult[j] = curResult[j - 1] + pathNum[j];/*from left plus from up*/
				}
				pathNum = curResult;
			}
			return pathNum[n - 1];
		}

	}

}
