package joshua.leetcode.array.dp;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class MinimumPathSumTest {


	@Test
	public void test_Solution1() {
		MinimumPathSum sol=new MinimumPathSum.Solution1();
		int[][] grid=new int[][]{
				{1,2},
				{1,1}
		};
		assertEquals(3,sol.minPathSum(grid));
		
	}

}
