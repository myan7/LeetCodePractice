package linkedList;

/*
 * 206. reverse a singly linked list
 * Easy
 * Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?
 */
public class Q206_ReverseLinkedList {

	public static void main(String[] args) {
		ListNode l1= new ListNode(1);
		ListNode l2= new ListNode(2);
		ListNode l3= new ListNode(3);
		ListNode l4= new ListNode(4);
		ListNode l5= new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		recReverseList1(l1).display();
	}

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
		{
			return head;
		}
		ListNode ans = recReverseList(head.next);
		head.next.next = head;
		head.next = null;
		return ans;
	}
	
	public static ListNode recReverseList1(ListNode head)
	{
		if(head == null || head.next == null) return head;
		else
		{
			ListNode nextNode = head.next;  // store the next node
			head.next = null;               // set curr.next to null
			ListNode rest = recReverseList1(nextNode);   // reverse the rest node
			nextNode.next = head;           // connect the rest back to the first node.
			return rest;                    // rest will be the last node in the list.
		}
	}
}
