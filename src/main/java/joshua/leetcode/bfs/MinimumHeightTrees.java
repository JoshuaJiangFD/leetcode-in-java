package joshua.leetcode.bfs;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 310. Minimum Height Trees<br/>
 * <p/>
 * <a href = "https://leetcode.com/problems/minimum-height-trees/">leetcode link</a>
 * <p/>
 * Created by joshu on 2016/5/19.
 */
public abstract class MinimumHeightTrees {

    /**
     * For a undirected graph with tree characteristics, we can choose any node as the root.
     * The result graph is then a rooted tree.
     * Among all possible rooted trees, those with minimum height are called minimum height trees (MHTs).
     * Given such a graph, write a function to find all the MHTs and return a list of their root labels.
     * <p/>
     * <b>Format</b>
     * <ul>
     * <li>The graph contains n nodes which are labeled from 0 to n - 1. You will be given the number n and a list of undirected edges (each edge is a pair of labels).</li>
     * <li>You can assume that no duplicate edges will appear in edges. Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.</li>
     * </ul>
     * <p/>
     *
     * Example 1:
     * <p/>
     * Given n = 4, edges = [[1, 0], [1, 2], [1, 3]]
     * <p/>
     *  0<br/>
     *  |<br/>
     *  1<br/>
     * / \<br/>
     * 2   3<br/>
     * return [1]
     * <p/>
     * Example 2:
     * <p/>
     *
     * Given n = 6, edges = [[0, 3], [1, 3], [2, 3], [4, 3], [5, 4]]
     * <p/>
     * 0  1  2<br/>
     *  \ | /<br/>
     *   3<br/>
     *   |<br/>
     *   4<br/>
     *   |<br/>
     *   5<br/>
     * return [3, 4]
     *
     * @param n the number of vertexes in graph
     * @param edges the edges in graph
     * @return
     */
    public abstract List<Integer> findMinHeightTrees(int n, int[][] edges);

    /**
     * 思路来自拓扑排序。
     * 这个问题先简化为,假如能找到图的最长路径，那么minimum height tree的顶点就是这条路径的中间节点，如果路径长度为奇数就是1个，
     * 路径长度为偶数就是2个。
     * 如何找到这个中间节点可以从路径两端出发，以步长为1同时移动，相遇时的节点就是中间节点。
     *
     * 这个方法借鉴到这个问题上，从所有的叶子节点出发，每次剪去所有的叶子节点，然后更新所有其他节点的degree，直到只剩下不多于两个节点
     * 迭代终止。
     * <p/>
     * <a href="https://leetcode.com/discuss/71763/share-some-thoughts">leetcode 解答</a>
     *
     */
    public static class Solution1 extends MinimumHeightTrees {

        @Override
        public List<Integer> findMinHeightTrees(int n, int[][] edges) {
            LinkedList<Integer> leaves = new LinkedList<Integer>();
            if (n == 1) {
                leaves.add(0);
                return leaves;
            }
            // 初始化一个类似邻接矩阵(Adjacency Matrix)标识的结构从来存储每个顶点上的边信息，set的大小就是外层list对应下标的度，
            // 这个信息用来判断叶子节点
            Set[] adjMatrix = new Set[n];
            for (int[] edge : edges) {
                if (adjMatrix[edge[0]] == null) {
                    Set<Integer> adjs = new HashSet<Integer>();
                    adjMatrix[edge[0]] = adjs;
                }
                adjMatrix[edge[0]].add(edge[1]);
                if (adjMatrix[edge[1]] == null) {
                    Set<Integer> adjs = new HashSet<Integer>();
                    adjMatrix[edge[1]] = adjs;
                }
                adjMatrix[edge[1]].add(edge[0]);
            }
            // 初始化叶子节点
            for(int i = 0; i < adjMatrix.length; i ++) {
                if (adjMatrix[i].size() == 1) {
                    leaves.add(i);
                }
            }
            // 裁剪叶子节点
            while(n > 2) {
                n -= leaves.size();
                int size = leaves.size();
                for(int i = 0; i< size; i++) {
                    int leave = leaves.removeFirst();
                    int adj = (Integer)adjMatrix[leave].iterator().next();
                    adjMatrix[adj].remove(leave);
                    if (adjMatrix[adj].size() == 1) {
                        leaves.add(adj);
                    }
                }
            }
            return leaves;
        }
    }
}
