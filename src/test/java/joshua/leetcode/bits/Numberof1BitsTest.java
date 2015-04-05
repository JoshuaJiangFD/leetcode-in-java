package joshua.leetcode.bits;

import junit.framework.Assert;

import org.junit.Test;

public class Numberof1BitsTest {

	@Test
	public void testHammingWeight() {
		int i=5;
		Numberof1Bits sol=new Numberof1Bits();
		Assert.assertEquals(2, sol.hammingWeight(i));
		int j=-7;//1111 1111,1111 1111,1111 1111,1111 1001
		Assert.assertEquals(30, sol.hammingWeight(j));
		System.out.println(Math.floor(7.0/2));
		System.out.println(Integer.toBinaryString(-7));
		System.out.println(Integer.parseInt("111", 2));
		
	}

}
