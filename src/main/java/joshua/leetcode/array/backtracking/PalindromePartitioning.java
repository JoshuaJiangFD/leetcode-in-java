package joshua.leetcode.array.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. Palindrome Partitioning
 * <br>
 * <a href="https://leetcode.com/problems/palindrome-partitioning/">leetcode link</a>
 *
 * @author Joshua.Jiang on 2016/3/13.
 */
public abstract class PalindromePartitioning {

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * <p/>
     * Return all possible palindrome partitioning of s.
     * <p/>
     * For example, given s = "aab",
     * Return
     * <p/>
     * [
     * ["aa","b"],
     * ["a","a","b"]
     * ]
     *
     * @param s The input string
     * @return
     */
    public abstract List<List<String>> partition(String s);

    /**
     * <b>动态规划+回溯算法</b><br>
     * <p/>
     * 1) 对于字符串S，首先计算所有的子串是否为回文，这一步使用动态规划实现，得到一个二维数组。<br>
     * 二维数组bi-array[i][j]的右上半角(i&lt;=j)的每个元素表示子串s[i,...,j]是否为回文；<br>
     * 这一步的时间复杂度为o(n<SUP>2</SUP>)<br>
     * 2) 然后使用回溯算法，枚举分割后所有子串为回文的情况。<br>
     * 这一步的时间复杂度同样为o(n<SUP>2</SUP>)
     */
    static class Solution1 extends PalindromePartitioning {

        @Override
        public List<List<String>> partition(String s) {
            List<List<String>> result = new ArrayList<List<String>>();
            // dp[i][j] represents whether substring s[i..j] is palindrome.
            boolean[][] dp = new boolean[s.length()][s.length()];
            // calculate the dp's right-top triangle column by column from left to right.
            for (int j = 0; j < s.length(); j++) {
                // we only care about the substring with i as the starting index and j as the ending index
                // so the j should be no less than i.
                for (int i = 0; i <= j; i++) {
                    if (s.charAt(i) == s.charAt(j) && ((j - i <= 2) || dp[i + 1][j - 1])) {
                        dp[i][j] = true;
                    }
                }
            }
            backtracking(result, new ArrayList<String>(), dp, s, 0);
            return result;
        }

        /**
         * backtracking the dp two-dimensional array to collect all the result.
         *
         * @param result the final result.
         * @param path   the current path.
         * @param dp     flags of all substrings whether they are palindrome or not.
         * @param s      the original string.
         */
        private void backtracking(List<List<String>> result, List<String> path, boolean[][] dp, String s, int pos) {
            if (pos == s.length()) {
                result.add(new ArrayList<String>(path));
                return;
            }
            for (int i = pos; i < s.length(); i++) {
                if (dp[pos][i]) {
                    // if s[pos,...,i] is palindrome, then we partition at position i and move forward.
                    path.add(s.substring(pos, i + 1));
                    backtracking(result, path, dp, s, i + 1);
                    // remove the last element to move backward(backtracking), and try  the next i position.
                    path.remove(path.size() - 1);
                }
            }
        }
    }
}
