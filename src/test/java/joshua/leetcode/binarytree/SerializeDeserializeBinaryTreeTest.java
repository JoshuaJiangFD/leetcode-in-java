package joshua.leetcode.binarytree;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class SerializeDeserializeBinaryTreeTest {

    SerializeDeserializeBinaryTree solution;
    SameTree sameTreeChecker = new SameTree.Solution1();

    @Before
    public void setUp () {
        solution = new SerializeDeserializeBinaryTree.Solution1();
    }

    @Test
    public void testSolution() {
        String treeString = "1,2,#,#,3,4,#,#,5,#,#";
        TreeNode root = solution.deserialize(treeString);
        TreeNode expectedRoot = new TreeNode(1);
        expectedRoot.left = new TreeNode(2);
        expectedRoot.right = new TreeNode(3);
        expectedRoot.right.left = new TreeNode(4);
        expectedRoot.right.right = new TreeNode(5);
        assertTrue(sameTreeChecker.isSameTree(root, expectedRoot));
        assertEquals(treeString, solution.serialize(expectedRoot));
    }

}