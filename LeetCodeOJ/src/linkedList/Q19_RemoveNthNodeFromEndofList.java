package linkedList;
/*
 * 19. Remove Nth Node From End of List
 * Medium
 * Given a linked list, remove the nth node from the end of list and return its head.

For example,

   Given linked list: 1->2->3->4->5, and n = 2.

   After removing the second node from the end, the linked list becomes 1->2->3->5.
Note:
Given n will always be valid.
Try to do this in one pass.
 */
public class Q19_RemoveNthNodeFromEndofList {

	public static void main(String[] args) 
	{
		ListNode l1= new ListNode(1);
		ListNode l2= new ListNode(2);
		ListNode l3= new ListNode(3);
		ListNode l4= new ListNode(4);
		ListNode l5= new ListNode(5);
		l1.next = l2;
//		l2.next = l3;
//		l3.next = l4;
//		l4.next = l5;
		removeNthFromEnd(l1,1).display();
		
		// what if [1], 1
		// what if [1,2], 2   should be [2]
		// what if [1,2], 1   should be [1]

	}

	public static ListNode removeNthFromEnd(ListNode head, int n) 
	{
		ListNode preHead = new ListNode(-1);
        ListNode end = head;
        ListNode nth = preHead;
        ListNode prev = preHead;
        prev.next = head;
        int count = 1;
        while(end!=null && count <n)
        {
        	end = end.next;
        	count++;
        }
        if(end == null)
        	return null;
        while(end!=null)
        {
        	prev = nth;
        	end = end.next;
        	nth = nth.next;
        }
        	prev.next = nth.next;
        return preHead.next;
    }
}
