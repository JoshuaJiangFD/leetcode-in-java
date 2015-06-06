package joshua.leetcode.math;

/**
 * 202 Happy Numnber
 *
 *@see <a href="https://leetcode.com/problems/happy-number/">leetcode link</a>
 */
public abstract class HappyNumber {

    /**
     *
     * Write an algorithm to determine if a number is "happy".

     A happy number is a number defined by the following process: Starting with any positive integer,
     replace the number by the sum of the squares of its digits,
     and repeat the process until the number equals 1 (where it will stay),
     or it loops endlessly in a cycle which does not include 1.

     Those numbers for which this process ends in 1 are happy numbers.

         Example: 19 is a happy number

         1^2 + 9^2 = 82
         8^2 + 2^2 = 68
         6^2 + 8^2 = 100
         1^2 + 0^2 + 0^2 = 1
     *
     * @param n
     * @return
     */
    public abstract boolean isHappy(int n);

    /**
     *If n is not happy, then its sequence does not go to 1. Instead, it ends in the cycle:
       4, 16, 37, 58, 89, 145, 42, 20, 4, ...
     To see this fact, first note that if n has m digits, then the sum of the squares of its digits is at most 9^2 m, or 81m.

     For m=4 and above,we always have 81N < 100N < (10^2) * N < 10^N,
     that is Happy(num)<10^N<10^N-1(since we have more than two strictly less than relation whiles.)
     which will eventually reduce the happy sum of any number to smaller or equal to 999,
     because Happy(999999)<99999, Happy(99999) < Happy(9999) Happy(9999)<999.

     so any number over 1000 gets smaller under this process and in particular becomes a number with strictly fewer digits. Once we are under 1000, the number for which the sum of squares of digits is largest is 999, and the result is 3 times 81, that is, 243.

     In the range 100 to 243, the number 199 produces the largest next value, of 163.
     In the range 100 to 163, the number 159 produces the largest next value, of 107.
     In the range 100 to 107, the number 107 produces the largest next value, of 50.
     Considering more precisely the intervals [244,999], [164,243], [108,163] and [100,107],
     we see that every number above 99 gets strictly smaller under this process.
     Thus, no matter what number we start with, we eventually drop below 100.
     An exhaustive search then shows that every number in the interval [1,99] either is happy or goes to the above cycle.


     @see <a href="http://en.wikipedia.org/wiki/Happy_number#Sequence_behavior">wikipedia link</a>
     */
    static class Solution1 extends HappyNumber{

        @Override
        public boolean isHappy(int n) {
             while(n>4){
                 n=sumSqure(n);
             }
             return n==1;
        }
    }

    /**
     * Tortoise and Hare algorithm to detect the cycle.
     */
    static class Solution2 extends HappyNumber{

        @Override
        public boolean isHappy(int n) {
            int x=sumSqure(n), y=sumSqure(x);
            while(x!=1||y!=1)
            {
                if(x==y)
                    return false;
                x=sumSqure(x);
                y=sumSqure(sumSqure(y));
            }
            return true;
        }
    }

    /*
    * calculate 19:  1^2 + 9^2 = 82
    * */
    public static int sumSqure(int x){
        int sum=0;
        do{
            sum+=(x%10)*(x%10);
            x=x/10;
        }while(x!=0);
        return sum;
    }
}
