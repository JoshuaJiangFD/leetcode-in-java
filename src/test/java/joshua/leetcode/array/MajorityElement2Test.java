package joshua.leetcode.array;

import joshua.leetcode.testutils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class MajorityElement2Test {

    int[] arr;

    @Before
    public void setUp() throws Exception {
        arr=new int[]{2,2,1,2,2,1,1,1,0};
    }

    @Test
    public void testSolution1(){
        MajorityElement2 sol=new MajorityElement2.Solution1();
        List<Integer> ans=sol.majorityElement(arr);
        assertEquals(2,ans.size());
        assertTrue(ans.contains(1));
        assertTrue(ans.contains(2));

    }
}