// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.leetcode.hashtable;

/**
 * 242. Valid Anagram<br/>
 * <p/>
 * <a href="https://leetcode.com/problems/valid-anagram/">leetcode link</a>
 *
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public abstract class ValidAnagram {

    /**
     * Given two strings s and t, write a function to determine if t is an anagram of s.
     * <p/>
     * For example,
     * s = "anagram", t = "nagaram", return true.
     * s = "rat", t = "car", return false.
     * <p/>
     * Note:<br/>
     * You may assume the string contains only lowercase alphabets.
     * <p/>
     * Follow up:<br/>
     * What if the inputs contain unicode characters? How would you adapt your solution to such case?
     *
     * @param s
     * @param t
     * @return
     */
    public abstract boolean isAnagram(String s, String t);


    public static class Solution1 extends ValidAnagram {

        @Override
        public boolean isAnagram(String s, String t) {
            int[] flags = new int[26];
            for(char ch : s.toCharArray()) flags[ch - 'a'] ++;
            for(char ch : t.toCharArray()) flags[ch - 'a'] --;
            for(int flag : flags)
            {
                if (flag != 0) return false;
            }
            return true;
        }
    }
}
