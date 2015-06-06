package joshua.leetcode.dp;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BuySellStock3Test {

	int[] prices1=new int[]{1,5,4,9,7,14};
	
	@Test
	public void testSolution1() {
		BuySellStock3 sol=new BuySellStock3.Solution1();
		assertEquals(15,sol.maxProfit(prices1));
	}

	@Test
	public void testSolution2(){
		BuySellStock3 sol=new BuySellStock3.Solution2();
		assertEquals(15,sol.maxProfit(prices1));
	}
}
