package joshua.leetcode.array.twopointers;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class TernarySumClosestTest {

    private TernarySumClosest solution;

    private Map<Param, Integer> cases = Maps.newHashMap();

    @Before
    public void setUp() {
        cases.put(new Param(new int[]{0,0,0},1), 0);
        cases.put(new Param(new int[]{-1,2,1,4},1), 2);
        cases.put(new Param(new int[]{-1,0,1,2,-1,-4},0), 0);
        cases.put(new Param(new int[]{-1,2,1,-4},1), 2);
        cases.put(new Param(new int[]{1,1,-1,-1,3},-1), -1);
        cases.put(new Param(new int[]{4,0,5,-5,3,3,0,-4,-5},-2), -2);
    }

    @Test
    public void testSolution1() {
        solution = new TernarySumClosest.Solution1();
        for(Param param : cases.keySet()) {
            assertEquals((int)cases.get(param), solution.threeSumClosest(param.nums,param.target));
        }
    }

    class Param {
        int[] nums;
        int target;

        public Param(int[] nums, int target) {
            this.nums = nums;
            this.target = target;
        }
    }

}