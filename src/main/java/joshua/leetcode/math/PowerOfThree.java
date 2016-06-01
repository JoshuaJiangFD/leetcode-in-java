// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.leetcode.math;

import java.io.PipedWriter;

import joshua.leetcode.solutiontag.Recursive;

/**
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public abstract class PowerOfThree {

    /**
     * Given an integer, write a function to determine if it is a power of three.
     * <p/>
     * Follow up:
     * Could you do it without using any loop / recursion?
     */
    public abstract boolean isPowerOfThree(int n);

    @Recursive
    public static class Solution1 extends PowerOfThree {

        @Override
        public boolean isPowerOfThree(int n) {
            if (n <= 0)
                return false;
            if (n == 1)
                return true;
            return n%3 ==0 && isPowerOfThree(n/3);
        }
    }

}
