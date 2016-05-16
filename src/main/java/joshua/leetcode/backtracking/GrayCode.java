// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.leetcode.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 89. Gray Code <br>
 * <a href = "https://leetcode.com/problems/gray-code/">leetcode link</a>
 *
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public abstract class GrayCode {

    /**
     * The gray code is a binary numeral system where two successive values differ in only one bit.
     * <p/>
     * Given a non-negative integer n representing the total number of bits in the code, print the sequence of gray code. A gray code sequence must begin with 0.
     * <p/>
     * For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
     * <p/>
     * <ul>
     * <li>00 - 0</li>
     * <li>01 - 1</li>
     * <li>11 - 3</li>
     * <li>10 - 2</li>
     * </ul>
     * <p/>
     * Note:
     * For a given n, a gray code sequence is not uniquely defined.
     * <br/>
     * For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
     * <br/>
     * For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
     *
     * @param n
     * @return
     */
    public abstract List<Integer> grayCode(int n);

    /**
     * Backtracking based on recursion.
     */
    public static class Solution1 extends GrayCode {

        @Override
        public List<Integer> grayCode(int n) {
            List<Integer> result = new ArrayList<Integer>();
            resultsFromOneLevelLower(n, result);
            return result;
        }

        private void resultsFromOneLevelLower(int n, List<Integer> result) {
            if (n == 0) {
                result.add(0);
                return;
            }
            if (n == 1) {
                result.add(0);
                result.add(1);
                return;
            }
            resultsFromOneLevelLower(n - 1, result);
            int size = result.size();
            for (int i = size - 1; i > -1; i--) {
                result.add(result.get(i) + (1 << (n - 1)));
            }
        }
    }

    /**
     * 同样是基于回溯的方法，但是没有使用递归<br>
     * <a href = "https://leetcode.com/discuss/86617/6-line-java-solution-very-concise">leetcode answer link</a>
     *
     */
    public static class Solution2 extends GrayCode {

        @Override
        public List<Integer> grayCode(int n) {
            List<Integer> ans = new ArrayList<Integer>();
            ans.add(0);

            for (int i = 0; i < n; i++)
                for (int j = ans.size() - 1; j >= 0; j--)
                    ans.add(ans.get(j) + (1 << i));

            return ans;
        }
    }

    /**
     * 这个方法根据输出的规律采用了位运算的方法，非常的简洁。<br>
     * 为了输出 0,1,3,2的顺序，
     * 0 ^ (0 >> 1) = 0
     * 1 ^ (1 >> 1) = 1
     * 2 ^ (2 >> 1) = 3
     * 3 ^ (3 >> 1) = 2
     * <a href = "https://leetcode.com/discuss/93091/simplest-fastest-easiest-solution">leetcode answer link</a>
     */
    public static class Solution3 extends GrayCode {

        @Override
        public List<Integer> grayCode(int n) {
            int count = (int)Math.pow(2,n);
            List<Integer> res = new ArrayList<Integer>();
            for(int i = 0; i < count; i++){
                res.add((i) ^ (i >> 1));
            }
            return res;
        }
    }
}
