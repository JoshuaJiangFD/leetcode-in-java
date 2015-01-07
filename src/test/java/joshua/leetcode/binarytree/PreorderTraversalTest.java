package joshua.leetcode.binarytree;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

public class PreorderTraversalTest {
	
	private String[] nodesStr;
	
	@Test
	public void testPreorderTraversal() {
		PreorderTraversal sol=new PreorderTraversal.Solution1();
		nodesStr=new String[]{"1","#","2","3"};
		TreeNode root=TreeNode.DeserializeTreeByLevelOrder(nodesStr);
		List<Integer> res=sol.preorderTraversal(root);
		int[] resArr=new int[res.size()];
		for(int i=0;i<resArr.length;i++)
			resArr[i]=res.get(i);
		assertArrayEquals(new int[]{1,2,3},resArr);
	}

}
