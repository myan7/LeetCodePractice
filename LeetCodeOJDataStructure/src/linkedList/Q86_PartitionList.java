package linkedList;
/*
 * 86. Partition List
 * Meidum
 * Given a linked list and a value x, partition it such that all nodes less than x 
 * come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.
 */
public class Q86_PartitionList {

	public static void main(String[] args) {

	}
	public ListNode partition(ListNode head, int x) 
	{
		 ListNode dummy1 = new ListNode(-1);
		 ListNode lessTail = dummy1;
		 ListNode dummy2 = new ListNode(-2);
		 ListNode largerTail = dummy2;
		 while(head!=null)
		 {
			 if(head.val<x)
			 {
				 lessTail.next = head;
				 lessTail = head;
			 }else
			 {
				 largerTail.next = head;
				 largerTail = head;
			 }
				head = head.next; 
		 }
		 largerTail.next = null;
		 lessTail.next = dummy2.next;
		 return dummy1.next;
	}

}
