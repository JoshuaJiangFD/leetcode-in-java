package joshua.leetcode.divideconquer;

/**
 * 240. Search a 2D Matrix II<br/>
 * <a href = "https://leetcode.com/problems/search-a-2d-matrix-ii/">leetcode link</a>
 *
 * @author Joshua.Jiang on 2016/5/29.
 */
public abstract class Search2DMatrixII {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * <ul>
     * <li>Integers in each row are sorted in ascending from left to right.</li>
     * <li>Integers in each column are sorted in ascending from top to bottom.</li>
     * For example,
     * </ul>
     * Consider the following matrix:
     * <p/>
     * [<br/>
     * [1,   4,  7, 11, 15],<br/>
     * [2,   5,  8, 12, 19],<br/>
     * [3,   6,  9, 16, 22],<br/>
     * [10, 13, 14, 17, 24],<br/>
     * [18, 21, 23, 26, 30]<br/>
     * ]<br/>
     * Given target = 5, return true.
     * Given target = 20, return false.
     *
     * @param matrix
     * @param target
     * @return
     */
    public abstract boolean searchMatrix(int[][] matrix, int target);

    /**
     *  观察矩阵可以发现， 每个对角线上的元素matrix[i,i]都大于所有其他index小于i的元素，即该元素的左上角的矩阵。
     *  因此可以先对对角线上元素做二分查找。
     *
     */
    public static class Solution1 extends Search2DMatrixII {

        @Override
        public boolean searchMatrix(int[][] matrix, int target) {

        }
    }
}
