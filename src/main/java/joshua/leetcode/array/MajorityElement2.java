package joshua.leetcode.array;

import java.util.List;

/**
 * 	229	Majority Element II
 *
 * 	@see <a href="https://leetcode.com/problems/majority-element-ii/">leetcode link</a>
 */
public abstract class MajorityElement2 {

    /**
     * Given an integer array of size n, find all elements that appear more than ⌊n/3⌋ times.
     *
     * The algorithm should run in linear time and in O(1) space.
     *
     * @param nums
     * @return
     */
    public abstract List<Integer> majorityElement(int[] nums);

    static class Solution1 extends  MajorityElement2{

        @Override
        public List<Integer> majorityElement(int[] nums) {

        }
    }
}