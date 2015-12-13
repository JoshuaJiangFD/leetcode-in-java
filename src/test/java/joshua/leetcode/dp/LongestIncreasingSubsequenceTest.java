package joshua.leetcode.dp;

import org.junit.Test;

import static org.junit.Assert.*;

public class LongestIncreasingSubsequenceTest {

    @Test
    public void testSolution1() {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence.Solution1();
        int[] array = new int[]{3, 5, 6, 2, 5, 4, 19, 5, 6, 7, 12};
        assertEquals(6, sol.lengthOfLIS(array));
    }

    @Test
    public void testSolution2() {
        LongestIncreasingSubsequence sol = new LongestIncreasingSubsequence.Solution2();
        int[] array=new int[]{3,5,6,2,5,4,19,5,6,7,12};
       assertEquals(6,sol.lengthOfLIS(array));

        //int[] array = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
       // assertEquals(4, sol.lengthOfLIS(array));

    }

}