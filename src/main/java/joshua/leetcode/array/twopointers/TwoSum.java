package joshua.leetcode.array.twopointers;

import java.util.Arrays;
import java.util.HashMap;

import joshua.leetcode.solutiontag.TwoPointers;


/**
 * Two Sum.</br>
 * <B>tags:</B> Array, HashTable.
 *
 * @author Joshua.Jiang
 * @see <a href="https://oj.leetcode.com/problems/two-sum/">https://oj.leetcode.com/problems/two-sum/</a></br>
 */
public abstract class TwoSum {

    /**
     * Given an array of integers, find two numbers such that they add up to a specific target number.
     * <p/>
     * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
     * <p/>
     * Please note that your returned answers (both index1 and index2) are not zero-based.
     * <p/>
     * You may assume that each input would have exactly one solution.
     * <p/>
     * Input: numbers={2, 7, 11, 15}, target=9
     * Output: index1=1, index2=2
     *
     * @param numbers
     * @param target
     * @return
     */
    public abstract int[] twoSum(int[] numbers, int target);

    /**
     * use HashMap to find the element.
     *
     * @author joy
     */
    static class Solution1 extends TwoSum {

        @Override
        public int[] twoSum(int[] numbers, int target) {
            HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
            int i = 0;
            for (int num : numbers) {
                map.put(num, i++);
            }
            for (i = 0; i < numbers.length; i++) {
                Integer index = map.get(target - numbers[i]);
                if (index != null && index > i)
                    return new int[]{i + 1, index + 1};
            }
            return null;
        }
    }

    /**
     * 1)sort the array firstly;
     * 2)set two pointers, one at the head, one at the tail;
     * 3)move the tail or head pointer if the sum is bigger or smaller than the target value;
     * 4)function exit if the two pointers meet or we find the pair with correct sum;
     *
     * @author joy
     */
    @TwoPointers
    static class Solution2 extends TwoSum {

        @Override
        public int[] twoSum(int[] numbers, int target) {
            Arrays.sort(numbers);
            int i = 0, j = numbers.length - 1;
            while (i < j) {
                int sum = numbers[i] + numbers[j];
                if (sum == target)
                    return new int[]{i + 1, j + 1};
                else if (sum < target)
                    i++;
                else
                    j--;
            }
            return null;
        }

    }
}
