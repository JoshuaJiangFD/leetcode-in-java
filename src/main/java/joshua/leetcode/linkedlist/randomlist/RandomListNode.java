package joshua.leetcode.linkedlist.randomlist;


/**
 * A linked list is given such that each node contains an additional random pointer 
 * which could point to any node in the list or null.
 * @author joy
 *
 */
public class RandomListNode {

	 int label;
	 RandomListNode next, random;
	 RandomListNode(int x) { this.label = x; }
	 
	 
	@Override
	public String toString() {
		return "RandomListNode [label=" + label + ", next=" + (next!=null?next.label:null)
				+ ", random=" + (random!=null?random.label:null )+ "]";
	}
	 
	public static String  printList(RandomListNode root){
		StringBuilder sBuilder=new StringBuilder();
		RandomListNode cur=root;
		while(cur!=null){
			sBuilder.append(cur.toString()+"\n");
			cur=cur.next;
		}
		return sBuilder.toString();
	}
}
