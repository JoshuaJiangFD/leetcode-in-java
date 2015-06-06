package joshua.leetcode.dp;

import static org.junit.Assert.*;

import org.junit.Test;

public class BuySellStock4Test {

	int[] prices;
	
	
	
	@Test
	public void testSolution1() {
		BuySellStock4 sol=new BuySellStock4.Solution1();
		prices=new int[]{1,2};
		assertEquals(1,sol.maxProfit(3, prices));
	}
	
	@Test
	public void testSolution2() {
		BuySellStock4 sol=new BuySellStock4.Solution2();
		prices=new int[]{1,2,4};
		assertEquals(3,sol.maxProfit(2, prices));
	}

}
