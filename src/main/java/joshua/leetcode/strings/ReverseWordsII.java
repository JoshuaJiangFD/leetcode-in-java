

package joshua.leetcode.strings;

/**
 * 186. Reverse Words in a String II<br/>
 * <p/>
 * <a href="https://leetcode.com/problems/reverse-words-in-a-string-ii/">leetcode link</a>
 *
 * @author Jiang Yong
 */
public abstract class ReverseWordsII {

    /**
     * Given an input string, reverse the string word by word.
     * A word is defined as a sequence of non-space characters.
     * <p/>
     * The input string does not contain leading or trailing spaces and the words are always separated by a single space.
     * <p/>
     * For example,
     * Given s = "the sky is blue",
     * return "blue is sky the".
     * <p/>
     * Could you do it in-place without allocating extra space?
     *
     * @param s
     */
    public abstract void reverseWords(char[] s);

    /**
     * 思路很简单，首先将整个char[]反转
     * 得到'eulb si kys eht'.
     * 然后再对每个单词反转回来,例如：
     * 'blue si kys eht' ->
     * 'blue is kys eht' -> ..
     * 最终得到整个 'blue is sky the'
     *
     * 这样空间复杂度为o(1)
     */
    public static class Solution1 extends ReverseWordsII {

        @Override
        public void reverseWords(char[] s) {
            //step 1. reverse the whole char array
            for (int i = 0; i <= (s.length -1) / 2; i++) {
                char temp = s[i];
                s[i] = s[s.length - 1 - i];
                s[s.length - 1 - i] = temp;
            }
            //step 2. for each word reverse it back
            int formerSpaceIdx = -1;
            for (int i = 0; i < s.length; i++) {
                if (s[i] != ' ') continue;
                int beg = formerSpaceIdx + 1, end = i - 1;
                for (int j = beg; j <= (beg + end) / 2; j++) {
                    char temp = s[j];
                    s[j] = s[end - (j-beg)];
                    s[end - (j-beg)] = temp;
                }
                formerSpaceIdx = i;
            }
            //step 3. reverse the last word
            int beg = formerSpaceIdx + 1, end = s.length -1;
            for (int j = beg; j <= (beg + end) / 2; j++) {
                char temp = s[j];
                s[j] = s[end - (j-beg)];
                s[end - (j-beg)] = temp;
            }
        }
    }
}
