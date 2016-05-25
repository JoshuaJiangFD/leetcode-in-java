package joshua.algorithm.math;

import java.util.ArrayList;
import java.util.List;

/**
 * 输出前 N 个 质数，质数除1外只能被自身整除。
 *
 *
 * Created by joshu on 2016/5/25.
 */
public abstract class FirstNPrime {

    public abstract List<Long> getFirstNPrime(int n);

    /**
     * 类似 {@link joshua.leetcode.math.CountPrime} 的 方法。
     *  对每个数m，已知 小于m的所有的质数[2,..k,..]，则对于小于m的开方的所有质数，如果都不能整除m，则m也是素数
     *  否则继续对m+1判断。
     */
    public static class Solution1 extends FirstNPrime {

        @Override
        public List<Long> getFirstNPrime(int n) {
            List<Long> primes = new ArrayList<Long>();
            primes.add(2L);
            int count = 1;
            long currentNum = 3;
            while (count < n) {
                int k = 0;
                // get the next prime, count == primes.size()
                while (k < count && primes.get(k) * primes.get(k) <= currentNum) {
                    if (currentNum % primes.get(k) == 0) {
                        k = 0;
                        currentNum +=1;
                    } else {
                        k++;
                    }
                }
                primes.add(currentNum);
                currentNum += 1;
                count++;
            }
            return primes;
        }
    }
}
