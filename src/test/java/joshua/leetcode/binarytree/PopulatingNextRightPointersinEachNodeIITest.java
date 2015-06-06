package joshua.leetcode.binarytree;

import static org.junit.Assert.*;
import joshua.leetcode.binarytree.PopulatingNextRightPointersinEachNode.TreeLinkNode;

import org.junit.Before;
import org.junit.Test;

public class PopulatingNextRightPointersinEachNodeIITest {

	TreeLinkNode root;
	
	@Before
	public void setUp(){
		/**
		  * 	 1
		       /  \
		      2    3
		     / \    \
		    4   5    7
		  */
		 root=new TreeLinkNode(1);
		 root.left=new TreeLinkNode(2);
		 root.right=new TreeLinkNode(3);
		 root.left.left=new TreeLinkNode(4);
		 root.left.right=new TreeLinkNode(5);
		 root.right.right=new TreeLinkNode(7);
	}
	
	
	@Test
	public void testSolution1(){
		 PopulatingNextRightPointersinEachNodeII sol=new  PopulatingNextRightPointersinEachNodeII.Solution();
		 sol.connect(root);
		 assertEquals(root.right,root.left.next);
		 assertEquals(null,      root.right.next);
		 assertEquals(root.left.right,root.left.left.next);
		 assertEquals(root.right.right,root.left.right.next);
	}


}
