package joshua.leetcode.array;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

public class RotateArray189Test {

	int[] arr;
	
	@Test
	public void testSolution1() {
		RotateArray189 sol=new RotateArray189.Solution1();
		arr=new int[]{1,2,3,4,5,6,7};
		sol.rotate(arr, 2);
		assertArrayEquals(arr,new int[]{6,7,1,2,3,4,5});
		arr=new int[]{1,2,3,4,5,6,7};
		sol.rotate(arr, 3);
		assertArrayEquals(arr,new int[]{5,6,7,1,2,3,4});
	}
	
	@Test
	public void testSolution2(){
		RotateArray189 sol=new RotateArray189.Solution2();
		arr=new int[]{1,2,3,4,5,6,7};
		sol.rotate(arr, 2);
		assertArrayEquals(arr,new int[]{6,7,1,2,3,4,5});
		arr=new int[]{1,2,3,4,5,6,7};
		sol.rotate(arr, 3);
		assertArrayEquals(arr,new int[]{5,6,7,1,2,3,4});
	}

}
