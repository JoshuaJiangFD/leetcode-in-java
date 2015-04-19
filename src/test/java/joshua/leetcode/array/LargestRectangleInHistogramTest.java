package joshua.leetcode.array;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class LargestRectangleInHistogramTest {

	int[] heights;
	
	@Before
	public void setUp() throws Exception {
		heights=new int[]{2,1,5,6,2,3};
	}

	@Test
	public void testSolution1() {
		LargestRectangleInHistogram sol=new LargestRectangleInHistogram.Solution1();
		assertEquals(10,sol.largestRectangleArea(heights));
		//another one
		heights=new int[]{6, 2, 5, 4, 5, 1, 6};
		assertEquals(12,sol.largestRectangleArea(heights));
	}
	
	@Test
	public void testSolution2(){
		LargestRectangleInHistogram sol=new LargestRectangleInHistogram.Solution2();
		//assertEquals(10,sol.largestRectangleArea(heights));
		//another one
		heights=new int[]{6, 2, 5, 4, 5, 1, 6};
		assertEquals(12,sol.largestRectangleArea(heights));
	}

}
