package lc.q203.removelinkedlistelements;
/*
 * 203. Remove Linked List Elements
 * Easy
 * 
Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5


 * 
 * 
 */

public class RemoveLinkedListElements {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public static ListNode removeElements(ListNode head, int val) 
	{
		//if head.val is the target val, then head = null;

		while( head != null && head.val == val)
		{
			head = head.next;
		}
		
		if(head == null)
		{
			return head;
		}
		
		ListNode prev = head;
		ListNode curr = head.next;		
		while(curr!=null)
		{
			if(curr.val == val)
			{
				prev.next = curr.next;
				curr = curr.next;
			}else
			{
				prev = prev.next;
				curr = curr.next;
			}
		}
		return head;
				
	}
}


