package lc.q21.merge2SortedLists;
/*
 * 21. Merge Two Sorted Lists
 * Merge two sorted linked lists and return it as a new list. 
 * The new list should be made by splicing together the nodes of the first two lists.
 * for example l1 = {1,3,5,7,9}, l2 = {2,4,6,8}
 * newList = {1,2,3,4,5,6,7,8,9}
 * 
 */


public class Merge2SortedLists {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
//	16ms for 208 test cases
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) 
	{

		if(l1 == null)
			return l2;
		else if(l2 == null)
			return l1;
		else
		{
			if(l1.val<l2.val)
	    	{
	    		l1.next = mergeTwoLists(l1.next,l2);
	    		return l1;
	    	}
	    	else
	    	{
	    		l2.next = mergeTwoLists(l1,l2.next);
	    		return l2;
	    	}		
		}
	}
}