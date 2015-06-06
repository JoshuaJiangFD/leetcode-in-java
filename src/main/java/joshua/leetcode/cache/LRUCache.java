package joshua.leetcode.cache;

/**
 *146 LRU Cache 
 *
 *@see <a href="https://leetcode.com/problems/lru-cache/">leetcode link</a>
 * 
 *@author joy
 *
 */
public abstract class LRUCache {

	/**
	 * Design and implement a data structure for Least Recently Used (LRU) cache. 
	 * 
	 * It should support the following operations: get and set.
	 * 
	 * @param capacity
	 */
    public LRUCache(int capacity){};
    
    /**
     * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
     * @param key
     * @return
     */
    public abstract int get(int key);
    
    /**
     * set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, 
     * 
     * it should invalidate the least recently used item before inserting a new item.
     * 
     * @param key
     * @param value
     */
    public abstract void set(int key, int value);
	
}
