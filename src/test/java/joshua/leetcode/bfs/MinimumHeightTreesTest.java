package joshua.leetcode.bfs;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

public class MinimumHeightTreesTest {

    private Map<Param, List<Integer>> cases = Maps.newHashMap();

    @Before
    public void setUp() {
//        int[][] edges = new int[][]{{0, 3}, {1, 3}, {2, 3}, {4, 3}, {5, 4}};
//        List<Integer> result = Lists.newArrayList(3, 4);
//        cases.put(new Param(6, edges), result);
        // case 2
        int[][] edges2 = new int[][]{{0, 1}, {0, 2}};
        cases.put(new Param(3, edges2), Lists.newArrayList(0));
    }

    @Test
    public void testSolution1() {
        MinimumHeightTrees solution = new MinimumHeightTrees.Solution1();
        for(Param param : cases.keySet()) {
            List<Integer> roots = solution.findMinHeightTrees(param.numOfVertex, param.edges);
            assertEquals(cases.get(param), roots);
        }
    }

    class Param {
        int numOfVertex;

        int[][] edges;

        public Param(int numOfVertex, int[][] edges) {
            this.numOfVertex = numOfVertex;
            this.edges = edges;
        }
    }
}