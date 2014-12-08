package joshua.leetcode.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class ClimbingStairsTest {

	@Test
	public void test_Solution2() {
		ClimbingStairs solution = new ClimbingStairs.Solution2();
		assertEquals(solution.climbStairs(1), 1);
		assertEquals(solution.climbStairs(2), 2);
		assertEquals(solution.climbStairs(3), 3);

	}

}
