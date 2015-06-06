package joshua.leetcode.array;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SpiralMatrixTest {

	int[][] array;
	
	@Before
	public void setUp(){
		array=new int[][]{
				{1,2,3},
				{4,5,6},
				{7,8,9}
		};
	}
	
	@Test
	public void testSolution1() {
		SpiralMatrix sol=new SpiralMatrix.Solution1();
		List<Integer> result=sol.spiralOrder(array);
		System.out.println(result);
		array=new int[][]{{2,3}};
		result=sol.spiralOrder(array);
		System.out.println(result);
		array=new int[3][];
		Assert.assertTrue(sol.spiralOrder(array).isEmpty());
		array=new int[3][0];
		Assert.assertTrue(sol.spiralOrder(array).isEmpty());
		
	}

}
