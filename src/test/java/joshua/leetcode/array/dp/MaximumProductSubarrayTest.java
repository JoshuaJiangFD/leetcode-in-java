package joshua.leetcode.array.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class MaximumProductSubarrayTest {

	@Test
	public void testMaxProduct() {
		MaximumProductSubarray.Solution sol=new MaximumProductSubarray.Solution();
		assertEquals(0,sol.maxProduct(new int[]{-2,0,-1}));
		assertEquals(6,sol.maxProduct(new int[]{2,3,-2,4}));
		assertEquals(48,sol.maxProduct(new int[]{-2,3,-2,4}));
	}

}
