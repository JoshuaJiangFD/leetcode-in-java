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

    /**
     * 方法2是方法1的一种巧妙的改进。
     * 注意到方法1的两个list,fromLeft和fromRight可以合并。
     * 在计算完fromLeft之后，实际上可以直接从fromLeft的尾部开始往左扫描，在计算result[k]的时候，
     * fromLeft[0]用来存储nums[k+1,..,len-1]的乘积，在之前的计算中result[k]存储的是nums[0,...,k-1]的乘积，两者相乘就得到了最终结果。
     * 同时可以将fromLeft[0]更新为fromLeft[0]*nums[k]
     */
    public static class Solution2 extends ProductOfArrayExceptSelf {

        @Override
        public int[] productExceptSelf(int[] nums) {
            // i.e. [1,2,3,4]
            int[] result = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                if(i == 0) {
                    result[0] = 1;
                } else {
                    result[i] = result[i-1] * nums[i-1];
                }
            }
            /* result is now: [1, 1, 2, 6]
             * the next iteration will be:
             * [1,1,2,6] -> [1,1,2,6] -> [4,1,2,6]
             * [4,1,2,6] -> [4,1,8,6] -> [12,1,8,6]
             * [12,1,8,6] -> [12,12,8,6] -> [24,12,8,6]
            */
            for(int i = nums.length - 1; i > 0; i--) {
                result[i] = result[i] * result[0];
                result[0] *= nums[i];
            }
            return result;
        }
    }
}
