package joshua.leetcode.array.binarysearch;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Search2DMatrixTest {

    private Search2DMatrix solution;

    @Before
    public void setUp() {
        solution = new Search2DMatrix.Solution1();
    }

    @Test
    public void testSolution() {
        int[][] matrix = new int[][]{
                {1, 3, 5, 7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        assertTrue(solution.searchMatrix(matrix, 7));
        assertTrue(solution.searchMatrix(matrix, 3));
        assertTrue(solution.searchMatrix(matrix, 30));
        assertTrue(solution.searchMatrix(matrix, 50));

        assertFalse(solution.searchMatrix(matrix, -1));
        assertFalse(solution.searchMatrix(matrix, 8));
        assertFalse(solution.searchMatrix(matrix, 70));
    }


}