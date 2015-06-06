package joshua.leetcode.binarytree;

import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class PathSumIITest {

    TreeNode root;

    @Before
    public void setUp() {
        String[] strs = new String[]{"5","4","8","11","#","13","4","7","2","#","#","5","1"};
        root = TreeNode.DeserializeTreeByLevelOrder(strs);
    }

    @Test
    public void testSolution1(){
        PathSumII sol=new PathSumII.Solution();
        List<List<Integer>> result=sol.pathSum(root,22);
        for (List<Integer> res : result) {
            System.out.println(res);
        }
    }

}