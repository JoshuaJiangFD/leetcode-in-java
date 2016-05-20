// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.leetcode.linkedlist;

/**
 * 237. Delete Node in a Linked List<br/>
 * <p/>
 * <a href="https://leetcode.com/problems/delete-node-in-a-linked-list/">leetcod link</a>
 *
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public abstract class DeleteNodeInLinkedList {

    /**
     * Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.
     * <p/>
     * Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3,
     * <p/>
     * the linked list should become 1 -> 2 -> 4 after calling your function.
     *
     * @param node the ndoe to delete from linked list
     */
    public abstract void deleteNode(ListNode node);

    /**
     * 采取复制值，不移动节点连接的方式来间接达到删除节点的结果。
     */
    public static class Solution1 extends DeleteNodeInLinkedList {

        @Override
        public void deleteNode(ListNode node) {
            if (node == null || node.next == null)
                return;
            node.val = node.next.val;
            node.next = node.next.next;
        }
    }
}
