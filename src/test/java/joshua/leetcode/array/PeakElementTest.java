package joshua.leetcode.array;

import static org.junit.Assert.*;


import org.junit.Test;

public class PeakElementTest {

	@Test
	public void testSolution1() {
		PeakElement.Solution1 solution=new PeakElement.Solution1();
		assertEquals(solution.findPeakElement(new int[]{1,2}),1);
		assertEquals(solution.findPeakElement(new int[]{2,1}),0);
		assertEquals(solution.findPeakElement(new int[]{2,3,1}),1);
	}

}
