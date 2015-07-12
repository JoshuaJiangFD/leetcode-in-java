package joshua.leetcode.math;

/**
 * 233	Number of Digit One
 *
 * @see <a href="https://leetcode.com/problems/number-of-digit-one/">233	Number of Digit One</a>
 */
public abstract class NumberOfDigit1 {

    /**
     * Given an integer n, count the total number of digit 1 appearing in all non-negative integers less than or equal to n.

         For example:
         Given n = 13,
         Return 6, because digit 1 occurred in the following numbers: 1, 10, 11, 12, 13.

     * @param n
     * @return
     */
    public abstract int countDigitOne(int n);

    static class Solution1 extends NumberOfDigit1{

        /**
         *take counting number of 1 in hundred-digit for example,  the number on hundred-digit has three cases:0,1,>=2:
         *
         *  case 1: n=3141092, a= 31410, b=92. 计算百位上1的个数应该为 3141 *100 次.
         *  case 2: n=3141192, a= 31411, b=92. 计算百位上1的个数应该为 3141 *100 + (92+1) 次.
         *  case 3: n=3141592, a= 31415, b=92. 计算百位上1的个数应该为 (3141+1) *100 次.
         *
         * 对每个数位，计算1的情况求和。
         *
         * 以上三种情况可以用 一个公式概括:
         * (a + 8) / 10 * m + (a % 10 == 1) * (b + 1)
         * @param n
         * @return
         */
        @Override
        public int countDigitOne(int n) {
            int ones=0;
            for(long m=1;m<=n;m*=10){
                long a=n/m,b=n%m;
                ones+=(a+8)/10*m+((a%10==1)?1*(b+1):0);
            }
            return ones;
        }
    }
}
