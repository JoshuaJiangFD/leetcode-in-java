package joshua.leetcode.binarytree.traversal;

import java.util.List;

import joshua.leetcode.binarytree.TreeNode;

import org.junit.Test;

public class RightSideViewTest {

	String[] treeStr=new String[]{"1","2","3","#","5","#","4"}; 
		
	@Test
	public void testRightSideView() {
		
		RightSideView sol=new RightSideView.Solution1();
		TreeNode root=TreeNode.DeserializeTreeByLevelOrder(treeStr);
		List<Integer> rightView=sol.rightSideView(root);
		System.out.println(rightView);
		
		
	}

}
