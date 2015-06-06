package joshua.leetcode.array.binarysearch;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SearchInRotatedSortedArrayTest {

	
	
	@Test
	public void test_Solution1() {
		int[] A=new int[]{4,5,6,7,0,1,2};
		SearchInRotatedSortedArray sol=new SearchInRotatedSortedArray.Solution1();
		assertEquals(3,sol.search(A, 7));
		A=new int[]{1,3};
		assertEquals(-1,sol.search(A, 0));
		A=new int[]{3,1};
		assertEquals(1,sol.search(A, 1));
	}
	
	@Test
	public void test_Solution2(){
		int[] A=new int[]{4,5,6,7,0,1,2};
		SearchInRotatedSortedArray sol=new SearchInRotatedSortedArray.Solution2();
		assertEquals(3,sol.search(A, 7));
		A=new int[]{1,3};
		assertEquals(-1,sol.search(A, 0));
		A=new int[]{3,1};
		assertEquals(1,sol.search(A, 1));
	}

}
