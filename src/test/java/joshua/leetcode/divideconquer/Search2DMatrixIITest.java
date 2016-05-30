package joshua.leetcode.divideconquer;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class Search2DMatrixIITest {

    Search2DMatrixII solution;

    @Before
    public void setUp() {
        solution = new Search2DMatrixII.Solution1();
    }

    @Test
    public void testSolution() {
        int[][] matrix = new int[][]{
                {2, 5, 8, 12, 19},
                {3, 6, 9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        assertTrue(solution.searchMatrix(matrix, 2));
        assertTrue(solution.searchMatrix(matrix, 30));
        assertFalse(solution.searchMatrix(matrix, 31));
    }

}