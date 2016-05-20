package joshua.leetcode.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * Longest Increasing Subsequence
 * <p/>
 * Created by joy on 2015/11/3.
 *
 * @see <a href="https://leetcode.com/problems/longest-increasing-subsequence/">leetcode link</a>
 */
public abstract class LongestIncreasingSubsequence {

    /**
     * Given an unsorted array of integers, find the length of longest increasing subsequence.
     * <p/>
     * For example,
     * Given [10, 9, 2, 5, 3, 7, 101, 18],
     * The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4.
     * Note that there may be more than one LIS combination, it is only necessary for you to return the length.
     * <p/>
     * Your algorithm should run in O(n2) complexity.
     *
     * @param nums
     */
    public abstract int lengthOfLIS(int[] nums);

    /**
     * Solution1: dynamic programming
     * <p/>
     * 给定数组a[n],记 LIS ending at a[i]为: LIS[i],0<=i<=n-1;
     * 所以满足a[j]<a[i],j<i条件的i中选取max(LIS[i]+1);
     * 则所求的长度为max(LIS[i])
     * <p/>
     * time complexity: o(n^2)
     */
    static class Solution1 extends LongestIncreasingSubsequence {

        @Override
        public int lengthOfLIS(int[] nums) {
            int maxLen = 0;
            if (nums == null || nums.length == 0)
                return 0;
            int[] lis = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                lis[i] = 1;//every element is a sub-sequence per se.
                for (int j = i - 1; j >= 0; j--) {
                    if (nums[j] < nums[i])
                        lis[i] = Math.max(lis[i], lis[j] + 1);
                }
                maxLen = Math.max(maxLen, lis[i]);
            }
            return maxLen;
        }
    }

    /**
     * optimized version of solution1.<br>
     * <p/>
     * solution1每次内层循环需要遍历所有已经迭代完成的元素，因为已经遍历元素的LIS大小只是局部最优，不是全局最优。</br>
     * solution2的改进在于，不再维护每个元素的LIS(该LIS以此元素结尾)的大小，而是维护长度为i的所有IS中最小的末尾元素。
     * 即维护的数组的下标不再对应index为i的元素，而是长度为i的IS。
     * 只存储最小的末尾元素是因为在所有等长的IS中，该最小末尾元素对应的IS最可能会被后面的元素追加增长，
     * 例如IS：[1,4]和[1,2]只需要保留[1,2],因为假设原序列为[1,4,2,3],则3可以追加到[1,2]而不是[1,4]。
     * <p/>
     * 维护的该数组为动态数组tailtable, tailtable[j]存储所有长度为j的递增组序列中末尾元素最小的元素。
     * 每次外层循环，对于nums[i],在tailtable中二分查找该插入的位置j（如果相同则跳过本次循环），更新tailtable[j]为nums[i],
     * 此时长度为j的目标子序列为tailtable[j-1]对应的目标子序列加上nums[i]得到.
     * 举例: 原数组为[1,4,2,3],
     * 1:[1],即长度为1的序列，为[1],末尾元素为1
     * 2:[1,4],即长度为2的序列， 为[1,4]，末尾元素为4
     * 在遇到2时，[1]追加2替代[1,4]为：
     * 1:[1]
     * 2:[1,2]，长度为2的序列，末尾元素更新为为2，2被4取代因为2更小，后面更可能会被延长
     * 在遇到3是时，[1,2]追加3，变成：
     * 1:[1]
     * 2:[1,2]
     * 3:[1,2,3]
     * 假设原数组为[1,4,2,3],则返回tailtable的size即可
     * <p/>
     * time complexity: o(nlogn)
     *
     * @see <a href="http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/">geeksforgeeks blog</a>
     */
    static class Solution2 extends LongestIncreasingSubsequence {

        @Override
        public int lengthOfLIS(int[] nums) {
            if (nums == null | nums.length == 0)
                return 0;
            List<Integer> tailTable = new ArrayList<Integer>();
            for (int i = 0; i < nums.length; i++) {
                //binary search nums[i] in tailTable
                int beg = 0, end = tailTable.size() - 1;
                while (end >= beg) {
                    int mid = (end + beg) >> 1;
                    if (tailTable.get(mid) >= nums[i]) end = mid - 1;
                    else
                        beg = mid + 1;
                }
                /*beg is either the position to insert(if not found) or the found index*/
                if (beg == tailTable.size()) {
                    tailTable.add(nums[i]);
                } else if (tailTable.get(beg) != nums[i])
                    tailTable.set(beg, nums[i]);
            }
            return tailTable.size();
        }
    }


}

