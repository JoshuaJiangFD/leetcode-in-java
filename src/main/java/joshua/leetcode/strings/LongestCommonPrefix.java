package joshua.leetcode.strings;

/**
 * 14	Longest Common Prefix
 *
 * @author joy
 * @see <a href="https://leetcode.com/problems/longest-common-prefix/">leetcode link</a>
 */
public abstract class LongestCommonPrefix {

    /**
     * Write a function to find the longest common prefix string amongst an array of strings.
     *
     * @param strs
     * @return
     */
    public abstract String longestCommonPrefix(String[] strs);

    static class Solution1 extends LongestCommonPrefix {

        @Override
        public String longestCommonPrefix(String[] strs) {
            if (strs == null || strs.length == 0)
                return "";
            String str = strs[0];
            int end = 0;
            boolean flag = false;/*whether comparison is over*/
            if (str == null || str.length() == 0)
                return "";
            if (strs.length == 1)
                return str;
            while (end < strs[0].length()) {
                for (int i = 1; i < strs.length; i++) {
                    if (strs[i] == null || strs[i].length() - 1 < end) {
                        flag = true;
                        break;
                    }
                    if (strs[i].charAt(end) != str.charAt(end)) {
                        flag = true;
                        break;
                    }
                }
                if (!flag)
                    end++;
                else {
                    if (end == 0) end = -1;
                    break;
                }
            }
            return end == -1 ? "" : str.substring(0, end);
        }

    }
}
