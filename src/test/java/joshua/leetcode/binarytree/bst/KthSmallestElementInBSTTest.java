package joshua.leetcode.binarytree.bst;

import joshua.leetcode.binarytree.TreeNode;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class KthSmallestElementInBSTTest {

    TreeNode root;

    @Before
    public void setUp(){
        root=TreeNode.DeserializeTreeByLevelOrder(new String[]{"3","1","6","#","2","4","#","#","#","#","5"});
    }

    @Test
    public void testSolution1(){
        KthSmallestElementInBST sol=new KthSmallestElementInBST.Solution1();
        assertEquals(1, sol.kthSmallest(root, 1));
        assertEquals(4,sol.kthSmallest(root,4));

    }

}