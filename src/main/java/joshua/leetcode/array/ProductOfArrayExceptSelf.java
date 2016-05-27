package joshua.leetcode.array;

/**
 * 238. Product of Array Except Self<br/>
 * <p/>
 * <a href = "https://leetcode.com/problems/product-of-array-except-self/">leetcode link</a>
 * <p/>
 * Created by joshu on 2016/5/27.
 */
public abstract class ProductOfArrayExceptSelf {

    /**
     * Given an array of n integers where n > 1, nums,
     * return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
     * <p/>
     * Solve it without division and in O(n).
     * <p/>
     * For example, given [1,2,3,4], return [24,12,8,6].
     * <p/>
     * Follow up:
     * Could you solve it with constant space complexity?
     * (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
     *
     * @param nums
     * @return
     */
    public abstract int[] productExceptSelf(int[] nums);

    /**
     * o(n)的算法，但是需要n的额外空间。
     * 维护两个数组，保存从左到右和从右到左的元素的乘积，即[0,..,k]和[k,..,nums.length-1]的乘积。
     * 最后将两个数组上相同位置上的值相乘即可。
     */
    public static class Solution1 extends ProductOfArrayExceptSelf {

        @Override
        public int[] productExceptSelf(int[] nums) {
            int[] fromLeft = new int[nums.length];
            int[] fromRight = new int[nums.length];

            for(int i = 0 ;i < nums.length; i++) {
                if(i == 0) {
                    fromLeft[i] = 1;
                } else {
                    fromLeft[i] = fromLeft[i-1] * nums[i-1];
                }
            }
            for(int i = nums.length -1 ;i > -1; i--) {
                if(i == nums.length-1) {
                    fromRight[i] = 1;
                } else {
                    fromRight[i] = fromRight[i+1] * nums[i+1];
                }
            }
            // multiple the two array calculated above
            for(int i = 0; i < nums.length; i++) {
                fromLeft[i] *= fromRight[i];
            }
            return fromLeft;
        }
    }
}
