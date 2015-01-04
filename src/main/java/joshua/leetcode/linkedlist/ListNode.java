package joshua.leetcode.linkedlist;

public class ListNode {
	
	public int val;
	public ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
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
				sBuilder.append("-->");
		}
		return sBuilder.toString();
	}
	
}
