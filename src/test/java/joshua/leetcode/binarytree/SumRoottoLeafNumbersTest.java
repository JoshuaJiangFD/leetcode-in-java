package joshua.leetcode.binarytree;

import static org.junit.Assert.*;

import java.util.HashMap;

import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

public class SumRoottoLeafNumbersTest {

	private HashMap<TreeNode,Integer> tests;
	
	@Before
	public void setUp(){
		tests=new HashMap<TreeNode,Integer>();
		TreeNode node=new TreeNode(1);
		node.left=new TreeNode(2);
		node.right=new TreeNode(3);
		tests.put(node, 25);
	}
	
	@Test
	public void testSolution1() {
		SumRoottoLeafNumbers sol=new SumRoottoLeafNumbers.Solution1();
		for(TreeNode root:tests.keySet()){
			System.out.println("testing.."+StringUtils.join(TreeNode.SerializeTreeByLevelOrder(root),","));
			assertEquals((int)tests.get(root),sol.sumNumbers(root));
		}
	}

}
