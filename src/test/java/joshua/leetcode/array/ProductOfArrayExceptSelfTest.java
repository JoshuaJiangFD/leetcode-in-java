package joshua.leetcode.array;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshu on 2016/5/27.
 */
public class ProductOfArrayExceptSelfTest {

    ProductOfArrayExceptSelf solution;

    @Before
    public void setUp() {
        solution = new ProductOfArrayExceptSelf.Solution1();
    }

    @Test
    public void testSolution() {
        int[] input = new int[]{1,2,3,4};
        int[] output = solution.productExceptSelf(input);
        assertArrayEquals(new int[]{24,12,8,6}, output);
    }

}