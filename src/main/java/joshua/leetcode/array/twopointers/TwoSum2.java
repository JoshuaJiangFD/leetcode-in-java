

package joshua.leetcode.array.twopointers;

import joshua.leetcode.solutiontag.BinarySearch;
import joshua.leetcode.solutiontag.TwoPointers;

/**
 * 167. Two Sum II - Input array is sorted<br/>
 * <p/>
 * <a href = "https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/">leetcode link</a>
 *
 * @author Jiang Yong
 */
public abstract class TwoSum2 {

    /**
     * Given an array of integers that is already sorted in ascending order,
     * find two numbers such that they add up to a specific target number.
     * <p/>
     * The function twoSum should return indices of the two numbers such that they add up to the target,
     * where index1 must be less than index2.
     * <p/>
     * Please note that your returned answers (both index1 and index2) are not zero-based.
     * <p/>
     * You may assume that each input would have exactly one solution.
     * <p/>
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     */
    public abstract int[] twoSum(int[] numbers, int target);

    @TwoPointers
    public static class Solution1 extends TwoSum2 {

        @Override
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[2];
            int beg = 0, end = numbers.length - 1;
            while (beg < end) {
                int sum = numbers[beg] + numbers[end];
                if (sum > target) {
                    end--;
                } else if (sum < target) {
                    beg++;
                } else {
                    result[0] = beg + 1;
                    result[1] = end + 1;
                    return result;
                }
            }
            return result;
        }
    }

    @BinarySearch
    public static class Solution2 extends TwoSum2 {

        @Override
        public int[] twoSum(int[] numbers, int target) {
            int[] result = new int[2];
            for (int i = 0; i < numbers.length; i++) {
                int find = binarySearch(numbers, i+1, numbers.length -1, target - numbers[i]);
                if (find != -1) {
                    result[0] = i + 1;
                    result[1] = find  + 1;
                    break;
                }
            }
            return result;
        }

        /**
         *Find the index with traget value in numbers array, within given range [fromIndex, endIndex]
         */
        private int binarySearch(int[] numbers, int fromIndex, int endIndex, int targetVal) {
            while (fromIndex <= endIndex) {
                int mid = (fromIndex + endIndex) / 2;
                if(numbers[mid] == targetVal) {
                    return mid;
                } else if (numbers[mid] < targetVal) {
                    fromIndex = mid + 1;
                } else {
                    endIndex = mid  - 1;
                }
            }
            return -1;
        }
    }
}
