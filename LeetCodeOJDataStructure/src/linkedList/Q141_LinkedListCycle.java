package linkedList;
/*
 * 141. Linked List Cycle
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Q141_LinkedListCycle {

	public static void main(String[] args) 
	{
		// TODO Auto-generated method stub

		
	}
// use a slow pointer and a fast pointer.
	public static boolean hasCycle(ListNode head) 
	{
		if(head==null) 
			return false;
	    ListNode walker = head;
	    ListNode runner = head;
	    while(runner.next!=null && runner.next.next!=null) {
	        walker = walker.next; 
	        runner = runner.next.next;
	        if(walker==runner) 
	        	return true;
	    }
	    return false;
    }
	
/*
 * make all the node you visited links to the head ListNode. 
 * once you reach a new ListNode,see whether its next point is the head,
 * if it is, means the node you've already visited,which means the link has a cycle.
 */
	public boolean hasCycle1(ListNode head) {
	      ListNode p = head,pre = head;
	    	while(p != null && p.next != null){
	    		if (p.next == head) return true;
	    		p = p.next;
	    		pre.next = head;
	    		pre = p;
	    	}
	        return false;
	        
	    }
	
}
