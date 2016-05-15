package joshua.leetcode.divideconquer;

import org.junit.Before;
import org.junit.Test;

import java.util.Collection;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by joshua on 1/3/16.
 */
public class CountOfSmallerNumbersAfterSelfTest {

    private int[] target;
    private int[] expected;

    @Before
    public void setUp() {

        target = new int[]{5,2,6,1};
        expected = new int[]{2,1,1,0};

//        target = new int[]{0, 2, 1};
//        expected = new int[]{0, 1, 0};

//        target = new int[]{5, 2, 6, 1};
//        expected = new int[]{2, 1, 1, 0};
    }

    @Test
    public void testSolution1() {
        CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf.Solution1();
        List<Integer> result = solution.countSmaller(target);
        int[] converted = new int[result.size()];
        for (int i = 0; i < converted.length; i++) {
            converted[i] = result.get(i);
        }
        assertArrayEquals(expected, converted);
    }

    @Test
    public void testSolution2() {
        CountOfSmallerNumbersAfterSelf solution = new CountOfSmallerNumbersAfterSelf.Solution2();
        List<Integer> result = solution.countSmaller(target);
        int[] converted = new int[result.size()];
        for (int i = 0; i < converted.length; i++) {
            converted[i] = result.get(i);
        }
        assertArrayEquals(expected, converted);
    }
}