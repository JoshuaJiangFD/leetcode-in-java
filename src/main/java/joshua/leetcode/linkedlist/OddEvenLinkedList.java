package joshua.leetcode.linkedlist;

/**
 * 328. Odd Even Linked List<br/>
 *
 * <a href="https://leetcode.com/problems/odd-even-linked-list/">leetcode link</a>
 *
 * @author Joshua.Jiang on 2016/5/22.
 */
public abstract class OddEvenLinkedList {

    public abstract ListNode oddEvenList(ListNode head);

    public static class Solution1 extends OddEvenLinkedList {

        @Override
        public ListNode oddEvenList(ListNode head) {
            if (head == null) {
                return head;
            }
            ListNode lastOddNode = head;
            while (lastOddNode.next != null && lastOddNode.next.next != null) {
                lastOddNode = lastOddNode.next.next;
            }
            ListNode nextOddNode = head;
            ListNode posToInsert = lastOddNode;
            while(nextOddNode != lastOddNode) {
                ListNode evenNodeToMove = nextOddNode.next;
                nextOddNode.next = nextOddNode.next.next;
                nextOddNode = nextOddNode.next;
                evenNodeToMove.next = posToInsert.next;
                posToInsert.next = evenNodeToMove;
                posToInsert = evenNodeToMove;
            }
            return head;
        }
    }
}
