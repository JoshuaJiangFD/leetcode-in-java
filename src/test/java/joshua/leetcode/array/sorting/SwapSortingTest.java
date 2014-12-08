package joshua.leetcode.array.sorting;

import org.junit.Before;
import org.junit.Test;

public class SwapSortingTest {

	Integer[] array;
	
	@Before
	public void setUp() throws Exception {
		array=new Integer[]{4,6,8,1,5};
	}

	@Test
	public void testQuickSorting() {
		SwapSorting algo=new SwapSorting.QuickSort();
		algo.quickSort(array);
		for(Integer i: array){
			System.out.println(i);
		}
	}

}
