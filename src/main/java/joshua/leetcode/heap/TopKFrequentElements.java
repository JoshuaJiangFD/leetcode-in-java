package joshua.leetcode.heap;

import com.google.common.collect.Lists;
import joshua.leetcode.solutiontag.BucketSort;
import joshua.leetcode.solutiontag.MinHeap;

import java.util.*;

/**
 * 347. Top K Frequent Elements</br>
 * <p/>
 * <a href = "https://leetcode.com/problems/top-k-frequent-elements/">leetcode link</a>
 * <p/>
 * Created by joshu on 2016/5/24.
 */
public abstract class TopKFrequentElements {

    public abstract List<Integer> topKFrequent(int[] nums, int k);


    @MinHeap
    public static class Solution1 extends TopKFrequentElements {

        @Override
        public List<Integer> topKFrequent(int[] nums, int k) {
            Arrays.sort(nums);
            // in java priority queue is implemented by min stack, the element at head is the minimum of queue.
            PriorityQueue<QueueItem> minStack = new PriorityQueue<QueueItem>();
            for (int i = 0; i < nums.length; i++) {
                int count = 1;
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                minStack.offer(new QueueItem(nums[i], count));
            }
            List<Integer> topK = Lists.newArrayList();
            for (int j = 0; j < k; j++) {
                topK.add(minStack.poll().val);
            }
            return topK;
        }

        class QueueItem implements Comparable<QueueItem> {
            int val;
            int frequency;

            public QueueItem(int val, int frequency) {
                this.val = val;
                this.frequency = frequency;
            }

            @Override
            public int compareTo(QueueItem o) {
                return o.frequency - frequency;
            }
        }
    }

    @BucketSort
    public static class Solution2 extends TopKFrequentElements {

        @Override
        public List<Integer> topKFrequent(int[] nums, int k) {
            Arrays.sort(nums);
            Map<Integer, List<Integer>> frequencyBucket = new HashMap<Integer, List<Integer>>();
            int maxFrequency = 0;
            for (int i = 0; i < nums.length; i++) {
                int count = 1;
                while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
                    count++;
                    i++;
                }
                if (!frequencyBucket.containsKey(count)) {
                    frequencyBucket.put(count, new ArrayList<Integer>());
                }
                frequencyBucket.get(count).add(nums[i]);
                maxFrequency = Math.max(maxFrequency, count);
            }
            List<Integer> topK = new ArrayList<Integer>();
            int size = 0;
            for (int i = maxFrequency; i > 0; i--) {
                if (!frequencyBucket.containsKey(i)) {
                    continue;
                }
                for (Integer ele : frequencyBucket.get(i)) {
                    topK.add(ele);
                    size++;
                    if (size == k) {
                        break;
                    }
                }
                if (size == k) {
                    break;
                }
            }
            return topK;
        }
    }
}
