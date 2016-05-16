package joshua.leetcode.backtracking;


import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class GrayCodeTest {

    Map<Integer, List<Integer>> result = Maps.newHashMap();

    @Before
    public void setUp () {
        result.put(2, Lists.newArrayList(0, 1,2,3));
    }

    @Test
    public void testSolution1 () {
        GrayCode solution1 = new GrayCode.Solution1();
        for(int key : result.keySet()) {
            List<Integer> result = solution1.grayCode(key);
            System.out.println(result);
        }
    }
}