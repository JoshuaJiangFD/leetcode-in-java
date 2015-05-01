package joshua.leetcode.binarytree.dp;

import java.util.List;

import joshua.leetcode.binarytree.TreeNode;

import org.apache.commons.lang3.StringUtils;
import org.junit.Test;

public class UniqueBinarySearchTrees2Test {

	@Test
	public void testSolution1() {
		UniqueBinarySearchTrees2 sol=new UniqueBinarySearchTrees2.Solution1();
//		System.out.println("result of 2");
//		printResult(sol.generateTrees(2));
		System.out.println("result of 3");
		printResult(sol.generateTrees(3));
		System.out.println("result of 4");
		printResult(sol.generateTrees(4));
		System.out.println("result of 5");
		printResult(sol.generateTrees(5));
	}
	
	@Test
	public void testSolution2(){
		UniqueBinarySearchTrees2 sol=new UniqueBinarySearchTrees2.Solution2();
		System.out.println("result of 1");
		printResult(sol.generateTrees(1));
		System.out.println("result of 3");
		printResult(sol.generateTrees(3));
		System.out.println("result of 4");
		printResult(sol.generateTrees(4));
		System.out.println("result of 5");
		printResult(sol.generateTrees(5));
	}
	
	private void printResult(List<TreeNode> result){
		for(TreeNode root:result){
			System.out.println(StringUtils.join(TreeNode.SerializeTreeByLevelOrder(root),","));
		}
	}

}
