package joshua.leetcode.graph;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.*;

public class CourseScheduleTest {


    @Test
    public void testSolution1() {
        CourseSchedule sol = new CourseSchedule.Solution1();
        int[][] prerequisites = new int[][]{{1, 0},{2,0}};//3, [[1,0],[2,0]]
        boolean canSchduled=sol.canFinish(3, prerequisites);
        assertEquals(true,canSchduled);
    }

    @Test
    public void testsolution2(){
        CourseSchedule sol = new CourseSchedule.Solution2();
        int[][] prerequisites = new int[][]{{1, 0},{0,1}};//3, [[1,0],[2,0]]
        boolean canSchduled=sol.canFinish(2, prerequisites);
        assertEquals(false,canSchduled);
    }
}