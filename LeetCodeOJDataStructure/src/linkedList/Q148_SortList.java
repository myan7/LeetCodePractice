package linkedList;
/*
 * 148. Sort List
 * Medium
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 */
public class Q148_SortList {

	public static void main(String[] args) 
	{
		ListNode l1 = new ListNode(2);
		ListNode l2 = new ListNode(3);
		ListNode l3 = new ListNode(5);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(1);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
//		l5.next = l2;
		sortList(l1).display();;
		
	}

	public static ListNode sortList(ListNode head) 
	{
		ListNode prehead = new ListNode(0);
		ListNode curr = head;
		prehead.next = curr;
		ListNode next = null;
		ListNode prev = prehead;
		while(curr!= null && curr.next!=null)
		{
			next = curr.next;
			if(curr.val<prehead.next.val)
			{
				prehead.next = curr;
				curr.next = prev;
				prev.next = next;
				curr = next;
			}else
			{
				prev = curr;
				curr = next;
			}
		}
		return prehead.next;
    }
}
