package joshua.leetcode.linkedlist;

public class ListNode {

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ListNode listNode = (ListNode) o;

		if (val != listNode.val) return false;
		if (next != null ? !next.equals(listNode.next) : listNode.next != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = val;
		result = 31 * result + (next != null ? next.hashCode() : 0);
		return result;
	}

	public int val;
	public ListNode next;

	public 	ListNode(int x) {
		val = x;
		next = null;
	}

	public ListNode(int val, ListNode next) {
		super();
		this.val = val;
		this.next = next;
	}

	public static ListNode buildList(int[] vals){
		if(vals==null||vals.length==0)
			return null;
		ListNode head=new ListNode(vals[0]);
		ListNode p=head;
		for(int i=1;i<vals.length;i++){
			p.next=new ListNode(vals[i]);
			p=p.next;
		}
		return head;
	}
	
	public String printList(){
		StringBuilder sBuilder=new StringBuilder();
		ListNode p=this;
		Boolean first=true;
		while(p!=null){
			if(first){
				sBuilder.append(p.val);
				first=false;
			}
			else
				sBuilder.append("->"+p.val);
			p=p.next;
		}
		return sBuilder.toString();
	}
	
	
	@Override
	public String toString() {

		return String.format("val:%s, next: %s", val, next==null?"null":next.val);
	}
	
	public  String  outPutList(){
		ListNode head=this;
		StringBuilder sBuilder=new StringBuilder();
		
		while(head!=null){
			sBuilder.append(head.val);
			head=head.next;
			if(head!=null)
				sBuilder.append("->");
		}
		return sBuilder.toString();
	}
	
}
