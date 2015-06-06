package joshua.leetcode.array.twopointers;

import org.junit.Before;
import org.junit.Test;

public class ContainerWithMostWaterTest {

	int[] heights;
	
	@Before
	public void setUp(){
		heights=new int[]{4,3,2,1,4};
	}
	
	
	@Test
	public void testSolution2() {
		ContainerWithMostWater sol=new ContainerWithMostWater.Solution2();
		int maxArea=sol.maxArea(heights);
		System.out.println(maxArea);
	}

}
