package joshua.leetcode.array.greedy;

import org.junit.Test;

import static org.junit.Assert.*;

public class RemoveDuplicateLettersTest {

    @Test
    public void testSolution1() {
        RemoveDuplicateLetters sol = new RemoveDuplicateLetters.Solution1();
        String test1 = "cbacdcfc";
        assertEquals("bacdf", sol.removeDuplicateLetters(test1));
        String test2 = "bbacac";
        assertEquals("bac", sol.removeDuplicateLetters(test2));
    }
}