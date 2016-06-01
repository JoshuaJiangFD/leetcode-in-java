package joshua.leetcode.array.twopointers;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MinimumWindowSubstringTest {

    MinimumWindowSubstring solution;

    @Before
    public void setUp() {
        solution = new MinimumWindowSubstring.Solution1();
    }

    @Test
    public void testSolution() {
        String S = "ADOBECODEBANC";
        String T = "ABC";
        assertEquals("BANC", solution.minWindow(S, T));
        assertEquals("BAC", solution.minWindow("AEFGBBAC", "BAC"));
        assertEquals("DBAC", solution.minWindow("AEFGBDBAC", "DBAC"));
        assertEquals("aa", solution.minWindow("aa", "aa"));
    }

}