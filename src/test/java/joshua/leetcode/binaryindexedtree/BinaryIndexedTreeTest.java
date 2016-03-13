package joshua.leetcode.binaryindexedtree;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by joshua on 1/3/16.
 */
public class BinaryIndexedTreeTest {

    private BinaryIndexedTree bit;

    private int[] original;

    private int[] cumulativeValues;

    private int[] expectedTree;

    @Before
    public void setUp() throws Exception {
        original = new int[]{1, 0, 2, 1, 1, 3, 0, 4, 2, 5, 2, 2, 3, 1, 0, 2};
        cumulativeValues = new int[]{1, 1, 3, 4, 5, 8, 8, 12, 14, 19, 21, 23, 26, 27, 27, 29};
        expectedTree = new int[]{0, 1, 1, 2, 4, 1, 4, 0, 12, 2, 7, 2, 11, 3, 4, 0, 29};
        bit = new BinaryIndexedTree(original);
    }

    @Test
    public void TestBIT() {
        int[] tree = bit.getTree();
        assertArrayEquals(expectedTree, tree);
    }

    @Test
    public void testGetCumulativeValue() throws Exception {
        for (int i = 0; i < original.length; i++) {
            assertEquals(cumulativeValues[i], bit.getCumulativeValue(i));
        }
    }

    @Test
    public void testGetValueInOringalArray() throws Exception {
        for (int i = 0; i < original.length; i++) {
            assertEquals(original[i], bit.getValueInOringalArray(i));
        }
    }

    @Test
    public void testFindGreatestIndexWithGivenCumulativeValue() throws Exception {
        Map<Integer, Integer> valueWithGreatestIndex = Maps.newHashMap();
        for (int i = 0; i < cumulativeValues.length; i++) {
            valueWithGreatestIndex.put(cumulativeValues[i], i);
        }
        for (int i : valueWithGreatestIndex.keySet()) {
            System.out.printf("testing %d\n",i);
            assertEquals((int)valueWithGreatestIndex.get(i), bit.FindGreatestIndexWithGivenCumulativeValue(i));
        }
    }

    @Test
    public void testGetHighestBit() throws Exception {
        assertEquals(16,BinaryIndexedTree.getHighestBit(17));

    }
}