package joshua.leetcode.heap;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 239. Sliding Window Maximum<br/>
 * <p/>
 * <a href="https://leetcode.com/problems/sliding-window-maximum/">leetcode link</a>
 *
 * @author Jiang Yong
 */
public abstract class SlidingWindowMaximum {

    /**
     * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position.
     * <p/>
     * For example,
     * Given nums = [1,3,-1,-3,5,3,6,7], and k = 3.
     * <p/>
     * Window position                Max
     * ---------------               -----
     * [1  3  -1] -3  5  3  6  7       3
     * 1 [3  -1  -3] 5  3  6  7        3
     * 1  3 [-1  -3  5] 3  6  7        5
     * 1  3  -1 [-3  5  3] 6  7        5
     * 1  3  -1  -3 [5  3  6] 7        6
     * 1  3  -1  -3  5 [3  6  7]       7
     * Therefore, return the max sliding window as [3,3,5,5,6,7].
     * <p/>
     * Note:
     * You may assume k is always valid, ie: 1 ≤ k ≤ input array's size for non-empty array.
     * <p/>
     * Follow up:
     * Could you solve it in linear time?
     */
    public abstract int[] maxSlidingWindow(int[] nums, int k);


    /**
     * 使用双端队列（Deque）.
     * 使用双端队列的原因是一要保持队列内的元素保持元素的本来顺序，同时提供了类似Stack的操作可以在插入
     * 端删除元素。
     */
    public static class Solution1 extends SlidingWindowMaximum {

        @Override
        public int[] maxSlidingWindow(int[] nums, int k) {
            // store the index other than value
            Deque<Integer> deque = new ArrayDeque<Integer>();
            // store the maximum of all windows, 1 <=k <= nums.length
            int[] result = new int[nums.length - k + 1];
            for (int i = 0; i < nums.length; i++) {

                //step 1. remove all elements with index smaller than i-k+1 from the
                //head of the deque, 'cause they are left out of the siding window
                while (!deque.isEmpty() && deque.peek() < i - k + 1) {
                    //remove from the head of the deque, poll() equals pollFirst()
                    deque.poll();
                }

                //step 2: examine the element from the tail of deque, pop it if it's smaller than
                //nums[i], cause for elements smaller than nums[i], they won't have
                //a chance to become the maximum in the sliding window.
                while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                    deque.pollLast();
                }

                //step 3: put the new index into the tail of the deque by offer() method
                deque.offer(i);

                //step 4: for every i larger than k-1, calculate the maximum element of sliding
                //window represented by [i-k+1, i]
                if (i >= k - 1) {
                    result[i - k + 1] = nums[deque.peek()];
                }
            }
            return result;
        }
    }

    /**
     * For Example: nums = [2,1,3,4,6,3,8,9,10,12,56], w=4
     * <p/>
     * partition the array in blocks of size w=4. The last block may have less then w. 2, 1, 3, 4 | 6, 3, 8, 9 | 10, 12, 56|
     * <p/>
     * Traverse the list from start to end and calculate max so far. Reset max after each block boundary (of w
     * elements).
     * left_max[] = 2, 2, 3, 4 | 6, 6, 8, 9 | 10, 12, 56
     * <p/>
     * Similarly calculate max in future by traversing from end to start.
     * right_max[] = 4, 4, 4, 4 | 9, 9, 9, 9 | 56, 56, 56
     * <p/>
     * now, sliding max at each position i in current window, sliding-max(i) = max{rightmax(i), leftmax(i+w-1)}
     *
     * sliding_max = 4, 6, 6, 8, 9, 10, 12, 56
     * <p/>
     *
     * <a href = "https://leetcode.com/discuss/62695/o-n-solution-in-java-with-two-simple-pass-in-the-array">leetcode
     * 讨论解法链接</a>
     */
    public static class Solution2 extends SlidingWindowMaximum {

        @Override
        public int[] maxSlidingWindow(int[] nums, int k) {
            if(nums == null || nums.length == 0) {
                return new int[]{};
            }

            /*for each window, maximum element from left to right*/
            int[] max_left = new int[nums.length];
            /*for each window, maximum element from right to left*/
            int[] max_right = new int[nums.length];

            max_left[0] = nums[0];
            max_right[nums.length - 1] = nums[nums.length - 1];

            for (int i = 1; i < nums.length; i++) {
                max_left[i] = (i % k == 0) ? nums[i] : Math.max(max_left[i - 1], nums[i]);

                final int j = nums.length - i - 1;
                max_right[j] = (j % k == 0) ? nums[j] : Math.max(max_right[j + 1], nums[j]);
            }

            // having nums.length-k+1 windows in the nums array
            int[] sliding_max = new int[nums.length - k + 1];

            for (int i = 0; i + k <= nums.length; i++) {
                sliding_max[i] = Math.max(max_right[i], max_left[i + k - 1]);
            }

            return sliding_max;
        }
    }
}
