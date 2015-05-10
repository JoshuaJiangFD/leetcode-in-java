package joshua.leetcode.dp;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

/**
 * Longest Valid Parentheses
 * <p/>
 * <a href="https://leetcode.com/problems/longest-valid-parentheses/">leetcode link</a>
 */
public abstract class LongestValidParentheses {

    /**
     * Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.
     * <p/>
     * For "(()", the longest valid parentheses substring is "()", which has length = 2.
     * <p/>
     * Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.
     *
     * @param s
     * @return
     */
    public abstract int longestValidParentheses(String s);

    /**
     *Solution1: forward and backward  algorithm.
     *
     *take "()(()" for example:
     * scan from left to right, firstly count number of '(', every time encounter ')' then decrease number of '('.
     * when number of '(' is 0 or we reach the end, we got a sequence like "()(()", then we need to look backwards by counting the number of ')' and split the sequence if necessary.
     * in this example, we actually find the longest valid parentheses is "()" and "()", we update the max if necessary, this case is 1.
     *
     */
    static class Solution1 extends LongestValidParentheses {

        @Override
        public int longestValidParentheses(String s) {
            if (s == null)
                return 0;
            int max = 0, numOfLeftBracket = 0,tempStart = -1;
            int endFromBack,numOfRightBrackets,temMax2,temMax3;
            for (int i = 0; i <= s.length(); i++) {
                char ch = i==s.length()?')':s.charAt(i);
                if (ch == '(') {
                    if (tempStart == -1) {
                        tempStart = i;
                    }
                    numOfLeftBracket++;
                    continue;
                }
                if (numOfLeftBracket == 0||i==s.length()) {
                    if (tempStart == -1)
                        continue;
                    /*now we have interval (tempStart, i), which "has" valid parentheses as tempMax, but need to be validated from tail to head by checking ")" */
                    endFromBack = i==s.length()?s.length()-1:i;
                    numOfRightBrackets = 0;
                    temMax2 = 0;
                    temMax3=0;
                    while (endFromBack >= tempStart-1) {
                        char cha = endFromBack == tempStart-1?'(':s.charAt(endFromBack);
                        if (cha == ')') {
                            numOfRightBrackets++;
                        } else {
                            if (numOfRightBrackets == 0||endFromBack==tempStart-1){
                                temMax3=Math.max(temMax3,temMax2);
                                temMax2=0;
                            }else{
                                numOfRightBrackets--;
                                temMax2++;
                            }
                        }
                        endFromBack--;
                    }
                    max = Math.max(max,temMax3);
                    tempStart=-1;
                } else {
                    numOfLeftBracket--;
                }
            }
            return max * 2;
        }
    }

    /**
     * use stack.
     *
     *@see <a href="https://leetcode.com/discuss/32229/explaining-solution-using-stack">leetcode link</a>
     */
    static class Solution2 extends LongestValidParentheses{

        /**
         * for example "()((())".
         * 1) push '0,(', left=-1;
         * 2) pop '0,(', stack is empty, update max=(1-(-1))=2, left=-1;
         * 3) push '2,(';
         * 4) push '3,(';
         * 5) push '4,(';
         * 6) pop '4,(', stack is not empty, top in stack is '3,(', 4-3=1, don't update max;
         * 7) pop '3,(', stack is not empty, top in stack is '2,(', 6-2=4, update max as 4;
         * return max as 4;
         * @param s
         * @return
         */
        @Override
        public int longestValidParentheses(String s) {
            int left=-1,max=0;
            Deque<Integer> stack = new ArrayDeque<Integer>();
            for (int i = 0; i < s.length(); i++) {
                if(s.charAt(i)=='(')
                    stack.push(i);
                else{
                    if(stack.isEmpty())
                        left=i;
                    else{
                        stack.pop();
                        if(stack.isEmpty()) max = Math.max(max, i - left);
                        else
                            max=Math.max(max,i-stack.peek());
                    }
                }
            }
            return max;
        }
    }

    /**
     * dynamic programming.
     *
     * @see <a href="https://leetcode.com/discuss/24045/simple-java-solution">leetcode explanation</a>
     * @see <a href="./src/main/resources/LongestValidParentheses.jpg">example</a>
     */
    static class Solution3 extends LongestValidParentheses{

        @Override
        public int longestValidParentheses(String s) {
            char[] S = s.toCharArray();
            int[] V = new int[S.length];
            int open = 0;
            int max = 0;
            for (int i=0; i<S.length; i++) {
                if (S[i] == '(') open++;
                if (S[i] == ')' && open > 0) {
                    V[i] = 2 + V[i-1];
                    if(i-V[i] >= 0) {
                        V[i] += V[i-V[i]];
                    }
                    open--;
                }
                if (V[i] > max) max = V[i];
            }
            return max;
        }
    }
}
