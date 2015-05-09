package joshua.leetcode.array;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class FirstMissingPositiveTest {

    HashMap<int[], Integer> testCases;

    @Before
    public void setUp() throws Exception {
        testCases = new HashMap<int[], Integer>();
        testCases.put(new int[]{3,4,3,9},1 );
    }

    @Test
    public void testSolution1(){
        FirstMissingPositive sol=new FirstMissingPositive.Solution1();
        for(int[] key:testCases.keySet()) {
            int res=sol.firstMissingPositive(key);
            assertEquals((int)testCases.get(key),res);
        }
    }
}