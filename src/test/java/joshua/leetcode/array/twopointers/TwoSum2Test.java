package joshua.leetcode.array.twopointers;

import static org.junit.Assert.assertArrayEquals;

import org.junit.Before;
import org.junit.Test;

public class TwoSum2Test {

    TwoSum2 solution;

    @Before
    public void setUp() {
        //solution = new TwoSum2.Solution1();
        solution = new TwoSum2.Solution2();
    }

    @Test
    public void testSolution() {
        int[] numbers = new int[]{2, 7, 11, 15};
        assertArrayEquals(new int[]{1, 2}, solution.twoSum(numbers, 9));
    }

}