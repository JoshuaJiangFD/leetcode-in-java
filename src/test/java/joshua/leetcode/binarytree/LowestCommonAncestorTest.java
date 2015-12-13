package joshua.leetcode.binarytree;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class LowestCommonAncestorTest {

    TreeNode root;

    @Before
    public void setUp(){
        /**
         *       _______3______
                /              \
              ___5__          ___1__
             /      \        /      \
             6      _2       0       8
                   /  \
         *         7   4
         */
        root=TreeNode.DeserializeTreeByLevelOrder(new String[]{"3","5","1","6","2","0","8","#","#","7","4"});

    }


    @Test
    public void testSolution1(){
        LowestCommonAncestor sol=new LowestCommonAncestor.Solution1();
        assertTrue(sol.lowestCommonAncestor(root,new TreeNode(5),new TreeNode(1)).val==3);/*LCA for 5 and 1 is 3*/
        assertTrue(sol.lowestCommonAncestor(root,new TreeNode(6),new TreeNode(7)).val==5);/*LCA for 6 and 7 is 5*/

    }

    @Test
    public void testSolution2(){
        LowestCommonAncestor sol=new LowestCommonAncestor.Solution2();
        assertTrue(sol.lowestCommonAncestor(root,new TreeNode(5),new TreeNode(1)).val==3);/*LCA for 5 and 1 is 3*/
        assertTrue(sol.lowestCommonAncestor(root,new TreeNode(6),new TreeNode(7)).val==5);/*LCA for 6 and 7 is 5*/

    }
}