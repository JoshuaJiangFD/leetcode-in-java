package joshua.leetcode.graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 207 Course Schedule
 *
 * @see <a href="https://leetcode.com/problems/course-schedule/">leetcode link</a>
 */
public abstract class CourseSchedule {


    /**
     * There are a total of n courses you have to take, labeled from 0 to n - 1.
     * <p/>
     * Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]
     * <p/>
     * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
     * <p/>
     * For example:
     * <p/>
     * 2, [[1,0]]
     * There are a total of 2 courses to take. To take course 1 you should have finished course 0. So it is possible.
     * <p/>
     * 2, [[1,0],[0,1]]
     * There are a total of 2 courses to take. To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1. So it is impossible.
     *
     * @param numCourses
     * @param prerequisites int[][2] array.
     * @return
     */
    public abstract boolean canFinish(int numCourses, int[][] prerequisites);


    /**
     * Topological Sort
     * model this as a Topological Sorting on Directed Graph, and if DG can have topological order, then it's a DAG(directed acyclic graph).
     * In this case, if two or more courses are inter-dependent, then there must be more than one cycle in the graph.
     */
    static class Solution1 extends CourseSchedule {

        @Override
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0)
                return true;
            /**
             *  element with index i in the adjacencyList represents all the arcs start from the node at index i.
             *  like index=2, element is {3,0}, means there are two arcs(2,3) and (0,3) in the DAG.
             */
            List<Integer>[] adjacencyList = new List[numCourses];
            int[] inDegress = new int[numCourses];
            boolean[] istaken = new boolean[numCourses];

            /*instantiate adjacent list*/
            for (int i = 0; i < prerequisites.length; i++) {
                if (adjacencyList[prerequisites[i][1]] == null)
                    adjacencyList[prerequisites[i][1]] = new ArrayList<Integer>();/*prerequisites[i][1] is the starting node, and the prerequisite course.*/
                adjacencyList[prerequisites[i][1]].add(prerequisites[i][0]);
                inDegress[prerequisites[i][0]] += 1;
            }
            int cursor = 0, lastCursor = 0;
            while (true) {
                /*find next class to take*/
                if (!istaken[cursor % numCourses] && inDegress[cursor % numCourses] == 0) {
                    istaken[cursor % numCourses] = true;
                    if (adjacencyList[cursor % numCourses] != null) {
                        for (int dependentCourse : adjacencyList[cursor % numCourses]) {
                            inDegress[dependentCourse]--;
                        }
                    }
                    lastCursor = cursor % numCourses;
                    cursor++;
                } else {
                    cursor++;
                }
                if (cursor % numCourses == lastCursor)
                    break;
            }
            /*while exits if all courses are taken or there is a cyclic*/
            for (boolean ele : istaken)
                if (!ele) return false;
            return true;
        }
    }

    /**
     * DFS way.
     * key point: in DAG, if a node is revisited during DFS, it doesn't mean there is a cyclic in it.
     * to correctly detect cyclic by DFS, every node has three states:
     * 0 represents that node is not visited yet;
     * 1 represents that node is visited, but is still searching it's child node, the cursive function hasn't return back:
     * 2 represents that node has been visited and all the nodes reachable from it have been searched;
     * only if DFS visited a node with state 1, then a cyclic existed;
     *
     */
    static class Solution2 extends  CourseSchedule{

        @Override
        public boolean canFinish(int numCourses, int[][] prerequisites) {
            if (prerequisites == null || prerequisites.length == 0 || prerequisites[0] == null || prerequisites[0].length == 0)
                return true;
            /**
             *  element with index i in the adjacencyList represents all the arcs start from the node at index i.
             *  like index=2, element is {3,0}, means there are two arcs(2,3) and (0,3) in the DAG.
             */
            List<Integer>[] adjacencyList = new List[numCourses];
            int[] states=new int[numCourses];/*each node has three states*/
                        /*instantiate adjacent list*/
            for (int i = 0; i < prerequisites.length; i++) {
                if (adjacencyList[prerequisites[i][1]] == null)
                    adjacencyList[prerequisites[i][1]] = new ArrayList<Integer>();/*prerequisites[i][1] is the starting node, and the prerequisite course.*/
                adjacencyList[prerequisites[i][1]].add(prerequisites[i][0]);
            }
            int cursor=0;int lastCursor=0;
            while(true){
                if(states[cursor%numCourses]==0){
                    if(!dfs(adjacencyList,states,cursor))
                        return false;
                    lastCursor=cursor%numCourses;
                }
                cursor++;
                if (cursor % numCourses == lastCursor) {
                    break;
                }
            }
            return true;
        }


        private boolean dfs(List<Integer>[] adjList,int[] states,int curNode){
            states[curNode]=1;
            if(adjList[curNode]!=null){
                for(int dependentCourse:adjList[curNode]){
                    if(states[dependentCourse]==1)
                        return false;/* curnode has pointer to his parent, there is a cyclic*/
                    if(states[dependentCourse]==0)
                        if(!dfs(adjList,states,dependentCourse))
                            return false;
                }
            }
            states[curNode]=2;
            return true;
        }

    }
}
