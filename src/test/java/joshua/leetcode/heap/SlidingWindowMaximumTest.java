package joshua.leetcode.heap;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SlidingWindowMaximumTest {

    SlidingWindowMaximum solution;

    @Before
    public void setUp() {
        solution = new SlidingWindowMaximum.Solution1();
    }

    @Test
    public void test() {
        int[] nums = new int[]{1,3,-1,-3,5,3,6,7};
        assertArrayEquals(new int[]{3,3,5,5,6,7}, solution.maxSlidingWindow(nums, 3));
    }

}