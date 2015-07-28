package joshua.leetcode.backtracking;

import java.util.*;

/**
 *140	Word Break II
 *
 *@see <a href=" https://leetcode.com/problems/word-break-ii/">leetcode link</a>
 */
public abstract class WordBreak2 {

    /**
     * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence where each word is a valid dictionary word.
     * Return all such possible sentences.

         For example, given
         s = "catsanddog",
         dict = ["cat", "cats", "and", "sand", "dog"].

         A solution is ["cats and dog", "cat sand dog"]

     * @param s
     * @param wordDict
     * @return
     */
    public abstract List<String> wordBreak(String s, Set<String> wordDict);


    /**
     * backtracking & dynamic programming
     */
    static class Solution1 extends WordBreak2{

        @Override
        public List<String> wordBreak(String s, Set<String> wordDict) {
            boolean[] flags=new boolean[s.length()+1];
            List<List<Integer>> tracks=new ArrayList<List<Integer>>();
            for(int i=0;i<flags.length;i++)
            {
                flags[i]=(i==0);
                tracks.add(new LinkedList<Integer>());
            }
            for(int i=1;i<flags.length;i++){
                for(int j=0;j<i;j++){
                    if(flags[j]&&wordDict.contains(s.substring(j, i))){
                        flags[i]=true;
                        tracks.get(i).add(j);
                    }
                }
            }
            //backtracking to get the result
            if(flags[s.length()]==false)
                return new ArrayList<String>();
            Queue<BackCheckItem> queue=new LinkedList<BackCheckItem>();
            queue.add(new BackCheckItem(s.length(),new ArrayList<String>()));
            List<String> finalResult=new LinkedList<String>();
            while(!queue.isEmpty()){
                BackCheckItem item=queue.poll();
                for(int prevIdx: tracks.get(item.idxToCheck)){
                    String word=s.substring(prevIdx,item.idxToCheck);
                    List<String> newList=new LinkedList<String>();
                    newList.addAll(item.parsedStrings);
                    newList.add(word);
                    if(prevIdx!=0)
                        queue.add(new BackCheckItem(prevIdx,newList));
                    else{
                        StringBuilder stringBuilder=new StringBuilder();
                        for(int i=newList.size()-1;i>-1;i--)
                            stringBuilder.append(newList.get(i)+" ");
                        finalResult.add(stringBuilder.toString().trim());
                    }
                }
            }
            return finalResult;
        }

        class BackCheckItem{
            int idxToCheck;
            List<String> parsedStrings=new LinkedList<String>();

            public BackCheckItem(int idxToCheck, List<String> parsedStrings) {
                this.idxToCheck = idxToCheck;
                this.parsedStrings = parsedStrings;
            }
        }
    }
}
