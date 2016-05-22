package joshua.leetcode.design;

import java.util.*;

/**
 * @author Joshua.Jiang on 2016/5/22.
 */
public abstract class NestedIterator implements Iterator<Integer> {

    /**
     * constructor for a NestedIterator
     *
     * @param nestedList the target to iterator on
     */
    public NestedIterator(List<NestedInteger> nestedList) {}

    public static class Solution1 extends NestedIterator {

        /**
         * in java, deque take precedes over Stack class when you want a stack implementation.
         */
        Deque<NestedInteger> stack = new LinkedList<NestedInteger>();

        public Solution1(List<NestedInteger> nestedList) {
            super(nestedList);
            for(int i = nestedList.size() -1 ; i > -1; i--) {
                stack.addLast(nestedList.get(i));
            }
        }

        @Override
        public boolean hasNext() {
            while(!stack.isEmpty()) {
                NestedInteger top = stack.getLast();
                if (top.isInteger()) {
                    return true;
                } else {
                    stack.removeLast();
                    for (int i = top.getList().size() - 1; i > -1; i--) {
                        stack.addLast(top.getList().get(i));
                    }
                }
            }
            return false;
        }

        @Override
        public Integer next() {
            return stack.removeLast().getInteger();
        }

        @Override
        public void remove() {}
    }
}

interface NestedInteger {

    /**
     *
     * @return true if this NestedInteger holds a single integer, rather than a nested list.
     */
    public boolean isInteger();

    /**
     *
     * @return the single integer that this NestedInteger holds, if it holds a single integer
     * Return null if this NestedInteger holds a nested list
     */
    public Integer getInteger();

    /**
     *
     * @return the nested list that this NestedInteger holds, if it holds a nested list,
     * Return null if this NestedInteger holds a single integer
     */
    public List<NestedInteger> getList();
}

class NestedIntegerImpl implements NestedInteger {

    private Integer integer;

    private List<NestedInteger> list;

    public NestedIntegerImpl(Integer integer, NestedInteger[] list) {
        this.integer = integer;
        if (list != null)
            this.list = Arrays.asList(list);
    }

    @Override
    public boolean isInteger() {
        return integer != null;
    }

    @Override
    public Integer getInteger() {
        return integer;
    }

    @Override
    public List<NestedInteger> getList() {
        return list;
    }
}

