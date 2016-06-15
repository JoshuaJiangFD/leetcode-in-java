

package joshua.leetcode.math;

/**
 * 342. Power of Four<br/>
 * <p/>
 * <a href="https://leetcode.com/problems/power-of-four/">leetcode link</a>
 *
 * @author Jiang Yong
 */
public abstract class PowerOfFour {

    /**
     * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
     * <p/>
     * Example:
     * Given num = 16, return true. Given num = 5, return false.
     * <p/>
     * Follow up: Could you solve it without loops/recursion?
     */
    public abstract boolean isPowerOfFour(int num);

    /**
     * 同 {@link joshua.leetcode.math.PowerOfThree.Solution1}
     */
    public static class Solution1 extends PowerOfFour {

        @Override
        public boolean isPowerOfFour(int num) {
            if ( num <=0) {
                return false;
            }
            if (num == 1) {
                return true;
            }
            return num%4 == 0 && isPowerOfFour(num/4);
        }
    }

    public static class Solution2 extends PowerOfFour {

        @Override
        public boolean isPowerOfFour(int num) {
            if (num <= 0) {
                return false;
            }
            while (num%4 == 0) {
                num = num >> 2;
            }
            return num == 1;
        }
    }
}
