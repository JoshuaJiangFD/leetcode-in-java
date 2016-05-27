package joshua.leetcode.array.twopointers;

import joshua.leetcode.solutiontag.TwoPointers;

import java.util.LinkedList;
import java.util.List;

/**
 * 277. Find the Celebrity<br/>
 * <p/>
 * <a href="https://leetcode.com/problems/find-the-celebrity/">leetcode link</a>
 *
 * @author Joshua.Jiang on 2016/5/22.
 */
public abstract class FindCelebrity {

    /**
     * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
     * <p/>
     * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
     * <p/>
     * Now you want to find out who the celebrity is or verify that there is not one.
     * <p/>
     * The only thing you are allowed to do is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B.
     * <p/>
     * You need to find out the celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
     * <p/>
     * You are given a helper function bool knows(a, b) which tells you whether A knows B.
     *
     * Implement a function int findCelebrity(n), your function should minimize the number of calls to knows.
     *
     * @param n the number of persons
     * @return -1 if no celebrity or the label of celebrity
     */
    public abstract int findCelebrity(int n);

    /**
     *
     * @param a
     * @param b
     * @return true if a knows b else false.
     */
    public abstract boolean knows(int a, int b);

    public abstract static class Solution1 extends FindCelebrity {

        @Override
        public int findCelebrity(int n) {
            // the person to search is initially the persons whom person with label 0 knows.
            // the this list must contains celebrity
            List<Integer> personsToSearch = new LinkedList<Integer>();
            for(int i = 0; i < n; i++) {
                personsToSearch.add(i);
            }
            if (personsToSearch.size() == 0) {
                return -1;
            }
            if (personsToSearch.size() == 1) {
                return 0;
            }
            int celebrity = -1;
            //everytime shrink the size of persons to search
            while(true) {
                List<Integer> temp = new LinkedList<Integer>();
                for (int i =1;  i < personsToSearch.size(); i++) {
                    if(knows(personsToSearch.get(0), personsToSearch.get(i))) {
                        temp.add(personsToSearch.get(i));
                    }
                }
                if (temp.size() == 0) {
                    // personsToSearch.get(0) is likely to be a celebrity, 'cause he know no one else in the personToSearch
                    // list
                    celebrity = personsToSearch.get(0);
                    break;
                }
                if (temp.size() == 1) {
                    //  temp.get(0) is likely to be a celebrity, 'cause the first person in personToSearch list only know
                    // this guy
                    celebrity = temp.get(0);
                    break;
                }
                personsToSearch = temp;
            }
            // validate if the celebrity is true
            for (int i = 0; i < n; i++) {
                if (i != celebrity) {
                    if (knows(celebrity, i)) {
                        return -1;
                    }
                    if (!knows(i, celebrity)) {
                        return -1;
                    }
                }
            }
            return celebrity;
        }
    }

    @TwoPointers
    public abstract static  class Solution2 extends FindCelebrity {


        @Override
        public int findCelebrity(int n) {
            int l = 0;
            int r = n -1;
            while ( l < r) {
                if (knows(l, r)) ++l;
                else r--;
            }
            for (int i = 0; i < n; i ++) {
                if (i != l) {
                    if (knows(i, l) || !knows(l, i)) return -1;
                }
            }
            return l;
        }


    }
}
