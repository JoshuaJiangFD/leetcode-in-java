package joshua.leetcode.binarytree;

import joshua.leetcode.testutils.TestUtils;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.junit.Assert.*;

public class ConstructBinaryTreefromInorderandPostorderTraversalTest {

    HashMap<List<int[]>,String[]> cases;

    @Before
    public void setUp() throws Exception {
        cases = new HashMap<List<int[]>, String[]>();
        int[] pre=new int[]{2,1};
        int[] post=new int[]{2,1};
        String[] result = new String[]{"1","2"};
//        int[] pre=new int[]{1,2,4,3};
//        int[] post=new int[]{4,2,3,1};
//        String[] result = new String[]{"1","2","3","4"};
//        int[] pre = new int[]{1,2,4,5,7,3,6};
//        int[] post = new int[]{4,2,5,7,1,3,6};
//        String[] result = new String[]{"1","2","3","4","5","#","6","#","#","#","7"};
        cases.put(Arrays.asList(pre, post), result);
    }

    @Test
    public void testBuildTree() throws Exception {
        ConstructBinaryTreefromInorderandPostorderTraversal sol=new ConstructBinaryTreefromInorderandPostorderTraversal.Solution();
        for (List<int[]> key : cases.keySet()) {
            TreeNode root=sol.buildTree(key.get(0),key.get(1));
            TestUtils.assertArrayEquals(cases.get(key), TreeNode.SerializeTreeByLevelOrder(root));
        }
    }
}