package joshua.leetcode.binarytree.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
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
	
	
	
	/**
	 * recursive solution.
	 * 
	 * given n=5, then enumerate all the cases of left and right kids, i.e. (0,3),(1,2),(2,1),(3,0).
	 * recursively apply that enumeration until the range is (k,k) or (k,k+1).
	 * 
	 * @author joy
	 *
	 */
	static class Solution1 extends UniqueBinarySearchTrees2{

		@Override
		public List<TreeNode> generateTrees(int n) {
			
			if(n==0){
				List<TreeNode> list=new ArrayList<TreeNode>();
				list.add(null);
				return list;
			}
			return getBST(1,n);
		}
		
		private List<TreeNode> getBST(int start,int end){
			if(start>end)
				return new ArrayList<TreeNode>();
			if(start==end)
				return Arrays.asList(new TreeNode(start));
			if(start+1==end)
			{
				TreeNode t1=new TreeNode(start);
				t1.right=new TreeNode(end);
				TreeNode t2=new TreeNode(end);
				t2.left=new TreeNode(start);
				return Arrays.asList(t1,t2);
			}
			int sentry=start;
			List<TreeNode> result=new LinkedList<TreeNode>();
			while(sentry<=end){
				List<TreeNode> lefts=getBST(start,sentry-1);
				List<TreeNode> rights=getBST(sentry+1,end);
				if(start==sentry){
					for(TreeNode right: rights){
						TreeNode node=new TreeNode(sentry);
						node.right=right;
						result.add(node);
					}
				}else if(sentry==end){
					for(TreeNode left:lefts){
						TreeNode node=new TreeNode(sentry);
						node.left=left;
						result.add(node);
					}
				}else{
					for(TreeNode left:lefts)
						for(TreeNode right:rights){
							TreeNode node=new TreeNode(sentry);
							node.left=left;
							node.right=right;
							result.add(node);
						}
				}
				sentry++;
			}
			return result;
		}
	}
	
	/**
	 * Recursive method has a waste of repeat calculation.
	 * Dynamic programming method instead stores the result for future calculation.
	 * given n, build a n*n matrix.
	 * 
	 * each element(i,j) with i<=j represents the list of Trees with in-order traversal equaling to range (i,...j).
	 * for example element on the diagonal line like (2,2) is single tree with root as 2.
	 * the algorithm only needs to calculate half of the matrix in right-top with i<=j.
	 * and the answer is in element (1,n), the most right top element.
	 *  
	 * @author joy
	 *
	 */
	static class Solution2 extends UniqueBinarySearchTrees2{

		@Override
		@SuppressWarnings("unchecked")
		public List<TreeNode> generateTrees(int n) {
			if(n==0)
			{
				List<TreeNode> lst=new ArrayList<TreeNode>();
				lst.add(null);
				return lst;
			}
			Object[][] matrix=new Object[n][n];
			for(int i=n-1;i>=0;i--){
				for(int j=i;j<n;j++){
					if(i==j){
						matrix[i][j]=Arrays.asList(new TreeNode(i+1));/*index started from 0, while value in TreeNode start from 1 to n.*/
						continue;
					}
					List<TreeNode> result=new ArrayList<TreeNode>();
					for(int k=i;k<=j;k++){
						if(k==i){
							List<TreeNode> rights=(List<TreeNode>)matrix[k+1][j];
							for(TreeNode right:rights)
							{
								TreeNode root=new TreeNode(k+1);
								root.right=right;
								result.add(root);
							}
						}else if(k==j){
							List<TreeNode> lefts=(List<TreeNode>)matrix[i][k-1];
							for(TreeNode left:lefts){
								TreeNode root=new TreeNode(k+1);
								root.left=left;
								result.add(root);
							}
						}else{
							List<TreeNode> lefts=(List<TreeNode>)matrix[i][k-1];
							List<TreeNode> rights=(List<TreeNode>)matrix[k+1][j];
							for(TreeNode left:lefts)
								for(TreeNode right:rights){
									TreeNode root=new TreeNode(k+1);
									root.left=left;
									root.right=right;
									result.add(root);
								}
						}
					}
					matrix[i][j]=result;
				}
			}
			return (List<TreeNode>)(matrix[0][n-1]);
		}
	}
}
