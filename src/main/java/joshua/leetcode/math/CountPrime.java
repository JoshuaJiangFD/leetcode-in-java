// Copyright 2016 Baidu Inc. All rights reserved.

package joshua.leetcode.math;

/**
 * 204. Count Primes<br/>
 * <a href = "https://leetcode.com/problems/count-primes/">leetcode link</a>
 *
 * @author Jiang Yong (jiangyong07@baidu.com)
 */
public abstract class CountPrime {

    /**
     * Count the number of prime numbers less than a non-negative number, n.
     * <p/>
     * Hint:
     * <p/>
     * Let's start with a isPrime function. To determine if a number is prime,
     * we need to check if it is not divisible by any number less than n.
     * <p/>
     * The runtime complexity of isPrime function would be O(n) and hence counting the total prime numbers up to n would be O(n2).
     * <p/>
     * Could we do better?
     * <p/>
     * <p/>
     * Show More Hint
     *
     * @param n
     * @return
     */
    public abstract int countPrimes(int n);

    public static class Solution extends CountPrime {

        @Override
        public int countPrimes(int n) {
            boolean[] notPrime = new boolean[n];
            int count = 0;
            for(int i = 2; i < n; i++) {
                if (!notPrime[i]) {
                    count ++;
                    for (int j = 2; i * j < n; j++) {
                        notPrime[i * j] = true;
                    }
                }
            }
            return count;
        }
    }
}
