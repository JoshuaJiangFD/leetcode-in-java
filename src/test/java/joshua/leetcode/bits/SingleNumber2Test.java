package joshua.leetcode.bits;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SingleNumber2Test {

    int[] nums;

    @Before
    public void setUP() {
        nums = new int []{2,2,2,1,1,3,3,3};
    }

    @Test
    public void testSolution1() {
        SingleNumber2 solution = new SingleNumber2.Solution1();
        int result = solution.singleNumber(nums);
        assertEquals(1, result);
    }
}