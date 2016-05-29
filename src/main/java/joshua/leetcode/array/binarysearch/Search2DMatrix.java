package joshua.leetcode.array.binarysearch;

import joshua.leetcode.solutiontag.*;
import joshua.leetcode.solutiontag.BinarySearch;

/**
 * 74. Search a 2D Matrix<br/>
 * <p/>
 * <a href ="https://leetcode.com/problems/search-a-2d-matrix/">leetcode link</a>
 *
 * @author Joshua.Jiang on 2016/5/29.
 */
public abstract class Search2DMatrix {

    /**
     * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
     * <p/>
     * Integers in each row are sorted from left to right.
     * The first integer of each row is greater than the last integer of the previous row.
     * <p/>
     * <p/>
     * For example,
     * Consider the following matrix:
     * <p/>
     * [
     * [1,   3,  5,  7],
     * [10, 11, 16, 20],
     * [23, 30, 34, 50]
     * ]
     * <p/>
     * Given target = 3, return true
     *
     * @param matrix
     * @param target
     * @return
     */
    public abstract boolean searchMatrix(int[][] matrix, int target);


    /**
     * 先根据最后一列确定在哪一行，再对该行做binary search
     */
    @BinarySearch
    public static class Solution1 extends Search2DMatrix {

        @Override
        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix[0] == null || matrix[0].length == 0) {
                return false;
            }
            int row = matrix.length;
            int col = matrix[0].length;
            // first binary search
            int beg = 0, end = row - 1;
            while (beg <= end) {
                int mid = (beg + end) / 2;
                if (matrix[mid][col - 1] > target) {
                    end = mid - 1;
                } else if (matrix[mid][col - 1] < target) {
                    beg = mid + 1;
                } else {
                    return true;
                }
            }
            //boundary case, for example if target is 70 in the above example.
            if (beg == row) {
                return false;
            }
            //now need to search row indexed by 'beg'
            int rowBeg = 0, rowEnd = col - 1;
            while (rowBeg <= rowEnd) {
                int rowMid = (rowBeg + rowEnd) / 2;
                if(matrix[beg][rowMid] == target) {
                    return true;
                }
                if (matrix[beg][rowMid] < target) {
                    rowBeg = rowMid + 1;
                } else {
                    rowEnd = rowMid - 1;
                }
            }
            return false;
        }
    }
}
