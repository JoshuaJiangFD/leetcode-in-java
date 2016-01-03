package joshua.leetcode.divideconquer;

import java.util.ArrayList;
import java.util.List;

/**
 * 315. Count of Smaller numbers After self
 *
 * @see <a href="https://leetcode.com/problems/count-of-smaller-numbers-after-self/">leetcode link</a>
 * <p>
 * Created by joshua on 1/3/16.
 */
public abstract class CountOfSmallerNumbersAfterSelf {

    /**
     * You are given an integer array nums and you have to return a new counts array.
     * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
     * Example:
     * <p>
     * Given nums = [5, 2, 6, 1]
     * <p>
     * To the right of 5 there are 2 smaller elements (2 and 1).
     * To the right of 2 there is only 1 smaller element (1).
     * To the right of 6 there is 1 smaller element (1).
     * To the right of 1 there is 0 smaller element.
     * Return the array [2, 1, 1, 0].
     *
     * @param nums The nums
     * @return The result.
     */
    public abstract List<Integer> countSmaller(int[] nums);

    /**
     * Divide And Conquer way.
     * <p>
     * The idea is to compare the bits from high to low position, every iteration groups elements into two.
     * like using 4'1000' and elements [4,5,2,3], then higher groups(4 & 4 = 4, 4&2 = 0) is [4,5],
     * lower group is [2,3]. In every such grouping, we do it in right to left order.
     * so when putting elements in the higher group, we check elements size in the lower group, so that we know
     * how many elements there are right to the current one and also smaller.
     * for example, [2,3] is the lower group, then we check element 5, it belongs to the higher group, and
     * the size of [2,3] is 2, so we know there are two elements there right to 5 and also smaller.
     *
     * @see <a href="https://leetcode.com/discuss/74994/nlogn-divide-and-conquer-java-solution-based-bit-comparison">
     * answer link</a>
     */
    static class Solution1 extends CountOfSmallerNumbersAfterSelf {

        @Override
        public List<Integer> countSmaller(int[] nums) {
            List<Integer> res = new ArrayList<Integer>(nums.length);
            List<Integer> index = new ArrayList<Integer>(nums.length);
            for (int i = nums.length - 1; i >= 0; i--) {
                res.add(0);
                // reverse the index so that we will iterate from right to left in below process.
                index.add(i);
            }
            countSmallerSub(nums, index, 1 << 31, res);
            return res;
        }

        private void countSmallerSub(int[] nums, List<Integer> index, int mask, List<Integer> res) {
            if (mask != 0 && index.size() > 1) {
                List<Integer> highGroup = new ArrayList<Integer>(index.size());
                List<Integer> lowGroup = new ArrayList<Integer>(index.size());
                // we check the mask 's sign here to group positive and negative numbers.
                int highBit = (mask < 0 ? 0 : mask);
                for (int i = 0; i < index.size(); i++) {
                    if ((nums[index.get(i)] & mask) == highBit) {
                        /* check the current size of the lower group and update the result set
                         * the lower groups are all elements to the right and smaller.
                         */
                        res.set(index.get(i), res.get(index.get(i)) + lowGroup.size());
                        highGroup.add(index.get(i));
                    } else {
                        lowGroup.add(index.get(i));
                    }
                }
                countSmallerSub(nums, lowGroup, mask >>> 1, res);
                countSmallerSub(nums, highGroup, mask >>> 1, res);
            }
        }
    }

    /**
     * Divide and Conquer solution with merge sort.
     *
     * @see <a href="https://leetcode.com/discuss/74110/11ms-java-solution-using-merge-sort-with-explanation">
     * answer link</a>
     */
    static class Solution2 extends CountOfSmallerNumbersAfterSelf {

        List<Integer> result;

        @Override
        public List<Integer> countSmaller(int[] nums) {
            result = new ArrayList<Integer>();
            int[] indicies = new int[nums.length];
            for (int i = 0; i < nums.length; i++) {
                result.add(0);
                indicies[i] = i;
            }
            mergeSort(nums, indicies, 0, nums.length - 1);
            return result;
        }

        /**
         * Divide the range and sort respectively then merge together.
         * Whilst the merging, record the right and lower number count.
         *
         * @param nums    The original numbers.
         * @param indices The indices of the original numbers.
         * @param start   The starting index.
         * @param end     The ending index.
         */
        private void mergeSort(int[] nums, int[] indices, int start, int end) {
            if (end <= start) {
                return;
            }
            int mid = (start + end) / 2;
            mergeSort(nums, indices, start, mid);
            mergeSort(nums, indices, mid + 1, end);
            merge(nums, indices, start, end);
        }

        /**
         * @param nums    The original numbers
         * @param indices the sorted numbers represented in index
         * @param start   the starting point of the range
         * @param end     the ending point of the range
         */
        private void merge(int[] nums, int[] indices, int start, int end) {
            int mid = (start + end) / 2;
            int leftPointer = start;
            int rightPointer = mid + 1;
            int[] sortedIndicies = new int[end - start + 1];
            int sortIndex = 0;

            while (leftPointer <= mid && rightPointer <= end) {
                int leftIndex = indices[leftPointer];
                int rightIndex = indices[rightPointer];
                int leftValue = nums[leftIndex];
                int rightValue = nums[rightIndex];
                if (leftValue > rightValue) {
                    result.set(leftIndex, result.get(leftIndex) + (end - rightPointer + 1));
                    sortedIndicies[sortIndex++] = leftIndex;
                    leftPointer++;
                } else {
                    sortedIndicies[sortIndex++] = rightIndex;
                    rightPointer++;
                }
            }
            while (leftPointer <= mid) {
                sortedIndicies[sortIndex++] = indices[leftPointer];
                leftPointer++;
            }
            while (rightPointer <= end) {
                sortedIndicies[sortIndex++] = indices[rightPointer];
                rightPointer++;
            }
            System.arraycopy(sortedIndicies, 0, indices, 0, sortedIndicies.length);
        }
    }
}
