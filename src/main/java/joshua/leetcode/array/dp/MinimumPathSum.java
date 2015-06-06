package joshua.leetcode.array.dp;

/**
 * 64. Minimum Path Sum 
 * @see <a href="https://leetcode.com/problems/minimum-path-sum/">leetcode link</a>
 * @author joy
 *
 */
public abstract class MinimumPathSum {
	/**
	 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
	 * which minimizes the sum of all numbers along its path.
	 * Note: You can only move either down or right at any point in time.
	 * 
	 * @param grid
	 * @return
	 */
	public abstract int minPathSum(int[][] grid);
	
	static class Solution1 extends MinimumPathSum{

		@Override
		public int minPathSum(int[][] grid) {
			 if(grid==null||grid.length==0||grid[0]==null||grid[0].length==0)
				 return 0;
			 int width=grid[0].length;
			 int height=grid.length;
			 int[] miniSum=new int[width];
			 //initialize the path sum from left-top node to each element in the first line.
			 miniSum[0]=grid[0][0];
			 for(int i=1;i<width;i++){
				 miniSum[i]=miniSum[i-1]+grid[0][i];
			 }
			 for(int i=1;i<height;i++){
				 int[] curLineSum=new int[width];
				 for(int j=0;j<width;j++){
					 if(j==0){
						curLineSum[0]=miniSum[0]+grid[i][0];  
					 }else{
						 curLineSum[j]=Math.min(curLineSum[j-1], miniSum[j])+grid[i][j];
					 }
				 }
				 miniSum=curLineSum;
			 }
			return miniSum[width-1]; 
		}
		
	}
}
