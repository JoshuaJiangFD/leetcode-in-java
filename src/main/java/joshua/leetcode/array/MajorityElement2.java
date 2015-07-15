package joshua.leetcode.array;

import java.util.LinkedList;
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

    /**
     * variation of Moore voting algorithm
     *
     * 同时记录两个majority count,分别指向出现最多和次多的元素和对应的次数
     *
     * 在结束之后同样要验证两个元素是否超过1/3.
     */
    static class Solution1 extends  MajorityElement2{

        @Override
        public List<Integer> majorityElement(int[] nums) {
            int count1=0,count2=0;
            int ele1=0,ele2=1;
            for(int num : nums){
                if(num==ele1)
                    count1++;
                else if(num==ele2)
                    count2++;
                else if(count1==0){
                    ele1=num;count1=1;
                }else if(count2==0){
                    ele2=num;count2=1;
                }
                else{
                    count1--;count2--;
                }
            }
            List<Integer> answers=new LinkedList<Integer>();
            count1=count2=0;
            for(int num : nums){if(num==ele1) count1++; if(num==ele2) count2++;}
            if(count1>nums.length/3)
                answers.add(ele1);
            if(count2> nums.length/3)
                answers.add(ele2);
            return answers;
        }
    }
}