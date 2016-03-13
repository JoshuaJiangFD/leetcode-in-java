package joshua.leetcode.bits;

/**
 * 137. Single Number II<br>
 * <a href="https://leetcode.com/problems/single-number-ii/">leetcode link</a>
 *
 * @author Joshua.Jiang on 2016/3/12.
 */
public abstract class SingleNumber2 {

    /**
     * Given an array of integers, every element appears three times except for one. Find that single one.
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     *
     * @param nums
     * @return
     */
    public abstract int singleNumber(int[] nums);

    /**
     * Bit manipulation.<br>
     *
     * <a href="https://leetcode.com/discuss/84820/python-easy-understand-solution-using-32-bit-counters">看懂的解法</a>
     * <br>
     * <a href="https://leetcode.com/discuss/81165/explanation-manipulation-method-might-easier-understand">没看懂的解法</a>
     */
    static class Solution1 extends SingleNumber2 {

        @Override
        public int singleNumber(int[] nums) {
            int result = 0;
            for (int i = 0; i < 32; i++) {
                int count = 0;
                for(int n : nums) {
                    count += (n >> i) &1;
                }
                int rem = count % 3;
                if ( i==31 && rem!=0) {
                    result -=1<< 31;
                } else if (rem == 2){
                    result |= 1 << i;
                } else {
                    result |= rem << i;
                }
            }
            return result;
        }
    }
}
