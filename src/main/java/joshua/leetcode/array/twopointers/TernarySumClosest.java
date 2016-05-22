package joshua.leetcode.array.twopointers;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * <p/>
 * <a href="https://leetcode.com/problems/3sum-closest/">leetcode link</a>
 *
 * @author Joshua.Jiang on 2016/5/21.
 */
public abstract class TernarySumClosest {

    /**
     * Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.
     * <p/>
     * For example, given array S = {-1 2 1 -4}, and target = 1.
     * <p/>
     * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
     *
     * @param nums   the array
     * @param target the target value
     * @return the closest sum for three elements from <code>nums</code>
     */
    public abstract int threeSumClosest(int[] nums, int target);


    /**
     * 一个从 {@link joshua.leetcode.array.TernarySum} 的解法的变种。
     * 不同的在于判断two pointers中如何移动left pointer和right pointer。
     */
    public static class Solution1 extends TernarySumClosest {

        @Override
        public int threeSumClosest(int[] nums, int target) {
            int closestSum = 0;
            int closestGap = Integer.MAX_VALUE;
            Arrays.sort(nums);
            for (int i = 0; i < nums.length - 2; i++) {
                int leftPointer = i + 1;
                int rightPointer = nums.length - 1;
                while (leftPointer < rightPointer) {
                    int sum = nums[i] + nums[leftPointer] + nums[rightPointer];
                    if (Math.abs(sum - target) < closestGap) {
                        closestSum = sum;
                        closestGap = Math.abs(sum - target);
                    }
                    if(sum < target) {
                        leftPointer ++;
                    } else {
                        rightPointer --;
                    }
                }
            }
            return closestSum;
        }
    }
}


