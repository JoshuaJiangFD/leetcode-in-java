package joshua.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;
import java.util.NoSuchElementException;

/**
 * Implement the following operations of a queue using stacks.

   Notes:
     You must use only standard operations of a stack -- which means only push to top, peek/pop from top, size,
     and is empty operations are valid.

     Depending on your language, stack may not be supported natively.

     You may simulate a stack by using a list or deque (double-ended queue),
     as long as you use only standard operations of a stack.

     You may assume that all operations are valid (for example, no pop or peek operations will be called on an empty queue).

 *
 * Created by joy on 2015/7/12.
 */
public class ImplementQueueUsingStacks {

    /**
     * push operation will go to this stack
     */
    Deque<Integer> inStack=new LinkedList<Integer>();

    /**
     * peek and pop methods will go to this stack. if empty, pour instack's elements inside.
     */
    Deque<Integer> outStack=new LinkedList<Integer>();

    // Push element x to the back of queue.
    public void push(int x) {
        inStack.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!outStack.isEmpty()){
            outStack.pop();
            return;
        }
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        if(!outStack.isEmpty()){
            outStack.pop();
        }
    }

    // Get the front element.
    public int peek() {
        if(!outStack.isEmpty()){
            return outStack.peek();
        }
        while(!inStack.isEmpty()){
            outStack.push(inStack.pop());
        }
        if(!outStack.isEmpty()){
            return outStack.peek();
        }
        throw new NoSuchElementException();
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return inStack.isEmpty()&&outStack.isEmpty();
    }
}
