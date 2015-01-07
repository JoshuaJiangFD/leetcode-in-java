package joshua.leetcode.array.binarysearch;

import static org.junit.Assert.*;

import org.junit.Test;

public class SearchInRotatedSortedArrayTest {

	private SearchInRotatedSortedArray sol=new SearchInRotatedSortedArray.Solution();
	
	@Test
	public void testSearch() {
		int[] A=new int[]{4,5,6,7,0,1,2};
		assertEquals(3,sol.search(A, 7));
		A=new int[]{1,3};
		assertEquals(-1,sol.search(A, 0));
		A=new int[]{3,1};
		assertEquals(1,sol.search(A, 1));
	}

}
