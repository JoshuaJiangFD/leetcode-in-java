package joshua.leetcode.array;

import java.util.ArrayList;
import java.util.List;

/**
 * 41	First Missing Positive
 * <a href="https://leetcode.com/problems/first-missing-positive/">leetcode link</a>
 */
public abstract class FirstMissingPositive {

    /**
     * Given an unsorted integer array, find the first missing positive integer.
     * <p/>
     * For example,
     * Given [1,2,0] return 3,
     * and [3,4,-1,1] return 2.
     * <p/>
     * Your algorithm should run in O(n) time and uses constant space.
     *
     * @param nums
     * @return
     */
    public abstract int firstMissingPositive(int[] nums);

    /**
     *
     */
    public static class Solution1 extends FirstMissingPositive {

        @Override
        public int firstMissingPositive(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 1;
            }
            /*1. Put the corresponding positive value in the index that equals to its value*/
            for (int i = 0; i < nums.length; ) {
                int num = nums[i];
                if (num > 0 && num < nums.length && nums[num] != num) {
                    int temp = nums[num];
                    nums[num] = num;
                    nums[i] = temp;
                } else
                    i++;
            }

            /* 2. Scan the array to find the first value that is not equal to its index, then it is the missing value*/
            /*to start with, assuming all  1-A.length-1 has values respectively as 1,2..A.length-1,
             *if A[0]==len, for example, A[4,1,2,3] then first missing positive should be len+1,namely 5;
             *if A[0]!=len, for example, A[5,1,2,3] then first missing positive should be len, namely 4;
             */
            int missingPositive=nums[0]==nums.length?nums.length+1:nums.length;
            for(int i=1;i<nums.length;i++){
                if(nums[i]!=i){
                    missingPositive=i;
                    break;
                }
            }
            return missingPositive;
        }
    }
}
