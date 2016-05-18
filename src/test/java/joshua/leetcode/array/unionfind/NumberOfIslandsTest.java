package joshua.leetcode.array.unionfind;

import static org.junit.Assert.assertEquals;

import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import com.google.common.collect.Maps;

public class NumberOfIslandsTest {

    private Map<char[][], Integer> cases = Maps.newHashMap();

    @Before
    public void setUp() {
        char[][] islands = new char[][]{
                {'1' ,'1','1'},
                {'0' ,'1','0'},
                {'1' ,'1','1'}
        };
        cases.put(islands, 1);
    }

    @Test
    public void testSolution2() {
        NumberOfIslands solution = new NumberOfIslands.Solution2();
        for(char[][] islands : cases.keySet()) {
            int num = solution.numIslands(islands);
            assertEquals((int)cases.get(islands), num);
        }
    }

    @Test
    public void testSolution1() {
        NumberOfIslands solution = new NumberOfIslands.Solution1();
        for(char[][] islands : cases.keySet()) {
            int num = solution.numIslands(islands);
            assertEquals((int)cases.get(islands), num);
        }
    }

}