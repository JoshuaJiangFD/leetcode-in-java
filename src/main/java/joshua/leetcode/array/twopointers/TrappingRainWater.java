package joshua.leetcode.array.twopointers;

import joshua.leetcode.solutiontag.Stacks;
import joshua.leetcode.solutiontag.TwoPointers;
import sun.reflect.generics.reflectiveObjects.NotImplementedException;

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
     *
     * For example,
     * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
     *
     * @param height
     * @return
     */
    public abstract int trap(int[] height);

    @TwoPointers
    public static class Solution1 extends TrappingRainWater {

        @Override
        public int trap(int[] height) {
            throw new NotImplementedException();
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
            stack.push(0);
            for (int i = 1; i < height.length; i++) {
                if(stack.isEmpty() || height[i] < height[stack.peek()]) {
                    stack.push(i);
                    continue;
                }
                int bottom = height[stack.pop()];
                while (!stack.isEmpty()) {
                    if ( height[stack.peek()] <= height[i]) {
                        int idx = stack.pop();
                        water += (i - idx - 1) * (height[idx] - bottom);
                        bottom = height[idx];
                    } else {
                        break;
                    }
                }
                stack.push(i);
            }
            return water;
        }
    }
}
