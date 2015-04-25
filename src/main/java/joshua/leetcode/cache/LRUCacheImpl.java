package joshua.leetcode.cache;

/**
 * A copy version to {@link java.util.LinkedHashMap LinkedHashMap}.
 * Since java doesn't have pointers or random access based on pointer move.
 * so we still use HashMap-like design to support quick access, and augment it by another header pointer.
 * the header pointers record the element of least accessed and the eldest element.
 *  
 * @Author joy
 *
 */
public class LRUCacheImpl extends LRUCache {

	transient Entry[] table;

	int capacity;

	int size;

	Entry header;

	public LRUCacheImpl(int capacity) {
		super(capacity);
		this.capacity = capacity;
		header = new Entry(-1, -1, -1, null);
		header.after = header.before = header;
		// Find a power of 2 >= initialCapacity
		int capa = 1;
		while (capa < capacity)
			capa <<= 1;
		table = new Entry[capacity];
	}

	/**
	 * 1) find the entry with given key,if not found, return;
	 * 2) remove the entry out from the doubly linked list(but the not hash bucket,namely next field remains unchanged.);
	 * 3) insert it before the header, so that header's "before" field always 
	 */
	@Override
	public int get(int key) {
		// 1.find the entry
		int bucketIndx = key % (table.length);
		Entry value = null;
		for (Entry e = table[bucketIndx]; e != null; e = e.next) {
			int k;
			if (e.hash == bucketIndx && ((k = e.key) == key)) {
				value = e;
				break;
			}
		}
		if (value == null)
			return -1;
		// 2. remove the entry from the doubly linked list
		value.after.before = value.before;
		value.before.after = value.after;
		// 3. insert in before the header.
		value.insertBefore(this.header);
		return value.value;
	}

	/**
	 * 
	 * @param key
	 * @param value
	 */
	@Override
	public void set(int key, int value) {
		// 1.find the entry
		int bucketIndx = key % (table.length);
		Entry exist = null;
		for (Entry e = table[bucketIndx]; e != null; e = e.next) {
			int k;
			if (e!=null&& e.hash == bucketIndx && ((k = e.key) == key)) {
				exist = e;
				break;
			}
		}
		// 2. if not exist, insert the entry.
		if (exist == null) {
			Entry newEntry = new Entry(bucketIndx, key, value,
					table[bucketIndx]);
			size++;
			exist = table[bucketIndx] = newEntry;
		} else {
			/* if exist, update the value and remove from the doubly linked list*/
			exist.value = value;
			exist.before.after = exist.after;
			exist.after.before = exist.before;
		}
		// 3. insert the least accessed entry before the header.
		exist.insertBefore(this.header);
		//4. if size exceeds the capacity,remove the eldest entry.
		if(size>capacity){
			removeEntry(header.after);
			header.after=header.after.after;
			header.after.before=header;
			size--;
		}
	}
	
	private void removeEntry(Entry entry){
		Entry prev=table[entry.hash];
		Entry e=prev;
		while(e!=null){
			Entry en=e.next;
			if(e.key==entry.key){
				  if(prev==e)
					  table[entry.hash]=en;
				  else
					  prev.next=e.next;
				  break;
			}
			prev=e;
			e=en;
		}
	}

	static class Entry {
		int hash;
		int key;
		int value;
		Entry next;/*pointing to next element in the same hash bucket.*/
		Entry after, before;/*use to record access order*/

		public Entry(int hash, int key, int value, Entry next) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
		}

		public Entry(int hash, int key, int value, Entry next, Entry after,
				Entry before) {
			this.hash = hash;
			this.key = key;
			this.value = value;
			this.next = next;
			this.after = after;
			this.before = before;
		}

		public void insertBefore(Entry existingEntry) {
			after = existingEntry;
			before = existingEntry.before;
			before.after = this;
			after.before = this;
		}

		@Override
		public String toString() {
			return "Entry [hash=" + hash + ", key=" + key + ", value=" + value
					+ "]";
		}
		
	}
}
