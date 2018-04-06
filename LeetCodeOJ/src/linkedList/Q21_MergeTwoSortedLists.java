package linkedList;
/*
 * 21. Merge Two Sorted Lists
 * Easy
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 */
public class Q21_MergeTwoSortedLists {

	public static void main(String[] args) {

	}
	
	public ListNode meger2Lists(ListNode l1, ListNode l2)
	{
		if(l1 == null)
			return l2;
		if(l2 == null)
			return l1;
		ListNode prehead = new ListNode(0);
		ListNode curr = prehead;
		while(l1 !=null && l2 != null)
		{
			if(l1.val <l2.val)
			{
				curr.next = l1;
				l1 = l1.next;
			}else {
				curr.next = l2;
				l2 = l2.next;
			}
			curr = curr.next;
		}
		// maybe some nodes are not yet visited because the other list reaches end
		if(l1!= null)
			curr.next = l1;
		if(l2!=null)
			curr.next = l2;
		return prehead.next;
		
	}
	
//	recursive
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
    {
		if(l1 == null)
			return l2;
		else if(l2 ==null)
			return l1;
		else
		{
			if(l1.val>l2.val)
			{
				l2.next = mergeTwoLists(l1,l2.next);
				return l2;
			}
			else
			{
				l1.next = mergeTwoLists(l1.next, l2);
				return l1;
			}
		}
		
    }
}
