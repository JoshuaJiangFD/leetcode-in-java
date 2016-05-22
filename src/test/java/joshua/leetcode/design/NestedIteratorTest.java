
package joshua.leetcode.design;

import com.google.common.collect.Lists;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

public class NestedIteratorTest {

    private NestedIterator solution;

    List<NestedInteger> nestedIntegerList = Lists.newLinkedList();

    @Before
    public void setUp() {
    }

    @Test
    public void test1() {
        nestedIntegerList.add(new NestedIntegerImpl(null, new NestedInteger[]{new NestedIntegerImpl(1, null),
                new NestedIntegerImpl(1, null)}));
        nestedIntegerList.add(new NestedIntegerImpl(2, null));
        nestedIntegerList.add(new NestedIntegerImpl(null, new NestedInteger[]{new NestedIntegerImpl(1, null),
                new NestedIntegerImpl(1, null)}));
        solution = new NestedIterator.Solution1(nestedIntegerList);

        List<Integer> flattenList = new LinkedList<Integer>();
        while(solution.hasNext()) {
            flattenList.add(solution.next());
        }
        assertEquals(Lists.newArrayList(1,1,2,1,1),flattenList);
    }

    @Test
    public void test2() {
        List<NestedInteger> nestedIntegerList = Lists.newLinkedList();
        nestedIntegerList.add(new NestedIntegerImpl(1, null));
        nestedIntegerList.add(new NestedIntegerImpl(null, new NestedInteger[]{new NestedIntegerImpl(4, null),
                new NestedIntegerImpl(null, new NestedInteger[]{new NestedIntegerImpl(6,null)})}));

        solution = new NestedIterator.Solution1(nestedIntegerList);

        List<Integer> flattenList = new LinkedList<Integer>();
        while(solution.hasNext()) {
            flattenList.add(solution.next());
        }
        assertEquals(Lists.newArrayList(1,4,6),flattenList);
    }
}