package joshua.algorithm.math;

import com.google.common.collect.Lists;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by joshu on 2016/5/25.
 */
public class FirstNPrimeTest {

    @Test
    public void testSolution1() {
        FirstNPrime solution = new FirstNPrime.Solution1();
        assertEquals(Lists.newArrayList(2L,3L,5L,7L,11L), solution.getFirstNPrime(5));
    }
}