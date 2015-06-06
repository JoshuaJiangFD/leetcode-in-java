package joshua.leetcode.binarytree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;


/**
 * 129	Sum Root to Leaf Numbers
 * 
 * @see <a href="https://leetcode.com/problems/sum-root-to-leaf-numbers/">leetcode link</a>
 * @author joy
 *
 */
public abstract class SumRoottoLeafNumbers {

	/**
	 * Given a binary tree containing digits from 0-9 only, each root-to-leaf path could represent a number.

		An example is the root-to-leaf path 1->2->3 which represents the number 123.
		
		Find the total sum of all root-to-leaf numbers.
		
		For example,
		
		    1
		   / \
		  2   3
		The root-to-leaf path 1->2 represents the number 12.
		The root-to-leaf path 1->3 represents the number 13.
		
		Return the sum = 12 + 13 = 25.
	 * 
	 * 
	 * @param root
	 * @return
	 */
	public abstract int sumNumbers(TreeNode root);
	
	
	/**
	 * depth first search.
	 * using stack, actually under the Post-order traversal, when visiting the leaf node, the path from root to this 
	 * leaf node is stored in the stack.
	 * 
	 * @author joy
	 *
	 */
	static class Solution1 extends SumRoottoLeafNumbers{

		/*
		 * similar to Post-Order traversal.
		 */
		@Override
		public int sumNumbers(TreeNode root) {
			 if(root==null)
				 return 0;
			 Deque<NodeElement> stack=new ArrayDeque<NodeElement>();
			 stack.add(new NodeElement(root,new ArrayList<Integer>()));
			 int sum=0;
			 while(!stack.isEmpty()){
				 NodeElement top=stack.pop();
				 if(top.node.left==null&&top.node.right==null){
					 int num=0;
					 for(int i=0;i<top.digits.size();i++){
						 num+=Math.pow(10, top.digits.size()-i-1)*top.digits.get(i);
					 }
					 sum+=num;
					 continue;
				 }
				 if(top.node.left!=null)
					 stack.add(new NodeElement(top.node.left,top.digits));
				 if(top.node.right!=null)
					 stack.add(new NodeElement(top.node.right,top.digits));
			 }
			 return sum;
		}
		
		class NodeElement{
			TreeNode node;
			List<Integer> digits;
			
			public NodeElement(TreeNode node,List<Integer> digits){
				this.node=node;
				this.digits=new ArrayList<Integer>(digits);
				this.digits.add(node.val);
			}
		}
	}

}
