package joshua.leetcode.array.dp;

import junit.framework.Assert;

import org.junit.Test;

public class HouseRobberTest {

	int[] houses;
	
	@Test
	public void testRob() {
		HouseRobber sol=new HouseRobber.Solution1();
		houses=new int[]{31,30,1,6,1};
		Assert.assertEquals(37, sol.rob(houses));
		houses=new int[]{1,2};
		Assert.assertEquals(2, sol.rob(houses));
	}

}
