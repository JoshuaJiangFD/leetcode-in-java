package joshua.leetcode.design;

import org.junit.Test;

import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void testTrie() {
        Trie trie = new Trie();
//        trie.insert("somestring");
//        assertTrue(trie.startsWith("some"));
//        assertFalse(trie.startsWith("omes"));
//        assertTrue(trie.search("somestring"));
        trie.insert("app");
        trie.insert("apple");
        assertFalse(trie.search("apps"));
        assertTrue(trie.search("app"));
    }

    @Test
    public void testTrie2() {
        Trie trie = new Trie();
        trie.insert("abc");
        assertTrue(trie.search("abc"));
        assertFalse(trie.search("ab"));
        trie.insert("ab");
        assertTrue(trie.search("ab"));
        trie.insert("ab");
        assertTrue(trie.search("ab"));
    }
}