package lc.q141_q142.LinkedListCycle_I_II;
/*
 * 141. Linked List Cycle
 * Easy
 * Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?
 */
public class LinkedListCycleI {

	public static void main(String[] args) {

	}
/*
 * Use two pointers, walker and runner.
walker moves step by step. runner moves two steps at time.
if the Linked List has a cycle walker and runner will meet at some
point.
 */
	public static boolean hasCycle(ListNode head) {
		 	if(head==null) 
		 		return false;
		    ListNode walker = head;
		    ListNode runner = head;
		    while(runner.next!=null && runner.next.next!=null) 
		    {
		        walker = walker.next;
		        runner = runner.next.next;
		        if(walker==runner) 
		            return true;
		    }
		    return false;
	}
}
