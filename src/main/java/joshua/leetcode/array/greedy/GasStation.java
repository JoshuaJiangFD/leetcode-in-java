package joshua.leetcode.array.greedy;

/**
 * 134. Gas Station</br>
 * <a href="https://leetcode.com/problems/gas-station/">gas station leetcode link</a><br>
 *
 * Created by Joshua.Jiang on 2016/3/12.
 */
public abstract class GasStation {

    /**
     * There are N gas stations along a circular route, where the amount of gas at station i is gas[i].
     * You have a car with an unlimited gas tank and it costs cost[i] of gas to travel from station i to its next station (i+1).
     * You begin the journey with an empty tank at one of the gas stations.
     * Return the starting gas station's index if you can travel around the circuit once, otherwise return -1.
     * Note:
     *  The solution is guaranteed to be unique.
     * @param gas
     * @param cost
     * @return
     */
    public abstract int canCompleteCircuit(int[] gas, int[] cost);

    /**
     * Greedy Algorithm.[独立完成]
     * 1) 选取一个出发点i，满足 gas[i] > cost[i]
     * 2) 从 i+1 点出发，尽可能的前进，直到剩余gas为负值；
     * 3）在剩余gas为负值的情况下，从start位置往回，重新寻找出发点；
     * 4）判断结束为所走的站点等于length，这时候如果剩余gas大于等于0，则返回start坐标信息；
     */
    public static class Solution1 extends GasStation {

        @Override
        public int canCompleteCircuit(int[] gas, int[] cost) {
            if (gas==null || cost==null || gas.length != cost.length) {
                return -1;
            }
            int length = gas.length;
            int start =0;
            while (start < length && gas[start] < cost[start]) {
                start++;
            }
            if (start == length) {
                return -1;
            }
            int gasLeft = gas[start] - cost[start];
            int end = start + 1;
            int stops = 1;
            while (stops<length) {
                while (stops<length && gasLeft + gas[end % length] >= cost[end % length]) {
                    gasLeft += gas[end % length] - cost[end % length];
                    end++;
                    stops++;
                }
                if (stops == length) {
                    break;
                }
                int temp = gasLeft;
                while ( stops<length && temp <= gasLeft) {
                    start --;
                    stops ++;
                    temp += gas[(start+length) % length] - cost[(start+length) % length];
                }
                gasLeft = temp;
            }
            if (gasLeft >=0 )
                return (start+length) % length;
            return -1;
        }
    }
}
