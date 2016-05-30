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
     *  观察矩阵可以发现， 斜对角线上的每个元素matrix[i,j]都是对应的列的最小元素，是对应的行的最大元素。
     *  因此可以比较斜对角线上的最右上角元素ele和target的大小关系：
     *  如果ele > target, 可以过滤掉ele对应的行
     *  如果ele < target, 可以过滤掉ele对应的列
     *  如果相等可以直接返回。
     *
     *  这样每次比较都可以过滤掉一行，或者一列，总的时间复杂度就是o(m+n)
     *
     */
    public static class Solution1 extends Search2DMatrixII {

        @Override
        public boolean searchMatrix(int[][] matrix, int target) {
            if(matrix == null || matrix[0] == null || matrix[0].length == 0) {
                return false;
            }
            int row = matrix.length, col = matrix[0].length;
            int i = 0, j = col - 1;
            while(i < row && j > -1) {
                int ele = matrix[i][j];
                if (ele < target) {
                    i++;
                } else if (ele > target) {
                    j--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
}
