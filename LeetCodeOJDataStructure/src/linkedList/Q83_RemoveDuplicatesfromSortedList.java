package linkedList;
/*
 * 83. Remove Duplicates from Sorted List
 * Easy
 * Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.
 */

public class Q83_RemoveDuplicatesfromSortedList {

	public static void main(String[] args) {

		ListNode l1= new ListNode(1);
		ListNode l2= new ListNode(2);
		ListNode l3= new ListNode(2);
		ListNode l4= new ListNode(2);
		ListNode l5= new ListNode(2);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		deleteDuplicates1(l1).display();
	}

	public static ListNode deleteDuplicates3(ListNode head) {
        ListNode preHead = new ListNode(-1);
        ListNode prev = preHead;
        ListNode curr = head;
        prev.next = curr;
        while(curr!=null)
        {
            while(curr.next != null && curr.val == curr.next.val)
            {
                curr = curr.next; // find out the last duplicate node
                prev.next = curr; // keep updating prev.next to keep track the last dup node.
            }
            if(prev.next == curr)
            {
                prev = prev.next;
                curr = curr.next;
            }
            else
            {
                curr = curr.next;
            }
        }
        return preHead.next;
    }
	public static ListNode deleteDuplicates(ListNode head) 
	{
		ListNode prev = null;
		ListNode curr = head;
		ListNode next = null;
		while(curr!= null)
		{
			if(prev!=null && next!= null && curr.val==prev.val)
			{
				next = curr.next;
				prev.next = next;
				curr = next;
			}
			else
			{
				next = curr.next;
				prev = curr;
				curr = next;
			}
		}
		return head;
	}
	
	public static ListNode deleteDuplicates1(ListNode head)
	{
		ListNode tmp = head;
		while(tmp!= null)
		{
			if(tmp.next == null)
				break;
			if(tmp.val == tmp.next.val) // do not update tmp to its next.
				tmp.next=tmp.next.next;
			else
				tmp = tmp.next;
		}
		return head;
	}
	
//	recursive method
	public static ListNode deleteDuplicates2(ListNode head)
	{
		if(head == null || head.next == null)
			return head;
		head.next = deleteDuplicates2(head.next);
		return head.val == head.next.val? head.next:head;
	}
	
	
}
