

package joshua.leetcode.bfs;

import java.util.*;

/**
 * 126. Word Ladder II</br>
 * <p/>
 * <a href="https://leetcode.com/problems/word-ladder-ii/">leetcode link</a>
 *
 * @author Jiang Yong
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
         * 最基本的BFS算法
         * <p/>
         * 缺点：需要对每个节点保存已走过的路径，空间复杂度取决于branch factor，即每个节点的分支数量。
         * 由于需要复制路径，并且会遇到branch factor过大的情况，所有会Time Limit Exceeded。
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

    /**
     * 对BFS的优化。
     * <p/>
     * 如果单纯的将word抽象为节点，word之间diff为1认为可以到达，那么可以形成一个无向有环图。
     * 但是如果使用BFS找到连接beginWord和endWord的所有最短路径，则可以形成一个有向无环图。
     * 这里重要的是确定出发点和结束点之后求的是最短路径，因此形成的是有先后顺序的有向关系。
     * <p/>
     * 同时在具体的搜索过程中，每轮以路径递增的顺序搜索，在某轮出现了到达endWord的路径之后，就可以在完成
     * 本轮搜索(找到具有相同长度的最短路径)之后结束整个BFS过程了。
     * <p/>
     * 同时在以上BFS过程中，对于所有搜寻到的点，保存所有以该点为结束点的路径，即以逆邻接表的方式方式存储。
     * <p/>
     * 因为以这种方式建立的图，并不是所有节点都在某条最短路径中，因此为了降低最后搜寻最短路径的复杂度，
     * 是从endWord出发来逆序搜寻到startWord的路径的，这里就解释了上面为什么用逆邻接表来存储了。
     */
    public static class Solution2 extends WordLadder2 {

        /**
         * 用于存储最短路径的反向邻接表，key的value是所有以key为结束边的出发点的集合。
         * 之所以用反向邻接表存储是因为方便最后从endWord出发DFS搜寻所有的最短路径。
         */
        private Map<String, List<String>> inversedAdjTable = new HashMap<String, List<String>>();

        private List<List<String>> shortestPaths = new ArrayList<List<String>>();

        @Override
        public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
            // generate the DAG constructed by all the shortest path.
            genDAG(beginWord, endWord, wordList);
            if (!inversedAdjTable.containsKey(endWord)) {
                return shortestPaths;
            }
            LinkedList<String> path = new LinkedList<String>();
            path.addFirst(endWord);
            genPaths(beginWord, endWord, path);
            return shortestPaths;
        }

        private void genDAG(String startWord, String endWord, Set<String> set) {
            set.add(endWord);
            Queue<String> stepsAtLevel = new LinkedList<String>();
            stepsAtLevel.add(startWord);
            boolean found = false;
            //BFS, every iteration is for one level.
            int currentLevelSize = 1;
            while (currentLevelSize > 0) {
                int nextLevelSize = 0;
                Set<String> visitedWords = new HashSet<String>();
                while (currentLevelSize-- > 0) {
                    String stepWord = stepsAtLevel.poll();
                    char[] chars = stepWord.toCharArray();
                    boolean reachEndWord = false;
                    for (int i = 0; i < chars.length; i++) {
                        char originalChar = chars[i];
                        for (char ch = 'a'; ch <= 'z'; ch++) {
                            if (originalChar != ch) {
                                chars[i] = ch;
                                String ladderWord = new String(chars);
                                //if visitedWords contains the ladderword means the shortest path from beginWord to this
                                //ladderword has been found at previous rounds, so no need to update the adjacent edges
                                //for this word, as DAG only need to includes edges involved in those shortest paths.
                                if (set.contains(ladderWord)) {
                                    if (!inversedAdjTable.containsKey(ladderWord)) {
                                        inversedAdjTable.put(ladderWord, new ArrayList<String>());
                                    }
                                    inversedAdjTable.get(ladderWord).add(stepWord);
                                    if (endWord.equals(ladderWord)) {
                                        // shortest path found, so we can stop stepWord's transition flagged
                                        // by reachEndWord variable and the whole iteration flagged by found variable.
                                        reachEndWord = found = true;
                                        break;
                                    }
                                    if (visitedWords.add(ladderWord)) {
                                        stepsAtLevel.offer(ladderWord);
                                        nextLevelSize++;
                                    }
                                }
                            }
                        }
                        if (reachEndWord) {
                            // no need to try more possible transition for current step word after having proved that
                            // it reached the end word. 'cause there is only at most one possible transition.
                            break;
                        } else {
                            chars[i] = originalChar;
                        }
                    }
                }
                if (found) {
                    break;
                } else {
                    set.removeAll(visitedWords);
                    currentLevelSize = nextLevelSize;
                }
            }
        }

        /**
         * generate all the shorted path from the DAG's inverse adjacent table.
         * DFS from the endWord.
         *
         * @param beginWord
         * @param endWord
         */
        private void genPaths(String beginWord, String endWord, LinkedList<String> path) {
            List<String> adjacentComingWords = inversedAdjTable.get(endWord);
            for (String word : adjacentComingWords) {
                path.addFirst(word);
                if (word.equals(beginWord)) {
                    List<String> shortestPath = new ArrayList<String>(path);
                    shortestPaths.add(shortestPath);
                } else {
                    genPaths(beginWord, word, path);
                }
                path.removeFirst();
            }
        }
    }

    /**
     * 对{@link Solution2}的进一步改进。
     * Solution2的弱点是如果从startWord出发的branch factor很大，意思是说startWord可以跳到100个ladderWord,然后这100个ladderword又
     * 可以跳到1000个ladderword，这样需要的存储空间就很大，list的插入也是时间开销。
     * 但是相反如果从endWord回溯的ladderword只有3个，其实可以考虑从endword出发。
     * <p/>
     * 所以这里的优化点是双端BFS,每次从较小的branch set出发去BFS，直到两个branch set相遇，表示找到了最短路径。
     */
    public static class Solution3 extends Solution2 {

        /**
         * 用于存储最短路径的反向邻接表，key的value是所有以key为结束边的出发点的集合。
         * 之所以用反向邻接表存储是因为方便最后从endWord出发DFS搜寻所有的最短路径。
         */
        private Map<String, List<String>> inverseAdjTable = new HashMap<String, List<String>>();
        private List<List<String>> shortestPaths = new ArrayList<List<String>>();

        @Override
        public List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
            Set<String> startSet = new HashSet<String>();
            startSet.add(beginWord);
            Set<String> endSet = new HashSet<String>();
            endSet.add(endWord);
            wordList.remove(beginWord);
            wordList.remove(endWord);
            genDAG(startSet, endSet, wordList, true);
            genPaths(beginWord, endWord, new ArrayList<String>());
            return shortestPaths;
        }

        private void genDAG(Set<String> startSet, Set<String> endSet, Set<String> wordList, boolean fromBeginWord) {
            if (startSet.size() == 0) {
                return;
            }
            if (startSet.size() > endSet.size()) {
                genDAG(endSet, startSet, wordList, !fromBeginWord);
                return;
            }
            boolean met = false;
            Set<String> visitedWords = new HashSet<String>();
            for (String stepWord : startSet) {
                char[] chars = stepWord.toCharArray();
                for (int i = 0; i < chars.length; i++) {
                    char originalChar = chars[i];
                    for (char ch = 'a'; ch <= 'z'; ch++) {
                        if (originalChar != ch) {
                            chars[i] = ch;
                            String ladderWord = new String(chars);
                            String key = fromBeginWord ? ladderWord : stepWord;
                            String value = fromBeginWord ? stepWord : ladderWord;
                            if (endSet.contains(ladderWord)) {
                                met = true;
                                if (!inverseAdjTable.containsKey(key)) {
                                    inverseAdjTable.put(key, new ArrayList<String>());
                                }
                                inverseAdjTable.get(key).add(value);
                            }
                            if (!met && wordList.contains(ladderWord)) {
                                visitedWords.add(ladderWord);
                                if (!inverseAdjTable.containsKey(key)) {
                                    inverseAdjTable.put(key, new ArrayList<String>());
                                }
                                inverseAdjTable.get(key).add(value);
                            }
                        }
                    }
                    chars[i] = originalChar;
                }
            }
            if (!met) {
                wordList.removeAll(visitedWords);
                genDAG(visitedWords, endSet, wordList, fromBeginWord);
            }
        }

        private void genPaths(String beginWord, String endWord, List<String> path) {
            path.add(0, endWord);
            if (endWord.equals(beginWord)) {
                shortestPaths.add(new LinkedList<String>(path));
            } else {
                List<String> words = inverseAdjTable.get(endWord);
                if (words != null) {
                    for (String word : words) {
                        genPaths(beginWord, word, path);
                    }
                }
            }
            path.remove(0);
        }
    }
}
