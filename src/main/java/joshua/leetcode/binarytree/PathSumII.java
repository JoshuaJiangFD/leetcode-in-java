package joshua.leetcode.binarytree;

import java.util.ArrayList;
import java.util.List;

/**
 * 113 Path Sum II
 * @see <a href="https://leetcode.com/problems/path-sum-ii/">leetcode link</a>
 */
public abstract class PathSumII {

    /**
     * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

     For example:
         Given the below binary tree and sum = 22,
                 5
                / \
               4   8
              /   / \
             11  13  4
            /  \    / \
           7    2  5   1
     return
         [
         [5,4,11,2],
         [5,8,4,5]
         ]

     * @param root
     * @param sum
     * @return
     */
    public abstract List<List<Integer>> pathSum(TreeNode root, int sum);

    /**
     * a variation of problem {@link SumRoottoLeafNumbers.Solution1}
     * But here, we use recursive way.
     */
    public static class Solution extends PathSumII{

        @Override
        public List<List<Integer>> pathSum(TreeNode root, int sum) {
            List<List<Integer>> result = new ArrayList<List<Integer>>();
            if (root == null) {
                return result;
            }
            checkChildNode(root,result,new ArrayList<Integer>(),sum,0);
            return result;
        }

        private void checkChildNode(TreeNode node,List<List<Integer>> results,List<Integer> pathNodes,int sum,int pathSum){
            if(node.left==null&&node.right==null){
                if(pathSum+node.val==sum) {
                    pathNodes.add(node.val);
                    results.add(pathNodes);
                }
                return;
            }
            pathSum+=node.val;
            pathNodes.add(node.val);
            if(node.left!=null){
                checkChildNode(node.left,results,new ArrayList<Integer>(pathNodes),sum,pathSum);
            }
            if(node.right!=null){
                checkChildNode(node.right,results,new ArrayList<Integer>(pathNodes),sum,pathSum);
            }
        }

    }

}
