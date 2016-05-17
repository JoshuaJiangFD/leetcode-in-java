package joshua.leetcode.array.greedy;

import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 316. Remove duplicate letters
 *
 * @see <a href= "https://leetcode.com/problems/remove-duplicate-letters/">leetcode link</a>
 * <p/>
 * Created by joy on 2015/12/13.
 */
public abstract class RemoveDuplicateLetters {
    /**
     * Given a string which contains only lowercase letters, remove duplicate letters so that every letter appear once and only once.
     * <p/>
     * You must make sure your result is the smallest in lexicographical order among all possible results.
     * <p/>
     * Example:
     * Given "bcabc"
     * Return "abc"
     * <p/>
     * Given "cbacdcbc"
     * Return "acdb"
     *
     * @param s the target string
     * @return the result
     */
    public abstract String removeDuplicateLetters(String s);

    static class Solution1 extends RemoveDuplicateLetters {

        /**
         * 结果要求是按照字母顺序从小到大排列的。
         * 算法：
         *
         * 使用栈来保存最后的结果，并用额外空间保存所有的字母的出现次数。
         * 元素进栈时，和栈顶元素比较。
         * 同时需要保存该字母是否已经在结果中的信息。例如
         * stack中是"ad",下一个字母为'a',则不必再检查。
         */
        @Override
        public String removeDuplicateLetters(String s) {
            if (s == null || s.isEmpty())
                return s;
            Map<Character, Integer> counters = new HashMap<Character, Integer>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (counters.containsKey(ch))
                    counters.put(ch, counters.get(ch) + 1);
                else
                    counters.put(ch, 1);
            }
            boolean[] flags = new boolean[26];
            Deque<Character> result = new LinkedList<Character>();
            for (int i = 0; i < s.length(); i++) {
                char ch = s.charAt(i);
                if (flags[ch - 'a']){
                    counters.put(ch, counters.get(ch) - 1);
                    continue;
                }
                //为ch找一个最靠前的位置，只要栈顶字母比ch大，后面还会再出现元素，就会一直弹出栈顶元素。
                while (!result.isEmpty()) {
                    char top = result.getLast();
                    // 如果后面不会再出发top这个字母，则不能出栈了。
                    if (counters.get(top) == 1)
                        break;
                    if (top >= ch) {
                        flags[top - 'a'] = false;
                        result.removeLast();
                        counters.put(top, counters.get(top) - 1);
                    } else
                        break;
                }
                result.add(ch);
                flags[ch - 'a'] = true;
            }
            StringBuilder sBuilder = new StringBuilder();
            for (char ch : result)
                sBuilder.append(ch);
            return sBuilder.toString();
        }
    }
}
