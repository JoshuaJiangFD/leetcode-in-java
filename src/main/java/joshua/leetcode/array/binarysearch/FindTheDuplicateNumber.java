

package joshua.leetcode.array.binarysearch;

/**
 * 287. Find the Duplicate Number<br>
 * <p/>
 * <a href = "https://leetcode.com/problems/find-the-duplicate-number/">leetcode link</a>
 *
 * @author Jiang Yong
 */
public abstract class FindTheDuplicateNumber {

    /**
     * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
     * <p/>
     * Note:<br/>
     * <ul>
     * <li>You must not modify the array (assume the array is read only).</li>
     * <li>You must use only constant, O(1) extra space.</li>
     * <li>Your runtime complexity should be less than O(n2).</li>
     * <li>There is only one duplicate number in the array, but it could be repeated more than once.</li>
     * </ul>
     *
     * @param nums the input array
     * @return the duplicated number
     */
    public abstract int findDuplicate(int[] nums);

    /**
     * Binary Search算法。
     *
     * 假设不出现重复数字的话，假设数组为 [1,2,3,4], n = 4, 那么在落在任意左开右闭区间(i,j]上的元素的个数即为:j-i个，
     * 如(2,3]区间上的元素为1个，即为:[3], (2,4]区间上的元素为2个，即为[3],[4]
     * 那么整体思路如下：
     * 对区间[1,n+1]不断二分，每次计算落在左半区间和右半区间的元素的个数，如果某个区间的元素个数比区间长度大，说明落在这个区间的存在重复元素。
     * 这样时间复杂度为o(logn*n)
     *
     */
    public static class Solution1 extends FindTheDuplicateNumber {

        @Override
        public int findDuplicate(int[] nums) {
            int low = 1;
            int high = nums.length - 1;
            while (low < high) {
                int mid = (low + high) / 2;
                int offset = high - mid;
                for (int num : nums) {
                    if (num > mid && num <= high) {
                        offset --;
                    }
                }
                // 落在右半边的元素个数比有半边区间长度大，说明右半边有重复元素，窗口移到右半边
                if (offset < 0) {
                    low = mid + 1;
                } else {
                    high = mid;
                }
            }
            return low;
        }
    }

}
