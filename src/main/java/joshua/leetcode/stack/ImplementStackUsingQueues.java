package joshua.leetcode.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 225	Implement Stack using Queues
 *
 * @see <a href="https://leetcode.com/problems/implement-stack-using-queues/">leetcode link</a>
 * <p/>
 * <p/>
 * You must use only standard operations of a queue -- which means only push to back, peek/pop from front, size, and is empty operations are valid.
 * Depending on your language, queue may not be supported natively.
 * <p/>
 * You may simulate a queue by using a list or deque (double-ended queue), as long as you use only standard operations of a queue.
 * <p/>
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 * Created by joy on 2015/7/12.
 */
public class ImplementStackUsingQueues {

    /**
     * queue1 and queue2 will not be non-empty at the same time.
     * when pop() or top(), pour elements from non-empty queue to empty queue and remove or return the last element;
     * when push(), add it to the non-empty queue.
     */
    Queue<Integer> queue1 = new LinkedList<Integer>();

    Queue<Integer> queue2 = new LinkedList<Integer>();


    // Push element x onto stack.
    public void push(int x) {
        if(queue1.isEmpty())
            queue2.add(x);
        else
            queue1.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(queue1.isEmpty()){
            while(!queue2.isEmpty()){
                int val=queue2.poll();
                if(queue2.isEmpty())
                    return;
                queue1.add(val);
            }
        }else if(queue2.isEmpty()){
            while(!queue1.isEmpty()){
                int val=queue1.poll();
                if(queue1.isEmpty())
                    return;
                queue2.add(val);
            }
        }
    }

    // Get the top element.
    public int top() {
        if(queue1.isEmpty()){
            while(!queue2.isEmpty()){
                int val=queue2.poll();
                queue1.add(val);
                if(queue2.isEmpty())
                    return val;
            }
        }else if(queue2.isEmpty()){
            while(!queue1.isEmpty()){
                int val=queue1.poll();
                queue2.add(val);
                if(queue1.isEmpty())
                    return val;
            }
        }
        return 0;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return queue1.isEmpty()&&queue2.isEmpty();
    }
}
