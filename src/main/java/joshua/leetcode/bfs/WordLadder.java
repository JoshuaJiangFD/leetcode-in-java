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


    /**
     * BFS (breath first searching)
     * 类似于Dijkstra的最短路径算法。<br/>
     * 最短路径算法用于计算带权重的有向图中，从出发点a到某一结束点b的最短路径。算法思想是：
     * 假设所有顶点的集合为V，
     * 算法按照递增的顺序维护一个已找到最短路径的结束点的集合S，S的初始状态极为出发点a，并创建另一个数组len[v]维护从a出发到各个其他顶点的最短路径长度。
     * 每次都从V-S中选取一条次最短路径，并将结束点加入到S中，并更新len[v],更新是对每个还未找到最短路径的顶点(在V-S中), 更新a到这些顶点的最短路径值。
     * 这里的假设是：
     * 下一条结束点在V-S中次最短路径，中间的每个点都必定是在S中的，所以每个新加入S中的阶段都有可能是这条此最短路径的中间点。
     * <p/>
     * 此处的解法利用了最短路径的思想，按照路径长度递增的顺序，检验能否到达endword，不能的话，将选取路径递增1之后能到达的节点，放入queue中，
     * 这样就形成了一个BFS。
     */
    public static class Solution1 extends WordLadder {

        @Override
        public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
            Queue<String> queue = new LinkedList<String>();
            queue.add(beginWord);
            int resultLength = 1;
            while (!queue.isEmpty()) {
                int sizeInIteration = queue.size();
                for (int i = 0; i < sizeInIteration; i++) {
                    String polled = queue.poll();
                    char[] arr = polled.toCharArray();
                    for (int j = 0; j < polled.length(); j++) {
                        char ch = arr[j];
                        for (int k = 0; k < 26; k++) {
                            arr[j] = (char)('a' + k);
                            if (arr[j] != ch) {
                                String str = new String(arr);
                                if (endWord.endsWith(str)) {
                                    return resultLength + 1;
                                }
                                if (wordList.contains(str)) {
                                    wordList.remove(str);
                                    queue.add(str);
                                }
                            }
                        }
                        arr[j] = ch;
                    }
                }
                resultLength++;
            }
            return 0;
        }
    }
}
