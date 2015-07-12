package joshua.leetcode.array.twopointers;

import static org.junit.Assert.*;

import org.junit.Test;

public class TrappingRainWaterTest {

	@Test
	public void testSolution1() {
		TrappingRainWater sol=new TrappingRainWater.Solution1();
//		int[] height=new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
		int[] height=new int[]{9,6,8,8,5,6,3};
		assertEquals(6,sol.trap(height));
//		int[] height=new int[]{4,2,3};
//		assertEquals(1,sol.trap(height));
		
	}

}
