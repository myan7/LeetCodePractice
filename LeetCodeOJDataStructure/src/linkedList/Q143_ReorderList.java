package linkedList;
/*
 * 143. Reorder List
 * Medium
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

You must do this in-place without altering the nodes' values.

For example,
Given {1,2,3,4}, reorder it to {1,4,2,3}.


 */
public class Q143_ReorderList {

	public static void main(String[] args) 
	{
		ListNode l1= new ListNode(1);
		ListNode l2= new ListNode(2);
		ListNode l3= new ListNode(3);
		ListNode l4= new ListNode(4);
		ListNode l5= new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		reorderList2(l1);
		l1.display();
	}
	
	private static void reorderList2(ListNode head) 
	{
		if(head == null || head.next == null) return;
		// find the middle node
		ListNode fast = head;
		ListNode slow = head;
		
		while(fast.next != null && fast.next.next != null)
		{
			fast = fast.next.next;
			slow = slow.next;
		}
		// reverse the right half
		ListNode curr = slow.next;
		ListNode prev = null;
		ListNode next = null;
		while(curr != null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		
		// divide the original list into 2 separate lists.
		slow.next = null;
		ListNode left =  head;
		// reorder the list
		while(left != null || prev!= null)
		{
			if(left != null)
			{
				next = left.next;
				left.next = prev;
				left = next;
			}
			
			if(prev !=null)
			{
				next = prev.next;
				prev.next = left;
				prev = next;
			}
		}
	}

	public static void reorderList(ListNode head) 
	{
        if(head == null || head.next == null)
            return;
        ListNode fast = head;
        ListNode slow = head;
        
        // find the middle node  
        while(fast.next!=null && fast.next.next!=null)
        {
            fast = fast.next.next;
            slow = slow.next;
        }
        
        // reverse the right half   1->2->3->4->5->6 to 1->2->3->6->5->4
        ListNode prev = null;
        ListNode curr = slow.next;
        ListNode next = null;
        
        while(curr!=null)
        {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        slow.next = prev;
        
        // reorder the list  1->2->3->6->5->4 to 1->6->2->5->3->4
        ListNode left = head;
        ListNode right = slow.next;
        while(left!=slow)
        {
            slow.next = right.next;
            right.next = left.next;
            left.next = right;
            left = right.next;
            right = slow.next;
        }
    }

}
