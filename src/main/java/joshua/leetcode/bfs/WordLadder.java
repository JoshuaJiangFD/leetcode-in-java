package joshua.leetcode.bfs;

import java.util.*;

/**
 * 127. Word Ladder
 * <br/>
 * <a href = "https://leetcode.com/problems/word-ladder/">leetcode link</a>
 *
 * @author Joshua.Jiang on 2016/5/14.
 */
public abstract class WordLadder {

    /**
     * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
     * <ol>
     * <li>Only one letter can be changed at a time</li>
     * <li>Each intermediate word must exist in the word list</li>
     * </ol>
     * For example,<br>
     * Given:<br>
     * beginWord = "hit"<br>
     * endWord = "cog"<br>
     * wordList = ["hot","dot","dog","lot","log"]<br>
     * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
     * return its length 5.
     * <p/>
     * Note:
     * <ul>
     * <li>Return 0 if there is no such transformation sequence.</li>
     * <li>All words have the same length.</li>
     * <li>All words contain only lowercase alphabetic characters.</li>
     * </ul>
     *
     * @return
     */
    public abstract int ladderLength(String beginWord, String endWord, Set<String> wordList);


    public static class Solution1 extends WordLadder {

        @Override
        public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
            Queue<String> queue = new LinkedList<String>();
            queue.addAll(wordList);
            queue.add(endWord);
            int resultLength = 1;
            while (!queue.isEmpty()) {
                int sizeInIteration = queue.size();
                for (int i = 0; i < sizeInIteration; i++) {

                }
            }
        }


        /**
         * judge whether two words can be transformed.
         * Note:
         * All words have the same length.
         * All words contain only lowercase alphabetic characters.
         *
         * @param word1
         * @param word2
         * @return
         */
        private boolean canTransform(String word1, String word2) {
            int diffs = 0;
            for (int i = 0; i < word1.length(); i++) {
                if (word1.charAt(i) != word2.charAt(i)) {
                    diffs++;
                    if (diffs == 2) {
                        break;
                    }
                }
            }
            return diffs == 1;
        }
    }
}
