// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.leetcode.stack;

import java.util.Deque;
import java.util.LinkedList;

import joshua.leetcode.solutiontag.Stacks;

/**
 * 150. Evaluate Reverse Polish Notation<br/>
 * <p/>
 * <a href = "https://leetcode.com/problems/evaluate-reverse-polish-notation/">leetcode link</a>
 *
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public abstract class EvaluateReversePolishNotation {

    /**
     * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
     * <p/>
     * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
     * <p/>
     * Some examples:
     * ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9
     * ["4", "13", "5", "/", "+"] -> (4 + (13 / 5)) -> 6
     */
    public abstract int evalRPN(String[] tokens);

    /**
     * 逆波兰式(Reverse Polish Notation)可以将普通的中缀表达式如 (2 + 1) * 3 转化为
     * 后缀表达式["2", "1", "+", "3", "*"]。后缀表达式在计算机上的效率特别快，主要利用的是栈操作。
     */
    @Stacks
    public static class Solution1 extends EvaluateReversePolishNotation {

        @Override
        public int evalRPN(String[] tokens) {
            if (tokens == null || tokens.length == 0) {
                return 0;
            }
            //in java , Deque is preferable to stack.
            Deque<Integer> stack = new LinkedList<Integer>();
            for (String str : tokens) {
                Operator operator = Operator.parse(str);
                if (operator != null) {
                    int operand1 = stack.pop();
                    int operand2 = stack.pop();
                    stack.push(operator.calculate(operand2, operand1));
                } else {
                    stack.push(Integer.parseInt(str));
                }
            }
            return stack.pop();
        }
    }

    enum Operator {
        ADD("+"),
        SUB("-"),
        MUL("*"),
        DIV("/");

        String signal;

        private Operator(String signal) {
            this.signal = signal;
        }

        public static Operator parse(String str) {
            for (Operator operator : values()) {
                if (operator.signal.equalsIgnoreCase(str)) {
                    return operator;
                }
            }
            return null;
        }

        public int calculate(int operand1, int operand2) {
            switch (this) {
                case ADD:
                    return operand1 + operand2;
                case SUB:
                    return operand1 - operand2;
                case MUL:
                    return operand1 * operand2;
                case DIV:
                    return operand1 / operand2;
                default:
                    throw new RuntimeException("fatal error.");
            }
        }
    }

}
