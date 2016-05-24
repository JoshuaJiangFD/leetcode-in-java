package joshua.leetcode.heap;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by joshu on 2016/5/24.
 */
public class TopKFrequentElementsTest {

    TopKFrequentElements solution;

    @Before
    public void setUp() {
        solution = new TopKFrequentElements.Solution2();
    }

    @Test
    public void testSolution() {
        List<Integer> result = solution.topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2);
        assertEquals(result, Lists.newArrayList(1, 2));
    }
}