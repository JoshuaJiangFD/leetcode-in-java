package joshua.leetcode.array.binarysearch;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;

public class FindTheDuplicateNumberTest {

    private Map<int[],Integer> cases = Maps.newHashMap();

    @Before
    public void setUp() {
        int[] nums  = new int[]{2, 2, 1, 3,2};
        cases.put(nums, 2);
        nums  = new int[]{1, 1, 1, 3,2};
        cases.put(nums, 1);
    }

    @Test
    public void testSolution1() {
        FindTheDuplicateNumber solution = new FindTheDuplicateNumber.Solution1();
        for(int[] nums : cases.keySet()) {
            assertEquals((int)cases.get(nums), solution.findDuplicate(nums));
        }
    }
}