package joshua.leetcode.linkedlist;

import sun.reflect.generics.reflectiveObjects.NotImplementedException;

/**
 * 234	Palindrome Linked List
 *
 * @see <a href="https://leetcode.com/problems/palindrome-linked-list/">leetcode link</a>
 *
 * Created by joy on 2015/7/12.
 */
public abstract class PalindromeLinkedList {

    /**
     * Given a singly linked list, determine if it is a palindrome
     *
     * Could you do it in O(n) time and O(1) space?
     *
     * @param head
     * @return
     */
    public abstract  boolean isPalindrome(ListNode head);

    static class Solution1 extends PalindromeLinkedList{

        /**
         * two pointers(slow-fast pair) to get the middle of the list.
         * then reverse the right side of the list, so we get two sub lists from the original one.
         * now compare the elements of two lists.
         * if identical, return true, else false.
         * for example, for list 1-->2-->3-->2-->1.
         * get two list 1-->2 and 2-->1, then reverse the right as 1-->2, compare them return true.
         *
         *be ware of the odd and even case of list size.
         * @param head
         * @return
         */
        @Override
        public boolean isPalindrome(ListNode head) {
            if(head==null||head.next==null)
                return true;
            if(head.next.next==null)
                return head.val==head.next.val;
            /*fast-slow pointers to get the middle*/
            ListNode slow=head,fast=head;
            while(fast.next!=null&&fast.next.next!=null)
            {
                slow=slow.next;
                fast=fast.next.next;
            }
            /*reset slow as the starting element of the right half list*/
            slow=slow.next;
            /*reverse the list starting from slow*/
            fast=slow;slow=slow.next;/*fast reused to be the right's head*/
            fast.next=null;/*make sure fast is now the last element of the right half list*/
            while(slow!=null){
                ListNode temp=slow.next;
                slow.next=fast;
                fast=slow;
                slow=temp;
            }
            /*compare two lists*/
            while(fast!=null){
                if(fast.val!=head.val)
                    return false;
                fast=fast.next;
                head=head.next;
            }
            return true;
        }
    }

    static class Solution2 extends PalindromeLinkedList{


        //TODO use stack and two pointers

        /**
         * use stack to store the first half of list in reversed order.
         * then compare the second half and the elements in stack.
         * if identical, return true else false.
         *
         * @param head
         * @return
         */
        @Override
        public boolean isPalindrome(ListNode head) {
            throw new NotImplementedException();
        }
    }
}
