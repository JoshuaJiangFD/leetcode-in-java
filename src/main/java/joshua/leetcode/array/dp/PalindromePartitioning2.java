package joshua.leetcode.array.dp;

/**
 * 132. Palindrome Partitioning II<br>
 * <a href="https://leetcode.com/problems/palindrome-partitioning-ii/">leetcode link</a>
 *
 * @author Joshua.Jiang on 2016/3/13.
 */
public abstract class PalindromePartitioning2 {

    /**
     * Given a string s, partition s such that every substring of the partition is a palindrome.
     * <p/>
     * Return the minimum cuts needed for a palindrome partitioning of s.
     * <p/>
     * For example, given s = "aab",
     * Return 1 since the palindrome partitioning ["aa","b"] could be produced using 1 cut.
     *
     * @param s
     * @return
     */
    public abstract int minCut(String s);

    /**
     * Dynamic Programming.<br>
     * <a href="https://leetcode.com/discuss/76411/easiest-java-dp-solution-97-36%25">leetcode solution link</a><br>
     *
     * 解析：<br>
     * 对于字符串s[i,...,j]来说，假设s不存在回文子串，s的min cut就是length(j-i+1),因为每个单个字符都是回文<br>
     * 对于任意的k(i=&lt;k=&lt;j), 满足s[k+1,...,j]是回文子串，<br>, 则mincut(s)=min(mincut(s[i,...,k])+1), k满足以上条件<br>
     * 另外如果s[j, i]是回文, 如果[j + 1, i - 1]是回文, 并且c[j] == c[i].<br>
     * 综合以上两点，使用动态规划算法，
     */
    static class Solution1 extends  PalindromePartitioning2 {

        @Override
        public int minCut(String s) {
            int len = s.length();
            int[] mincut = new int[len];
            boolean[][] flags = new boolean[len][len];
            for ( int j = 0; j < len; j++) {
                // calculate the mincut of substring s[0,...,j],and record it into mincut[j]
                int min = j;//the initial value is the maximum cut,i.e. each character as a palindrome.
                for (int i =0; i <=j; i++) {
                    if(s.charAt(i) == s.charAt(j) && ((i +1 > j -1)||flags[i+1][j-1])) {
                        flags[i][j] = true;
                        if (i == 0) {
                            min = 0;
                        } else {
                            min = Math.min(min, mincut[i-1]+1);
                        }
                    }
                }
                mincut[j] = min;
            }
            return mincut[len-1];
        }
    }
}
