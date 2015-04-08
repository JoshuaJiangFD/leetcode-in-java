package joshua.leetcode.array.dp;

public abstract class UniquePaths2 {

	public abstract int uniquePathsWithObstacles(int[][] obstacleGrid);

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
				else
					pathNum[i] = (i == 1) ? 1 : pathNum[i - 1];
			}
			// horizontal traverse
			for (int i = 1; i < m; i++) {
				int[] curResult = new int[n];
				curResult[0] = obstacleGrid[i][0] != 1 ? ((i == 1) ? 1
						: pathNum[0]) : 0;
				for (int j = 1; j < n; j++) {
					if (obstacleGrid[i][j] == 1)
						curResult[j] = 0;
					else
						curResult[j] = curResult[j - 1] + pathNum[j];
				}
				pathNum = curResult;
			}
			return pathNum[n - 1];
		}

	}

}
