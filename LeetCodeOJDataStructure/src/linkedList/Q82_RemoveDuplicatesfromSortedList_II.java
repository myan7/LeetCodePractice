package linkedList;
/*
 * 82. Remove Duplicates from Sorted List II
 * Medium
 * Given a sorted linked list, delete all nodes that have duplicate numbers, 
 * leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.
 */
public class Q82_RemoveDuplicatesfromSortedList_II {

	public static void main(String[] args) {

		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(3);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(4);
		ListNode l7 = new ListNode(5);
		
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		deleteDuplicates(l1).display();
		
//		[1,1] [1,1,2,2] [1,1,2] [1,2,2,3] [1,2,3,3,4,4,5]
	}
	
	 public static ListNode deleteDuplicates(ListNode head) 
	    {
		 ListNode curr = head;
	        ListNode preHead = new ListNode(-1);
	        ListNode prev = preHead;
	        prev.next = curr;  //set preHead.next to head using dummy variables
	        while(curr!=null) // keep update prev and curr to store the distinct node.
	        {
		        while(curr.next!=null &&curr.val == curr.next.val)
			            curr = curr.next;  // find out the last duplicate node;
	            if(prev.next == curr)
	            {
	                prev = prev.next;
	                curr = curr.next;
	            }else
	            {
	                prev.next = curr.next;  
	                // curr is the last dup node, and its next is a different one
	                // I didn't hesitate to update prev, only update prev.next
	                // because I need to find out whether the new prev.next is a distinct node.
	                curr = curr.next;
	            }    
	        }
	        return preHead.next;
	    }
}
