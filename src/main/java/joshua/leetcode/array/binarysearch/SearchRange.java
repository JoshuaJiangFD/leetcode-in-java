package joshua.leetcode.array.binarysearch;

/**
 * 34	Search for a Range
 *
 * @see <a href="https://leetcode.com/problems/search-for-a-range/">leetcode link</a>
 */
public abstract class SearchRange {

    /**
     * Given a sorted array of integers, find the starting and ending position of a given target value.
     * Your algorithm's runtime complexity must be in the order of O(log n).
     * If the target is not found in the array, return [-1, -1].
     * For example,
     * Given [5, 7, 7, 8, 8, 10] and target value 8,
     * return [3, 4].
     *
     * @param nums
     * @param target
     * @return
     */
    public abstract int[] searchRange(int[] nums, int target);

    static class Solution1 extends SearchRange {

        @Override
        public int[] searchRange(int[] nums, int target) {
            /*search the leftmost index of 8, return 3*/
            int leftMostIdxOfTarget = BinarySearch.searchForLeftMost(nums, target);
            /*search the leftmost index of 9, 9 doesn't exist, will return the position to insert 9, here is 5*/
            int rightMostIdxofTarget = BinarySearch.searchForRightMost(nums, target);
            if (leftMostIdxOfTarget != rightMostIdxofTarget + 1)
                return new int[]{leftMostIdxOfTarget, rightMostIdxofTarget};
            return new int[]{-1, -1};
        }
    }

    /**
     * TODO: recursive binary search of range.
     * https://leetcode.com/discuss/40921/9-11-lines-o-log-n
     */
    public class Solution2 extends SearchRange{

        @Override
        public int[] searchRange(int[] nums, int target) {
            return new int[0];
        }
    }
}
