package joshua.leetcode.binarytree;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PostorderTraversalTest {

	PostorderTraversal sol=new PostorderTraversal.Solution1();
	
	String[] nodesStr;
	
	@Test
	public void testPostorderTraversal() {
		nodesStr=new String[]{"1","#","2","3"};
		TreeNode root=TreeNode.DeserializeTreeByLevelOrder(nodesStr);
		List<Integer> res=sol.postorderTraversal(root);
		int[] resArr=new int[res.size()];
		for(int i=0;i<resArr.length;i++)
			resArr[i]=res.get(i);
		assertArrayEquals(new int[]{3,2,1},resArr);
	}

}
