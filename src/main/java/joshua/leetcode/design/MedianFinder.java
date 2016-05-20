// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.leetcode.design;

import java.util.PriorityQueue;

/**
 * 295. Find Median from Data Stream<br/>
 * <p/>
 * <a href="https://leetcode.com/problems/find-median-from-data-stream/">leetcode link</a>
 *
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public abstract class MedianFinder {

    /**
     * Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.
     * <p/>
     * Examples:
     * [2,3,4] , the median is 3
     * <p/>
     * [2,3], the median is (2 + 3) / 2 = 2.5
     * <p/>
     * Design a data structure that supports the following two operations:<br/>
     * <ul>
     * <li>void addNum(int num) - Add a integer number from the data stream to the data structure.</li>
     * <li>double findMedian() - Return the median of all elements so far.</li>
     * </ul>
     * For example:
     * <p/>
     * add(1)
     * add(2)
     * findMedian() -> 1.5
     * add(3)
     * findMedian() -> 2
     */
    // Adds a number into the data structure.
    public abstract void addNum(int num);

    // Returns the median of current data stream
    public abstract double findMedian();


    /**
     * 先明确几个用到的概念：
     *
     * 最小堆(Min Heap), 内部实现是一个数组，每次插入堆会调整元素，保证最小元素在栈顶,即数组首位。每次调整的时间复杂度为o(logn)
     * 最大堆(Max Heap), 保证最大元素在栈顶，其他同上。
     *
     * 本题思路是将data stream一分为二的存储在两个堆中，一个最小堆aHeap用于存储较大的一半元素，一个最大堆bHeap用于存储较小的一半元素。
     * 并且保持aHeap永远比bHeap大小相等或者+1。
     * 这样，如果两个堆大小相等，则median就是aHeap的栈顶元素和bHeap的栈顶元素的平均值；
     * 如果两个堆大小相差1，则median就是aHeap的栈顶元素。
     *
     * 在Java中，PriorityQueue的内部实现就是min Heap。
     * 这样PriorityQueue的头部对应min heap的栈顶。压入栈的操作等同于入队操作，优先队列会调整栈顶元素使其最小。
     * 至于MaxHeap可以使用元素的负值插入到priorityQueue中，这样队列头部的元素的相反值就是最大值了，实现了max heap的作用。
     *
     */
    public static class Solution1 extends MedianFinder {

        /**
         * store the larger half of the ascending stream.
         * like [3,4,5] in [1,2,3,4,5]
         */
        PriorityQueue<Integer> minHeap = new PriorityQueue<Integer>();

        /**
         * store the lower half of the ascending stream,but in negative form, mimic the functionality of max heap.
         * like [-2,-1] in [1,2,3,4,5]
         */
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>();

        /**
         * mean the total number of data stream so far is even. initially it's even as zero.
         */
        private boolean isEven = true;

        @Override
        public void addNum(int num) {
            minHeap.offer(num);
            maxHeap.offer(-minHeap.poll());
            /*if it's even before this adding action, even maxHeap's size will exceed minHeap after the above two
            operations, then we need to get the largest element from the smaller part back into the larger part. */
            if (isEven) {
                minHeap.offer(-maxHeap.poll());
            }
            isEven = !isEven;
        }

        @Override
        public double findMedian() {
            if(minHeap.size() == 0)
                return 0;
            if (minHeap.size() == maxHeap.size()) {
                return (minHeap.peek() - maxHeap.peek()) / 2.0;
            } else {
                return minHeap.peek();
            }
        }
    }
}
