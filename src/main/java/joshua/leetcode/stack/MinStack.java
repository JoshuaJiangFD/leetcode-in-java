package joshua.leetcode.stack;

import java.util.Stack;

/**
 * Design a stack that supports push, pop, top,
 * and retrieving the minimum element in constant time.
 * <p/>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * getMin() -- Retrieve the minimum element in the stack.
 *
 * @author joy
 */
public class MinStack {

    /**
     * 实际存储栈中的元素
     */
    private Stack<Integer> mStack = new Stack<Integer>();

    /**
     * minStack to store the minimum values about mStack.
     * each value in mStack means 'I'm now the smallest amongst all current elements in mStack'.
     */
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        mStack.push(x);
        if (minStack.isEmpty()) {
            minStack.push(x);
        } else {
            // 如果新元素比minStack的栈顶元素小，将新元素压入栈中，新元素就是当前mStack所有元素的最小值。
            int top = minStack.peek();
            if (top >= x)
                minStack.push(x);
        }

    }

    public void pop() {
        int top = mStack.pop();
        if (top == minStack.peek())
            minStack.pop();
    }

    public int top() {
        return mStack.peek();
    }

    public int getMin() {
        return minStack.peek();
    }
}
