package joshua.leetcode.divideconquer;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class KthLargestElementInArrayTest {

	@Test
	public void testSolution1() {
		KthLargestElementInArray sol=new KthLargestElementInArray.Solution1();
		int[] array=new int[]{3,2,1,5,6,4};
		assertEquals(5,sol.findKthLargest(array, 2));
		assertEquals(4,sol.findKthLargest(array, 3));
		assertEquals(6,sol.findKthLargest(array, 1));
	}
	
	@Test
	public void testSolution2(){
		KthLargestElementInArray sol=new KthLargestElementInArray.Solution2();
		int[] array=new int[]{3,2,1,5,6,4};
		assertEquals(4,sol.findKthLargest(array, 3));
		assertEquals(6,sol.findKthLargest(array, 1));
	}

}
