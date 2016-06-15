

package joshua.leetcode.array.twopointers;

import java.util.HashMap;

/**
 * 76. Minimum Window Substring<br/>
 * <p/>
 * <a href = "https://leetcode.com/problems/minimum-window-substring/">leetcode link</a>
 *
 * @author Jiang Yong
 */
public abstract class MinimumWindowSubstring {

    /**
     * Given a string S and a string T,
     * find the minimum window in S which will contain all the characters in T in complexity O(n).
     * <p/>
     * For example,
     * S = "ADOBECODEBANC"
     * T = "ABC"
     * Minimum window is "BANC".
     * <p/>
     * Note:
     * If there is no such window in S that covers all characters in T, return the empty string "".
     * <p/>
     * If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.
     */
    public abstract String minWindow(String s, String t);

    /**
     * 这一题类似于：给红绿蓝三种颜色，和一串珠子，要求找出最短的连续子串包含这三种颜色。
     *
     * 这一题要求O(n)的时间复杂度，因此考虑Two Pointers。
     * left pointer 指向子串的头，right pointer 指向子串的尾。
     *
     * 这里需要记录若干个变量：
     * 1） 当前某个字符是不是包含在T中，用hash map
     * 2） 当前是不是找到了所有T中的字符， 用一个计数变量；
     * 3） 当找到了包含所有T中字符的子串之后，需要判断是不是最短子串，因此需要保存最短子串的长度；
     * 4） 对于当前最短子串，通过substring[leftpointer, rightpointer]得到子串
     * 5） 什么时候移动 left pointer？
     *      当移动right pointer 发现有一个T中字符的出现次数大于1时，说明有重复了，则需要将
     *      left pointer移动到下一个只出现了一次的字符的位置
     *      或者已经找到了某个符合条件的子串，可以移动left pointer到下一个属于T的字符
     *
     */
    public static class Solution1 extends MinimumWindowSubstring {

        @Override
        public String minWindow(String s, String t) {
            int minimumLength = Integer.MAX_VALUE;
            String minimumStr = "";
            // flags means how many characters there have met  the requirement, with same occurrence as t.
            int flag = 0;
            int distinctChars = 0;
            HashMap<Character, Integer> countRecorderS = new HashMap<Character, Integer>();
            HashMap<Character, Integer> countRecorderT = new HashMap<Character, Integer>();
            for(Character ch : t.toCharArray()) {
                if (countRecorderT.containsKey(ch)) {
                    countRecorderT.put(ch, countRecorderT.get(ch) + 1);
                } else {
                    countRecorderT.put(ch, 1);
                    distinctChars ++;
                }
                countRecorderS.put(ch, 0);
            }
            int leftPointer = 0 , rightPointer = 0;
            while(rightPointer < s.length()) {
                char ch = s.charAt(rightPointer);
                if (! countRecorderS.containsKey(ch)) {
                    rightPointer ++;
                } else {
                    countRecorderS.put(ch, countRecorderS.get(ch) + 1);
                    if (countRecorderS.get(ch).equals(countRecorderT.get(ch))) {
                        flag ++;
                    }
                    // check and move left pointer
                    while (leftPointer <= rightPointer) {
                        if (!countRecorderS.containsKey(s.charAt(leftPointer))) {
                            leftPointer ++;
                        } else if (countRecorderS.get(s.charAt(leftPointer)) > countRecorderT.get(s.charAt(leftPointer))) {
                            countRecorderS.put(s.charAt(leftPointer), countRecorderS.get(s.charAt(leftPointer)) -1);
                            leftPointer ++;
                        } else {
                            break;
                        }
                    }
                    // check if got the valid substring
                    if (distinctChars == flag) {
                        if (rightPointer - leftPointer + 1 < minimumLength) {
                            minimumLength = rightPointer - leftPointer + 1;
                            minimumStr = s.substring(leftPointer, rightPointer+1);
                        }
                        //move left pointer one step to right direction.
                        countRecorderS.put(s.charAt(leftPointer), countRecorderS.get(s.charAt(leftPointer)) -1);
                        flag --;
                        leftPointer ++;
                    }
                    rightPointer ++;
                }
            }
            return minimumStr;
        }
    }
}
