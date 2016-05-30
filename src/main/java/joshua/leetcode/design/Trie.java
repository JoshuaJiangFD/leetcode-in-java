package joshua.leetcode.design;

/**
 * 208. Implement Trie (Prefix Tree) <br/>
 * 字典树，或称前缀树 是一种快速查找前缀匹配的数据结构，例如给定一个word list，构建一个前缀树后
 * 可以快速的查找某个word是否在该字典中。
 * <p/>
 * <a href="https://leetcode.com/problems/implement-trie-prefix-tree/">leetcode link</a>
 *
 * @author Joshua.Jiang on 2016/5/30.
 */
public class Trie {

    private TrieNode root;


    public Trie() {
        root = new TrieNode();
    }

    // Inserts a word into the trie.
    public void insert(String word) {
        TrieNode parentNode = root;
        char[] chars = word.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if(parentNode.nodes[ch - 'a'] == null) {
                parentNode.nodes[ch - 'a'] = new TrieNode();
                if (i < chars.length-1) {
                    parentNode.nodes[ch - 'a'].isLeafNode = false;
                }
            }
            if (i == chars.length - 1) {
                parentNode.nodes[ch - 'a'].isLeafNode = true;
            } else {
                parentNode = parentNode.nodes[ch - 'a'];
            }
        }
    }

    // Returns if the word is in the trie.
    public boolean search(String word) {
        TrieNode parentNode = root;
        for(char ch : word.toCharArray()) {
            if (parentNode.nodes[ch - 'a'] == null) {
                return false;
            }
            parentNode = parentNode.nodes[ch - 'a'];
        }
        return parentNode.isLeafNode;
    }

    // Returns if there is any word in the trie
    // that starts with the given prefix.
    public boolean startsWith(String prefix) {
        TrieNode parentNode = root;
        for(char ch : prefix.toCharArray()) {
            if (parentNode.nodes[ch - 'a'] == null) {
                return false;
            }
            parentNode = parentNode.nodes[ch - 'a'];
        }
        return true;
    }
}

class TrieNode {
    /**
     * nodes的下标表示一个字符,例如: nodes[0]不为空，表示存在字符为'a'的子节点
     */
    TrieNode[] nodes = new TrieNode[26];
    boolean isLeafNode = true;

    public TrieNode() {
    }
}