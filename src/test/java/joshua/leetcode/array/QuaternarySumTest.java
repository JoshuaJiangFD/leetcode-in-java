package joshua.leetcode.array;

import java.util.List;

import org.junit.Test;

public class QuaternarySumTest {

	private int[] nums=new int[]{1,0,-1,0,-2,2};
	
	
	@Test
	public void testSolution1() {
		QuaternarySum.Solution1 solution=new QuaternarySum.Solution1();
		List<List<Integer>> result=solution.fourSum(nums,0);
		System.out.println(result);
		nums=new int[]{-3,-1,0,2,4,5};
		System.out.println(solution.fourSum(nums,0));
	}

}
