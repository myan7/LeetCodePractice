package lc.q160.IntersectionofTwoLinkedLists;
/*
 * 160. Intersection of Two Linked Lists
 * Easy
 * Write a program to find the node at which the intersection of two singly linked lists begins.


For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3
begin to intersect at node c1.


Notes:

If the two linked lists have no intersection at all, return null.
The linked lists must retain their original structure after the function returns.
You may assume there are no cycles anywhere in the entire linked structure.
Your code should preferably run in O(n) time and use only O(1) memory.
 */

public class IntersectionofTwoLinkedLists {

	public static void main(String[] args) {

	}
//	32.20%	
	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;
        if(headA == null || headB == null)
            return null;
        while(curA != curB)
        {
            curA = curA==null? headB:curA.next;
            curB = curB==null? headA:curB.next;
        }
        return curA;
    }
	
//	32.20%
	public static ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
	    int lenA = getlength(headA), lenB = getlength(headB);
	    // move headA and headB to the same start point
	    while (lenA > lenB) {
	        headA = headA.next;
	        lenA--;
	    }
	    while (lenA < lenB) {
	        headB = headB.next;
	        lenB--;
	    }
	    // find the intersection until end
	    while (headA != headB) {
	        headA = headA.next;
	        headB = headB.next;
	    }
	    return headA;
	}

	private static int getlength(ListNode node) {
	    int length = 0;
	    while (node != null) {
	        node = node.next;
	        length++;
	    }
	    return length;
	}

}
