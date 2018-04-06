package lc.q141_q142.LinkedListCycle_I_II;
/*
 * 142. Linked List Cycle II
 * Meidum
 * Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?

See Question 287 find the duplicate number
 */
public class LinkedListCycleII {

	public static void main(String[] args) {

	}
/*
 * Definitions:
Cycle = length of the cycle, if exists.
C is the distance from head to the beginning of Cycle, 
S is the distance of slow pointer from C when slow pointer meets fast pointer.

Distance(slow) = C + S, Distance(fast) = 2 * Distance(slow) = 2 * (C + S). 
To let slow pointer meets fast pointer, 
only if fast pointer run 1 cycle more than slow pointer. 
Distance(fast) - Distance(slow) = Cycle

=> 2 * (C + S) - (C + S)	= Cycle / Fast's distance( = 2* Slow's distance): 2*(C+S) = C+S+Cycle
=>	C + S = Cycle
=>	C = Cycle - S
=> This means if slow pointer runs (Cycle - S) more, it will reaches C. 
So at this time, if there's another point2 running from head
=> After C distance, point2 will meet slow pointer at C, where is the beginning of the cycle.

	
 */
	public ListNode detectCycle(ListNode head) 
	{
        if(head == null)
        	return null;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next!= null && runner.next.next!=null)
        {
        	walker = walker.next;
        	runner = runner.next.next;
        	if(walker == runner)
        	{
        		while(head != walker)
        		{
        			head = head.next;
        			walker = walker.next;
        		}
        		return walker;
        	}
        }
        return null;
    }
}
