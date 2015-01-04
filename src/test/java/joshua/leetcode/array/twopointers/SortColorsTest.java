package joshua.leetcode.array.twopointers;

import static org.junit.Assert.*;
import joshua.leetcode.array.twopointers.SortColors;

import org.junit.Assert;
import org.junit.Test;

public class SortColorsTest {

	@Test
	public void testSolution1() {
		SortColors.Solution1 solution=new SortColors.Solution1();
		int[] colors=new int[]{1,1,1};
		solution.sortColors(colors);
		assertArrayEquals(colors, colors);
		
		colors=new int[]{0,0,0};
		solution.sortColors(colors);
		assertArrayEquals(colors, colors);
		
		colors=new int[]{2,2,2};
		solution.sortColors(colors);
		assertArrayEquals(colors, colors);
		
		colors=new int[]{2,1,0};
		solution.sortColors(colors);
		assertArrayEquals(new int[]{0,1,2}, colors);
		
		
		colors=new int[]{2,1,0,2,1};
		solution.sortColors(colors);
		assertArrayEquals(new int[]{0,1,1,2,2}, colors);
	}

}
