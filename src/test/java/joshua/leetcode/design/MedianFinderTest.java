package joshua.leetcode.design;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;

public class MedianFinderTest {

    private static final double DELTA = 1e-15;
    private List<Param> cases = Lists.newArrayList();

    @Before
    public void setUp() {
        cases.add(new Param(6, 6));
        cases.add(new Param(10, 8));
        cases.add(new Param(2, 6));
        cases.add(new Param(6, 6));
        cases.add(new Param(5, 6));
        cases.add(new Param(0, 5.5));
    }

    @Test
    public void testSolution1() {
        MedianFinder medianFinder = new MedianFinder.Solution1();
        for (Param param : cases) {
            medianFinder.addNum(param.add);
            assertEquals(param.median, medianFinder.findMedian(), DELTA);
        }
    }

    class Param {
        int add;
        double median;

        public Param(int add, double median) {
            this.add = add;
            this.median = median;
        }
    }

}