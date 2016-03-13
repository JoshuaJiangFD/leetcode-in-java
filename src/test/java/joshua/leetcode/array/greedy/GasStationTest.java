package joshua.leetcode.array.greedy;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class GasStationTest {

    private int[] gas;

    private int[] cost;

    @Before
    public void setUp () {
        gas = new int[]{2,4};
        cost = new int[]{3,4};
    }

    @Test
    public void testSolution1 () {
        GasStation solution1 = new GasStation.Solution1();
        int index =solution1.canCompleteCircuit(gas, cost);
        assertEquals(2, index);
    }

}