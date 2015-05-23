package joshua.leetcode.array.twopointers;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 *209	Minimum Size Subarray Sum
 * <a href="https://leetcode.com/problems/minimum-size-subarray-sum/">leetcode link</a>
 */
public abstract class MinimumSizeSubarraySum {

    /**
     * Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.
     *
     * For example, given the array [2,3,1,2,4,3] and s = 7,
     * the subarray [4,3] has the minimal length under the problem constraint.

     * @param s
     * @param nums
     * @return
     */
    public abstract int minSubArrayLen(int s, int[] nums);


    /**
     * scan from head to tail, every element has two choices, either start a new sub-array or concatenate to preceding sub-arrays.
     * we maintain a queue of sum. for every next element,
     *  1) we check from head of queue to pop elements  out if sum + next element's value exceeds given s.
     *     If we decide to pop up the sum in queue, the length of corresponding sub array if the current length of the queue.
        2) enqueue current element;

     * function keeps records of the minimum length and update it when popping each element from the queue.
     *
     * time complexity 0(n^2)
     */
    static class Solution1 extends MinimumSizeSubarraySum{

        @Override
        public int minSubArrayLen(int s, int[] nums) {
            if(nums==null||nums.length==0)
                return 0;
            int miniLength=Integer.MAX_VALUE;
            Queue<Integer> sumQueue = new ArrayDeque<Integer>();
            for(int i=0;i<nums.length;i++){
                if(i<nums.length&&nums[i]>=s)
                    return 1;
                int size=sumQueue.size();
                while(size>0){
                    int ele=sumQueue.remove()+nums[i];
                    if(ele>=s){
                        miniLength=Math.min(miniLength,size+1);
                    }else
                        sumQueue.add(ele);
                    size--;
                }
                sumQueue.add(nums[i]);
            }
            return miniLength==Integer.MAX_VALUE?0:miniLength;
        }
    }

    /**
     * two pointers way,  to simplify the Solution1.
     * allow alter array's value
     * still 0(n^2) time complexity
     */
    public static class Solution2 extends MinimumSizeSubarraySum{

        @Override
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int miniLen=Integer.MAX_VALUE;
            int idx1=-1,idx2=0;
            while(idx2<nums.length){
                if(nums[idx2]>=s)
                    return 1;
                int temp=idx2-1;
                while(temp>idx1){
                    nums[temp]+=nums[temp+1];
                    if(nums[temp]>=s){
                        miniLen=Math.min(miniLen,temp-idx1+1);
                        idx1=temp+1;
                        break;
                    }
                }
                idx2++;
            }
            return miniLen==Integer.MAX_VALUE?0:miniLen;
        }
    }

    /**
     * more simplified way, two pointers move together forward.
     * time complexity o(n)
     */
    public static class Solution3 extends MinimumSizeSubarraySum{

        @Override
        public int minSubArrayLen(int s, int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            int miniLen=Integer.MAX_VALUE;
            int idx1=0,idx2=0,sum=0;/*sum is the summary of elements in interval[idx1,idx2]*/
            while(idx2<nums.length){
                if(nums[idx2]>=s)
                    return 1;
                sum+=nums[idx2];
                /*move idx1 forward*/
                while(sum>=s){
                    miniLen=Math.min(miniLen,idx2-idx1+1);
                    sum-=nums[idx1++];
                }
                idx2++;
            }
            return miniLen==Integer.MAX_VALUE?0:miniLen;
        }
    }

    /**
     * binary search way.
     * firstly add all elements up to get a array of sum, each element is the sum from 0 to current index.
     * then from head to tail, search the interval which end at current index, with sum no less than given s.
     * time complexity o(nlog(n)).
     */
    public static class Solution4 extends  MinimumSizeSubarraySum{

        @Override
        public int minSubArrayLen(int s, int[] nums) {
        	int miniLeng=Integer.MAX_VALUE;
            if (nums == null || nums.length == 0) {
                return 0;
            }
            for(int i=1;i<nums.length;i++){
                if(nums[i]>=s)
                    return 1;
                nums[i]+=nums[i-1];
            }

            int left=0;
            for(int right=0;right<nums.length;right++){
            	if(nums[right]>=s){
            		left=binarySearchLeft(left,right,nums,s,nums[right]);
            		miniLeng=Math.min(miniLeng, right-left+1);
            	}
            }
            return miniLeng==Integer.MAX_VALUE?0:miniLeng;
        }
        
        private int binarySearchLeft(int left,int right,int[] nums,int s,int currentVal){
        	while(left<=right){
        		int mid=(left+right)/2;
        		if(currentVal-nums[mid]>=s){
        			left=mid+1;
        		}else{
        			right=mid-1;
        		}
        	}
        	return left;
        }

    }
}
