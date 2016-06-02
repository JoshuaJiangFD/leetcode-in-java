package joshua.leetcode.binarytree.bst;

import static org.junit.Assert.assertEquals;

import java.util.HashMap;

import joshua.leetcode.binarytree.TreeNode;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

public class ValidateBSTTest {

    HashMap<TreeNode, Boolean> testCases;

    @Before
    public void setUp() {
        testCases = new HashMap<TreeNode, Boolean>();
        TreeNode root = TreeNode.DeserializeTreeByLevelOrder(new String[]{"0", "-1"});
        testCases.put(root, true);
        root = TreeNode.DeserializeTreeByLevelOrder(new String[]{"1", "#", "1"});
        testCases.put(root, false);
        root = TreeNode.DeserializeTreeByLevelOrder(new String[]{"0", "1"});
        testCases.put(root, false);
        //10,5,15,#,#,6,20
        root = TreeNode.DeserializeTreeByLevelOrder(new String[]{"10", "5", "15", "#", "#", "6", "20"});
        testCases.put(root, false);
        root = TreeNode.DeserializeTreeByLevelOrder(new String[]{"0", "#", "1"});
        testCases.put(root, true);
        root = TreeNode.DeserializeTreeByLevelOrder(new String[]{"5", "14", "#", "1"});
        testCases.put(root, false);
    }

    @Test
    public void testSolution1() {
        ValidateBST sol = new ValidateBST.Solution1();
        for (TreeNode root : testCases.keySet()) {
            System.out.printf("testing [%s], ", StringUtils.join(TreeNode.SerializeTreeByLevelOrder(root), ","));
            assertEquals(testCases.get(root), sol.isValidBST(root));
            System.out.println("passed.");
        }
    }


    @Test
    public void testSolution2() {
        ValidateBST sol = new ValidateBST.Solution2();
        for (TreeNode root : testCases.keySet()) {
            System.out.printf("testing [%s], ", StringUtils.join(TreeNode.SerializeTreeByLevelOrder(root), ","));
            assertEquals(testCases.get(root), sol.isValidBST(root));
            System.out.println("passed.");
        }
    }



}
