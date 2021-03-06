package linkedList;
/*
 * 24. Swap Nodes in Pairs
 * Medium
 * Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, 
only nodes itself can be changed.
 */
public class Q24_SwapNodesinPairs {

	public static void main(String[] args) {

		ListNode l1= new ListNode(7);
		ListNode l2= new ListNode(2);
		ListNode l3= new ListNode(1);
		ListNode l4= new ListNode(3);
		ListNode l5= new ListNode(5);
		ListNode l6= new ListNode(6);
		ListNode l7= new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l1.display();
		System.out.println();
		swapPairs(l1).display();
	}
	
	public static ListNode swapPairs(ListNode head) 
	{
		ListNode preHead = new ListNode(0);
		preHead.next = head;
		ListNode curr = preHead;
		while(curr.next!=null && curr.next.next != null)
		{
			ListNode first = curr.next;
			ListNode second = curr.next.next;
			
			first.next = second.next;
			curr.next = second;
			curr.next.next = first;
			curr = curr.next.next;
		}
		return preHead.next;
	}

}
