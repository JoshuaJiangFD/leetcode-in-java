package joshua.leetcode.binarytree;

import joshua.leetcode.testutils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class ConstructBinaryTreefromPreorderandInorderTraversalTest {

    HashMap<List<int[]>,String[]> cases;

    @Before
    public void setUp() throws Exception {
        cases = new HashMap<List<int[]>, String[]>();
//        int[] pre=new int[]{1,2,4,3};
//        int[] in=new int[]{4,2,1,3};
//        String[] result = new String[]{"1","2","3","4"};
        int[] pre = new int[]{1,2,4,5,7,3,6};
        int[] in = new int[]{4,2,5,7,1,3,6};
        String[] result = new String[]{"1","2","3","4","5","#","6","#","#","#","7"};
        cases.put(Arrays.asList(pre, in), result);
    }

    @Test
    public void testSolution1(){
        ConstructBinaryTreefromPreorderandInorderTraversal sol=new ConstructBinaryTreefromPreorderandInorderTraversal.Solution1();
        for (List<int[]> key : cases.keySet()) {
            TreeNode root=sol.buildTree(key.get(0),key.get(1));
            TestUtils.assertArrayEquals(cases.get(key), TreeNode.SerializeTreeByLevelOrder(root));
        }
    }
}