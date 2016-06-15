

package joshua.leetcode.math;

/**
 * 231. Power of Two <br/>
 * <p/>
 * <a href="https://leetcode.com/problems/power-of-two/">leetcode link</a>
 *
 * @author Jiang Yong
 */
public abstract class PowerOfTwo {

    /**
     * Given an integer, write a function to determine if it is a power of two.
     */
    public abstract boolean isPowerOfTwo(int n);

    public static class Solution1 extends PowerOfTwo {

        /**
         * 能被2整除就执行右移操作，直到不能被2整除时候判断是否为1.
         *
         * @param n
         * @return
         */
        @Override
        public boolean isPowerOfTwo(int n) {
            while (n % 2 == 0) n = n >> 1;
            return n == 1;
        }
    }

    public static class Solution2 extends PowerOfTwo {

        /**
         * n = 8(1000), n-1=7(0111), (n-1 & n) = 0
         *
         * @param n
         * @return
         */
        @Override
        public boolean isPowerOfTwo(int n) {
            return n > 0 && ((n & (n - 1)) == 0);
        }
    }
}
