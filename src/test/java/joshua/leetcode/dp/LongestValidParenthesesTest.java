package joshua.leetcode.dp;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class LongestValidParenthesesTest {

    HashMap<String, Integer> cases;

    @Before
    public void setUp() {
        cases = new HashMap<String, Integer>();
        cases.put("()(()(((",2);
        cases.put("(()())",6);
        cases.put(")()",2);
        cases.put(")()())",4);
       cases.put("()(()",2);

    }


    @Test
    public void testLongestValidParentheses() throws Exception {
        LongestValidParentheses sol=new LongestValidParentheses.Solution1();
        for (String key : cases.keySet()) {
            assertEquals((int)cases.get(key),sol.longestValidParentheses(key));
        }
    }
}