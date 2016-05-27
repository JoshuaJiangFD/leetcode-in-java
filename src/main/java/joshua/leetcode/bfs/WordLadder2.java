// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.leetcode.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 126. Word Ladder II</br>
 * <p/>
 * <a href="https://leetcode.com/problems/word-ladder-ii/">leetcode link</a>
 *
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public abstract class WordLadder2 {

    /**
     * Given two words (beginWord and endWord), and a dictionary's word list,
     * find all shortest transformation sequence(s) from beginWord to endWord, such that:
     * <p/>
     * Only one letter can be changed at a time
     * Each intermediate word must exist in the word list
     * For example,
     * <p/>
     * Given:<br/>
     * beginWord = "hit"
     * endWord = "cog"
     * wordList = ["hot","dot","dog","lot","log"]
     * Return
     * [
     * ["hit","hot","dot","dog","cog"],
     * ["hit","hot","lot","log","cog"]
     * ]
     * <br/>
     * Note:<br/>
     * <ul>
     * <li>All words have the same length.</li>
     * <li>All words contain only lowercase alphabetic characters./li>
     * </ul>
     *
     * @param beginWord
     * @param endWord
     * @param wordList
     * @return
     */
    public abstract List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList);

    /**
     *
     */
    public static class Solution1 extends WordLadder2 {

        /**
         * BFS算法，但是需要对每个节点保存已走过的路径。
         *
         * @param beginWord
         * @param endWord
         * @param wordList
         * @return
         */
        @Override
        public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
            List<QueueItem> steps = new LinkedList<QueueItem>();
            List<String> path = new ArrayList<String>();
            path.add(beginWord);
            steps.add(new QueueItem(beginWord, path));
            List<List<String>> result = new ArrayList<List<String>>();
            boolean found = false;
            while (!steps.isEmpty()) {
                List<QueueItem> newSteps = new LinkedList<QueueItem>();
                for (int i = 0; i < steps.size(); i++) {
                    QueueItem oldStep = steps.get(i);
                    char[] chars = oldStep.word.toCharArray();
                    boolean reached = false;
                    for (int j = 0; j < chars.length; j++) {
                        char ch = chars[j];
                        for (int k = 0; k < 26; k++) {
                            chars[j] = (char) (k + 'a');
                            if (ch != chars[j]) {
                                String str = new String(chars);
                                if (str.equals(endWord)) {
                                    found = reached = true;
                                    oldStep.path.add(endWord);
                                    result.add(oldStep.path);
                                    break;
                                }
                                if (wordList.contains(str)) {
                                    List<String> newPath = new ArrayList<String>(oldStep.path);
                                    newPath.add(str);
                                    newSteps.add(new QueueItem(str, newPath));
                                }
                            }
                        }
                        if (reached) {
                            break;
                        } else {
                            chars[j] = ch;
                        }
                    }
                }
                if (found) {
                    break;
                } else {
                    for (QueueItem item : newSteps) {
                        wordList.remove(item.word);
                    }
                    steps = newSteps;
                }
            }
            return result;
        }

        class QueueItem {
            String word;
            List<String> path;

            public QueueItem(String word, List<String> path) {
                this.word = word;
                this.path = path;
            }
        }
    }
}
