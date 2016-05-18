// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.leetcode.array.unionfind;

import java.util.HashSet;
import java.util.Set;

import joshua.leetcode.solutiontag.UnionFind;

/**
 * 200. Number of Islands<br/>
 * <p/>
 * <a href="https://leetcode.com/problems/number-of-islands/">leetcode link</a>
 *
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public abstract class NumberOfIslands {

    /**
     * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
     * <p/>
     * Example 1:
     * <p/>
     * 11110
     * 11010
     * 11000
     * 00000
     * Answer: 1
     * <p/>
     * Example 2:
     * <p/>
     * 11000
     * 11000
     * 00100
     * 00011
     * Answer: 3
     *
     * @param grid
     * @return
     */
    public abstract int numIslands(char[][] grid);

    @UnionFind
    public static class Solution1 extends NumberOfIslands {

        @Override
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
                return 0;
            int height = grid.length;
            int width = grid[0].length;
            int[] roots = new int[height * width];
            for (int i = 0; i < roots.length; i++) {
                int h = i / width;
                int j = i % width;
                if (grid[h][j] == '1') {
                    roots[i] = i;
                }
            }
            for (int i = 0; i < roots.length; i++) {
                int h = i / width;
                int w = i % width;
                if (grid[h][w] == '0') continue;
                // up
                if (h > 0 && grid[h - 1][w] == '1') {
                    connect(i, i - width, roots);
                }
                // left
                if (w > 0 && grid[h][w - 1] == '1') {
                    connect(i, i - 1, roots);
                }
            }
            Set<Integer> distinctRoots = new HashSet<Integer>();
            for (int i = 0; i < roots.length; i++) {
                int h = i / width;
                int w = i % width;
                if (grid[h][w] == '0') continue;
                int topRoot = findParent(roots, i);
                distinctRoots.add(topRoot);
            }
            return distinctRoots.size();
        }

        private int findParent(int[] roots, int x) {
            while (roots[x] != x) x = roots[x];
            return x;
        }

        private void connect(int x, int y, int[] roots) {
            int rootX = findParent(roots, x);
            int rootY = findParent(roots, y);
            if (rootX != rootY)
                roots[rootX] = rootY;
        }
    }

    public static class Solution2 extends NumberOfIslands {

        @Override
        public int numIslands(char[][] grid) {
            if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0)
                return 0;
            int height = grid.length;
            int width = grid[0].length;
            int count = 0;
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {
                    if (grid[i][j] != '0') {
                        markAsDrown(grid, i , j);
                        count ++;
                    }
                }
            }
            return count;
        }

        private void markAsDrown(char[][] grid, int i, int j) {
            if( i < 0 || i > grid.length -1 || j < 0 || j > grid[0].length -1 || grid[i][j] == '0')
                return;
            grid[i][j] = '0';
            markAsDrown(grid, i - 1, j);
            markAsDrown(grid, i + 1, j);
            markAsDrown(grid, i, j-1);
            markAsDrown(grid, i, j+1);
        }
    }
}
