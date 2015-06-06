package joshua.leetcode.dp;

import joshua.leetcode.array.greedy.JumpGame;

import java.util.Set;

/**
 * 139	Word Break
 *
 * @see <a href="https://leetcode.com/problems/word-break/">leetcode link</a>
 */
public abstract class WordBreak {

    /**
     * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

         For example, given
         s = "leetcode",
         dict = ["leet", "code"].

         Return true because "leetcode" can be segmented as "leet code".
     *
     * @param s
     * @param wordDict
     * @return
     */
    public abstract boolean wordBreak(String s, Set<String> wordDict);


    /**
     * dynamic programming.
     * maintain a bool typed array, each element at index i denotes whether substring(1,i) can be segmented;
     * when calculating index j,
     * scan k from  1 to j-1, if array[k] equals true and word[k,..,j] is in dictionary, then array[k] is true.
     *
     * result at at last index is the result.
     *
     *@see JumpGame.Solution2
     */
    static class Solution1 extends  WordBreak{

        @Override
        public boolean wordBreak(String s, Set<String> wordDict) {
            if(s==null||s.isEmpty())
                return false;
            if(wordDict==null||wordDict.isEmpty())
                return false;
            boolean[] flags=new boolean[s.length()+1];
            flags[0]=true;
            for(int i=1;i<flags.length;i++){
                for(int j=0;j<i;j++){
                    if(flags[j]&&wordDict.contains(s.substring(j, i))){
                        flags[i]=true;
                        break;
                    }
                }
            }
            return flags[flags.length-1];
        }
    }

}
