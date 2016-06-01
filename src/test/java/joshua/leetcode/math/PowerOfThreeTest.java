package joshua.leetcode.math;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class PowerOfThreeTest {

    PowerOfThree solution;

    @Before
    public void setUp () {
        solution = new PowerOfThree.Solution1();
    }

    @Test
    public void testSolution() {
        assertTrue(solution.isPowerOfThree(9));
        assertTrue(solution.isPowerOfThree(27));
        assertFalse(solution.isPowerOfThree(28));
    }

}