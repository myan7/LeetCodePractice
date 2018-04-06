package lc.q206_q92.ReverseLinkedList_I_II;

/*
 * 206. Reverse Linked List
 * Easy
 * Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. 
Could you implement both?


 */

public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
//		display(l1);
//		ListNode newNode = reverseList(l1);
//		System.out.println();
//		display(newNode);
//		System.out.println();
		ListNode recNode = recReverseList(l1);
		display(recNode);
	}
	
	//iterative method
	public static ListNode reverseList(ListNode head) 
	{
        if(head == null)
            return null; 
        ListNode prev = null;
        ListNode curr = head;
        ListNode next = null;
        while(curr!= null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
	
	
	public static ListNode recReverseList(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		ListNode ans = recReverseList(head.next);
		head.next.next = head;
		head.next = null;
		return ans;
	}
	
	
	public static void display(ListNode l1)
	{
		while(l1!=null)
		{
			if(l1.next!=null)
			{
				System.out.print(l1.val+"-->");
			}
			else
			{
				System.out.print(l1.val);
			}
			l1 = l1.next;
		}
	}
	
	
	
	
	
	
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static ListNode recReverseList1(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		ListNode ans = recReverseList(head.next);
		head.next.next = head;
		head.next = null;
		return ans;
	}

}
