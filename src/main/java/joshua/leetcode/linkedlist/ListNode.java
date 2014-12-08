package joshua.leetcode.linkedlist;

public class ListNode {
	
	int val;
	ListNode next;

	ListNode(int x) {
		val = x;
		next = null;
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
