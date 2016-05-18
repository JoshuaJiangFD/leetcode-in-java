package joshua.leetcode.hashtable;

import static org.junit.Assert.*;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;

public class ValidAnagramTest {

    private Map<String, String> postiveCases = Maps.newHashMap();
    private Map<String, String> negativeCases = Maps.newHashMap();

    @Before
    public void setUp() {
        postiveCases.put("nagaram", "anagram");
    }

    @Test
    public void testSolution1() {
        ValidAnagram solution = new ValidAnagram.Solution1();
        for(String key : postiveCases.keySet()) {
            assertTrue(solution.isAnagram(key, postiveCases.get(key)));
        }
    }
}