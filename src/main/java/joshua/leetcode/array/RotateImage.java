

package joshua.leetcode.array;

/**
 * 48. Rotate Image<br>
 * <a href="https://leetcode.com/problems/rotate-image/">leetcode link</a>
 *
 * @author Jiang Yong 
 */
public abstract class RotateImage {

    /**
     * You are given an n x n 2D matrix representing an image.
     * <p/>
     * Rotate the image by 90 degrees (clockwise).
     * <p/>
     * Follow up:
     * <b>Could you do this in-place?</b>
     *
     * @param matrix
     */
    public abstract void rotate(int[][] matrix);

    /**
     * 可以从外到内，分层旋转。关键是厘清所有的下标转换。以大小为4*4的矩阵为例。
     * (0,0),(0,1),(0,2),(0,3)
     * (1,0),(1,1),(1,2),(1,3)
     * (2,0),(2,1),(2,2),(2,3)
     * (3,0),(3,1),(3,2),(3,3)
     * 最外层,上下界为min = 0和 max = 3，旋转为:
     * 上 -> 右 -> 下 -> 左 - > 上， 从上面的元素开始，(min,min) 到 (min,max-1), 记 i begins with min ,ends with max-1.
     * (0,0) -> (0,3) -> (3,3) -> (3,0) -> (0,0)， i = 0
     * (0,1) -> (1,3) -> (3,2) -> (2,0) -> (0,1)， i = 1
     * (0,2) -> (2,3) -> (3,1) -> (1,0) -> (0,2)， i = 2
     */
    public static class Solution1 extends RotateImage {

        @Override
        public void rotate(int[][] matrix) {
            int size = matrix.length;
            for (int layer = 0; layer < size / 2; layer ++) {
                int min = layer;
                int max = size -1 - layer;
                for(int i = min; i < max ; i++) {
                    int offset = i - min;
                    // save top
                    int top = matrix[min][i];// begins with (min,min), end with (min, max -1)
                    // left to top
                    matrix[min][i] = matrix[max - offset][min];
                    // bottom to left
                    matrix[max - offset][min] = matrix[max][max - offset];
                    //right to bottom
                    matrix[max][max - offset] = matrix[i][max];
                    //top to right
                    matrix[i][max] = top;
                }
            }
        }
    }
}
