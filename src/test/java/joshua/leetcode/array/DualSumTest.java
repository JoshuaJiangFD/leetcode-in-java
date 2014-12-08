package joshua.leetcode.array;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Before;
import org.junit.Test;

public class DualSumTest {

	private int[] array;
	
	private int target;
	
	@Before
	public void setUp() throws Exception {
		array=new int[]{5,6,1,3,7,10};
		target=9;
	}

	@Test
	public void testSolution1() {
		DualSum sol=new DualSum.Solution1();
		int[] idxs=sol.twoSum(array, target);
		System.out.println(Arrays.toString(idxs));
	}

}
