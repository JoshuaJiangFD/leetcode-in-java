package joshua.leetcode.bits;

/**
 * 136. Single Number</br>
 * <a href="https://leetcode.com/problems/single-number/">leetcode link</a>
 *
 * @author Joshua.Jiang on 2016/3/12.
 */
public abstract class SingleNumber {

    /**
     * Given an array of integers, every element appears twice except for one. Find that single one.
     *
     * Note:
     * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
     *
     * @param nums
     * @return
     */
    public abstract int singleNumber(int[] nums);

    /**
     * Bit manipulation.[独立完成]
     * x & x = 0, 所以将所有数相异或， 最终的结果就是那个单独的数
     *
     */
    static class Solution1 extends SingleNumber{

        @Override
        public int singleNumber(int[] nums) {
            if (nums == null) {
                return 0;
            }
            for (int i= 1;i<nums.length;i++) {
                nums[0] ^=nums[i];
            }
            return nums[0];
        }
    }

}
