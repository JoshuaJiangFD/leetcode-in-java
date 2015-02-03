package joshua.leetcode.stack;

import org.junit.Test;

public class MinStackTest {

	@Test
	public void test() {
		MinStack stack=new MinStack();	
		stack.push(0);
		stack.push(1);
		stack.push(0);
		stack.getMin();
		stack.pop();
		stack.getMin();

	}

}
