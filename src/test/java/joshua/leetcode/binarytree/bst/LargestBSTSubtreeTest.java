package joshua.leetcode.binarytree.bst;

import static org.junit.Assert.assertEquals;

import joshua.leetcode.binarytree.TreeNode;
import org.junit.Before;
import org.junit.Test;

public class LargestBSTSubtreeTest {

    LargestBSTSubtree solution;

    @Before
    public void setUp() {
        solution = new LargestBSTSubtree.Solution1();
    }

    @Test
    public void testSolution() {
//        TreeNode root1 = TreeNode.DeserializeTreeByLevelOrder(new String[]{"10", "5", "15", "1", "8", "#", "7"});
//        assertEquals(3, solution.largestBSTSubtree(root1));
//        TreeNode root2 = TreeNode.DeserializeTreeByLevelOrder(new String[]{"10", "5", "15", "1", "8", "#", "17"});
//        assertEquals(6, solution.largestBSTSubtree(root2));
        TreeNode root3 = TreeNode.DeserializeTreeByLevelOrder(new String[]{"10", "9", "15", "1", "8", "#", "17"});
        assertEquals(2, solution.largestBSTSubtree(root3));
    }

}