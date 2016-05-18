// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.leetcode.hashtable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 * 49. Group Anagrams<br/>
 * <a href="https://leetcode.com/problems/anagrams/">leetcode link</a>
 *
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public abstract class GroupAnagrams {

    /**
     * Given an array of strings, group anagrams together.
     * <p/>
     * For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"],
     * Return:
     * <p/>
     * [<br/>
     * ["ate", "eat","tea"],<br/>
     * ["nat","tan"],<br/>
     * ["bat"]<br/>
     * ]<br/>
     * Note:<br/>
     * <ul>
     * <li>For the return value, each inner list's elements must follow the lexicographic order.</li>
     * <li>All inputs will be in lower-case.</li>
     * </ul>
     *
     * @param strs
     * @return
     */
    public abstract List<List<String>> groupAnagrams(String[] strs);

    public static class Solution1 extends GroupAnagrams{

        @Override
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> anagrams = new HashMap<String, List<String>>();
            for (String str : strs) {
                int[] flags = new int[26];
                for(char ch : str.toCharArray()) {
                    flags[ch - 'a']++;
                }
                StringBuilder stringBuilder = new StringBuilder();
                for (int flag : flags) {
                    stringBuilder.append(flag);
                }
                String key = stringBuilder.toString();
                if (!anagrams.containsKey(key)) {
                    List<String> group = new LinkedList<String>();
                    group.add(str);
                    anagrams.put(key, group);
                } else {
                    List<String> group = anagrams.get(key);
                    group.add(str);
                }
            }
            List<List<String>> result = new ArrayList<List<String>>();
            for(List<String> group : anagrams.values()) {
                Collections.sort(group);
                result.add(group);
            }
            return result;
        }
    }
}
