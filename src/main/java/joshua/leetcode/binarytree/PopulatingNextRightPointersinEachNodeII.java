package joshua.leetcode.binarytree;

import joshua.leetcode.binarytree.PopulatingNextRightPointersinEachNode.TreeLinkNode;

/**
 * 117	Populating Next Right Pointers in Each Node II
 * 
 * <a href="https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/">leetcode link</a>
 * @author joy
 *
 */
public abstract class PopulatingNextRightPointersinEachNodeII {

	
	/**
	 * Follow up for problem "Populating Next Right Pointers in Each Node".

		What if the given tree could be any binary tree? Would your previous solution still work?
		
		Note:
		
		You may only use constant extra space.
		For example,
		Given the following binary tree,
		
		         1
		       /  \
		      2    3
		     / \    \
		    4   5    7
		    
		After calling your function, the tree should look like:
		
		         1 -> NULL
		       /  \
		      2 -> 3 -> NULL
		     / \    \
		    4-> 5 -> 7 -> NULL
		    
	 * @param root
	 */
	public abstract void connect(TreeLinkNode root);

	/**
	 * actually it's a Level order traversal. every level is actually a linked list.
	 * 
	 * If we know the head node of level L and all the nodes on the same level has been connected,
	 * And we can connect nodes in Level L+1 by traversing the linked list on Level L.
	 * meanwhile, do it level by level until end.
	 * 
	 * @author joy
	 *
	 */
	static class Solution extends PopulatingNextRightPointersinEachNodeII {

		@Override
		public void connect(TreeLinkNode root) {
			 TreeLinkNode head,newHead,cursor,newCursor;
			 if(root==null)
				 return;
			 head=root;
			 while(head!=null){
				 cursor=head;
				 newCursor=null;
				 newHead=null;
				 while(cursor!=null){
					 if(newHead==null){
						 if(cursor.left!=null){
							 newHead=cursor.left;
							 newCursor=newHead;
							 if(cursor.right!=null){
								 cursor.left.next=cursor.right;
								 newCursor=cursor.right;
							 }
						 }else if(cursor.right!=null){
							 newHead=newCursor=cursor.right;
						 }
						 cursor=cursor.next;
						 continue;
					 }
					if(cursor.left!=null){
						newCursor.next=cursor.left;
						if(cursor.right!=null){
							cursor.left.next=cursor.right;
							newCursor=cursor.right;
						}else
							newCursor=cursor.left;
					}else if(cursor.right!=null){
						newCursor.next=cursor.right;
						newCursor=cursor.right;
					}
					cursor=cursor.next;
				 }
				 head=newHead;/*start from next level.*/
			 }
		}

	}

}
