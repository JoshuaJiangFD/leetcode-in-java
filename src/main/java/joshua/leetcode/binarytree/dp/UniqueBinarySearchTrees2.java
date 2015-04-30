package joshua.leetcode.binarytree.dp;

import java.util.List;

import joshua.leetcode.binarytree.TreeNode;

/**
 * 95	Unique Binary Search Trees II
 * 
 * @see  <a href="https://leetcode.com/problems/unique-binary-search-trees-ii/">leetcode link</a>
 * @author joy
 *
 */
public abstract class UniqueBinarySearchTrees2 {

	/**
	 * Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

		For example,
		Given n = 3, your program should return all 5 unique BST's shown below.
		
		   1         3     3      2      1
		    \       /     /      / \      \
		     3     2     1      1   3      2
		    /     /       \                 \
		   2     1         2                 3
		   
		   
	 * @param n
	 * @return
	 */
	public abstract List<TreeNode> generateTrees(int n);
	
}
