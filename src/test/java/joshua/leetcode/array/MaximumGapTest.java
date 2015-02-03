package joshua.leetcode.array;

import static org.junit.Assert.*;
import junit.framework.Assert;

import org.junit.Test;

public class MaximumGapTest {

	@Test
	public void testSolution1() {
		int[] num=new int[]{3,14,4,1,9,20};
		
		MaximumGap.Solution solution=new MaximumGap.Solution();
		int result=solution.maximumGap(num);
		assertEquals(6,result);
		
		num=new int[]{1,10000000};
		result=solution.maximumGap(num);
		assertEquals(9999999,result);
		
		num=new int[]{100,3,2,1};
		result=solution.maximumGap(num);
		assertEquals(97,result);
	}

}
