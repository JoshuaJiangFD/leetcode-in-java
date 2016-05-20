package joshua.leetcode.math;

import static org.junit.Assert.*;

import org.junit.Test;

public class CountPrimeTest {

    @Test
    public void testSolution1() {
        CountPrime solution = new CountPrime.Solution();
        assertEquals(25, solution.countPrimes(100));
    }

}