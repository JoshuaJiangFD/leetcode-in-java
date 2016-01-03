package joshua.leetcode.divideconquer;

/**
 * Kth Largest Element in an Array
 *
 * @author joy
 * @see <a href="https://leetcode.com/problems/kth-largest-element-in-an-array/">leetcode link</a>
 */
public abstract class KthLargestElementInArray {

    /**
     * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
     * not the kth distinct element.
     * <p>
     * For example,
     * Given [3,2,1,5,6,4] and k = 2, return 5.
     * Note:
     * You may assume k is always valid, 1 ≤ k ≤ array's length.
     *
     * @param nums
     * @param k
     * @return
     */
    public abstract int findKthLargest(int[] nums, int k);

    /**
     * Divide and Conquer way.
     * partition the array using quick-sorting way(descending sort), every pass find the final position of an element.
     * If this position's index is bigger than k-1, quick sort the partition on left, otherwise right.
     * function returns if position is found at index k-1.
     *
     * @author joy
     */
    static class Solution1 extends KthLargestElementInArray {

        @Override
        public int findKthLargest(int[] nums, int k) {
            int pivotIdx, startIdx = 0, endIdx = nums.length - 1;
            do {
                pivotIdx = partition(nums, startIdx, endIdx);
                if (pivotIdx < k - 1)
                    startIdx = pivotIdx + 1;
                if (pivotIdx > k - 1)
                    endIdx = pivotIdx - 1;
            } while (pivotIdx != k - 1);
            return nums[k - 1];
        }

        private int partition(int[] nums, int start, int end) {
            if (start == end)
                return start;
            int cur = nums[start];
            while (start < end) {
                while (start < end && nums[end] <= cur)
                    end--;
                nums[start] = nums[end];
                while (start < end && nums[start] >= cur)
                    start++;
                nums[end] = nums[start];
            }
            /*start==end and is the  final position for element cur*/
            nums[start] = cur;
            return start;
        }
    }

    /**
     * heap sort.
     * build a k-size min-heap using the first k elements in the array.
     * for the rest, every time compare it with the top of heap, if bigger than root, replace root and adjust the heap again.
     *
     * @author joy
     */
    static class Solution2 extends KthLargestElementInArray {

        @Override
        public int findKthLargest(int[] nums, int k) {
			/*adjust the first k elements into a min-heap*/
            int firstNonLeafIdx = k / 2 - 1;
            while (firstNonLeafIdx > -1) {
                adjustHeap(firstNonLeafIdx, nums, k);
                firstNonLeafIdx--;
            }
            ;
            for (int i = k; i < nums.length; i++) {
                if (nums[i] > nums[0]) {
                    nums[0] = nums[i];
                    adjustHeap(0, nums, k);
                }
            }
            return nums[0];
        }

        /**
         * adjust the heap indexed from 0 to k-1
         *
         * @param startIdx
         * @param nums
         */
        private void adjustHeap(int startIdx, int[] nums, int k) {
            int temp = nums[startIdx];
            while (startIdx <= k / 2 - 1) {/*k/2-1 is the index of last non leaf element*/
				/*startIdx<=k/2-1 means it must have left kid*/
                int maxKid = startIdx * 2 + 1;
                if (startIdx * 2 + 2 <= k - 1
                        && nums[startIdx * 2 + 2] < nums[maxKid])
                    maxKid = startIdx * 2 + 2;
                if (temp > nums[maxKid]) {
                    nums[startIdx] = nums[maxKid];
                    startIdx = maxKid;
                } else
                    break;
            }
            nums[startIdx] = temp;
        }

    }
}
