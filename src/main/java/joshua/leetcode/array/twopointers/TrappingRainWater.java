package joshua.leetcode.array.twopointers;

import joshua.leetcode.solutiontag.Stacks;
import joshua.leetcode.solutiontag.TwoPointers;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Trapping Rain Water
 *
 * @author joy
 * @see < a href="https://leetcode.com/problems/trapping-rain-water/">leetcode link</a>
 */
public abstract class TrappingRainWater {

    /**
     * Given n non-negative integers representing an elevation map where the width of each bar is 1,
     * <p/>
     * compute how much water it is able to trap after raining.
     * <p/>
     * <p/>
     * For example,
     * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     *
     * @param height the array of heights.
     * @return
     */
    public abstract int trap(int[] height);

    @TwoPointers
    public static class Solution1 extends TrappingRainWater {

        /**
         * 双指针法的思路解释如下：
         * left pointer和right pointer从两端向中间移动，肯定有一侧高，一侧低。这时候从低的一侧灌水肯定能trap住。
         * 因此可以继续移动低的一侧的指针，同时判断移动的过程中能够trap的水量（小方块），直到到达最低点。
         * 这时候再次判断left pointer和right pointer的大小。
         * 直到两个指针相遇。
         */
        @Override
        public int trap(int[] height) {
            // can only trap water when length >= 3
            if (height == null || height.length < 3) {
                return 0;
            }
            int water = 0;
            int leftPointer = 0;
            int rightPointer = height.length - 1;
            int maxLeft = 0;
            int maxRight = 0;
            // 结束条件
            while (leftPointer < rightPointer) {
                // 左低右高，计算左侧蓄水量
                if (height[leftPointer] < height[rightPointer]) {
                    // 无法继续蓄水，更新左侧Bar值
                    if (maxLeft < height[leftPointer]) {
                        maxLeft = height[leftPointer];
                    } else {
                        // 蓄水量
                        water += maxLeft - height[leftPointer];
                    }
                    leftPointer++;
                } else {
                    // 左高右低，计算右侧需水量
                    if (maxRight < height[rightPointer]) {
                        // 无法继续蓄水，更新右侧Bar值
                        maxRight = height[rightPointer];
                    } else {
                        // 蓄水量
                        water += maxRight - height[rightPointer];
                    }
                    rightPointer--;
                }
            }
            return water;
        }
    }

    /**
     * 使用栈，按元素从左到右，比栈顶元素小的话就入栈，直到比栈顶大的元素就开始对做出栈操作，每次计算两个元素之间水平方向
     * 顶部聚集起来的水方块的个数
     */
    @Stacks
    public static class Solution2 extends TrappingRainWater {

        @Override
        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            Deque<Integer> stack = new LinkedList<Integer>();
            // stack stores the index of element.
            int water = 0;
            for (int i = 0; i < height.length; i++) {
                if (stack.isEmpty() || height[stack.peek()] >= height[i]) {
                    stack.push(i);
                } else {
                    int tmp = stack.pop();
                    if (!stack.isEmpty()) {
                        int heightVal = Math.min(height[stack.peek()], height[i]) - height[tmp];
                        int widthVal = i - stack.peek() - 1;
                        water += heightVal * widthVal;
                    }
                    i--;
                }
            }
            return water;
        }
    }
}
