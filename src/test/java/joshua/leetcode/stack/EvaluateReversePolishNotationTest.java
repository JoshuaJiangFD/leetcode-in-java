package joshua.leetcode.stack;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class EvaluateReversePolishNotationTest {

    EvaluateReversePolishNotation solution;

    @Before
    public void setUp() {
        solution = new EvaluateReversePolishNotation.Solution1();
    }

    @Test
    public void testSolution() {
        //["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
        String[] tokens = new String[]{"2", "1", "+", "3", "*"};
        assertEquals(9, solution.evalRPN(tokens));
        //["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
        String[] tokens2 = new String[]{"4", "13", "5", "/", "+"};
        assertEquals(6, solution.evalRPN(tokens2));
    }
}