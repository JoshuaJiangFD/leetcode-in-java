package joshua.leetcode.linkedlist;

import com.google.common.collect.Maps;
import org.junit.Before;
import org.junit.Test;

import java.util.Map;

import static org.junit.Assert.*;

public class OddEvenLinkedListTest {

    private Map<ListNode, ListNode> cases = Maps.newHashMap();

    private OddEvenLinkedList solution;

    @Before
    public void setUp() {
//        ListNode origin = ListNode.buildList(new int[]{1,2,3,4,5});
//        ListNode transferred = ListNode.buildList(new int[]{1,3,5,2,4});
        ListNode origin = ListNode.buildList(new int[]{1, 2});
        ListNode transferred = ListNode.buildList(new int[]{1, 2});
        cases.put(origin, transferred);
    }

    @Test
    public void testSolution1() {
        solution = new OddEvenLinkedList.Solution1();
        for (ListNode param : cases.keySet()) {
            ListNode result = solution.oddEvenList(param);
            assertEquals(cases.get(param), result);
        }
    }

}