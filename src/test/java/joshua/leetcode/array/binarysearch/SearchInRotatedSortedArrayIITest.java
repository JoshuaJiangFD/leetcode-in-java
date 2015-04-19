package joshua.leetcode.array.binarysearch;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SearchInRotatedSortedArrayIITest {


	@Test
	public void test() {
		 int[] rotatedArray=new int[]{4,5,6,3,3,3,3};
		 SearchInRotatedSortedArrayII sol=new  SearchInRotatedSortedArrayII.Solution1();
		 assertEquals(true,sol.search(rotatedArray, 6));
	}

}
