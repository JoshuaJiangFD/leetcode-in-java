package joshua.leetcode.strings;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ReverseWordsIITest {

    private ReverseWordsII solution;

    @Before
    public void setUp() {
        solution = new ReverseWordsII.Solution1();
    }

    @Test
    public void testSolution() {
//        char[] chars = "blue is sky the".toCharArray();
//        solution.reverseWords(chars);
//        assertEquals("the sky is blue", new String(chars));

        char[] chars = "the sky is blue".toCharArray();
        solution.reverseWords(chars);
        assertEquals("blue is sky the", new String(chars));
    }

}