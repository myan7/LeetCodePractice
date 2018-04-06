package lc.q206_q92.ReverseLinkedList_I_II;
/*
 *  Reverse Linked List II.
 *  Medium
 *  Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.
 */
public class ReverseLinkedList_II {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode ans = reverseBetween(l1, 2,4);
		display(ans);
	}
	
	public ListNode reverseBetween1(ListNode head, int m, int n) {
	    if(head == null) return null;
	    ListNode dummy = new ListNode(0); // create a dummy node to mark the head of this list
	    dummy.next = head;
	    ListNode pre = dummy; // make a pointer pre as a marker for the node before reversing
	    for(int i = 0; i<m-1; i++) pre = pre.next;
	    
	    ListNode start = pre.next; // a pointer to the beginning of a sub-list that will be reversed
	    ListNode then = start.next; // a pointer to a node that will be reversed
	    
	    // 1 - 2 -3 - 4 - 5 ; m=2; n =4 ---> pre = 1, start = 2, then = 3
	    // dummy-> 1 -> 2 -> 3 -> 4 -> 5
	    
	    for(int i=0; i<n-m; i++)
	    {
	        start.next = then.next;
	        then.next = pre.next;
	        pre.next = then;
	        then = start.next;
	    }
	    
	    // first reversing : dummy->1 - 3 - 2 - 4 - 5; pre = 1, start = 2, then = 4
	    // second reversing: dummy->1 - 4 - 3 - 2 - 5; pre = 1, start = 2, then = 5 (finish)
	    
	    return dummy.next;
	    
	}
	
//	7.30%
	public static ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode curr = head;
        ListNode l1 = null;
        ListNode l2 = null;
        ListNode l3 = null;
        ListNode l4 = null;
        int count = 1;
        while(curr!=null)
        {
            if( count == m-1)
                l1 =curr;
            if(count == m)
                l2 = curr;
            if(count == n)
                l3 = curr;
            if(count == n+1)
                l4 = curr;
            curr = curr.next;
            count++;
        }
        if(m-1 == 0)
        {
        	head = recReverseList(l2,l3);
        }
        if(m-1 !=0)
        {
        	l1.next = recReverseList(l2,l3);
        	
        }
        l2.next = l4;
        return head;
        
    }
    
    
	public static ListNode recReverseList(ListNode head, ListNode l2)
	{
		if(head == null || head.next == null || head == l2)
			return head;
		ListNode ans = recReverseList(head.next,l2);
		head.next.next = head;
		head.next = null;
		return ans;
	}
    
    public static void display(ListNode l1)
	{
		while(l1!=null)
		{
			if(l1.next!=null)
			{
				System.out.print(l1.val+"-->");
			}
			else
			{
				System.out.print(l1.val);
			}
			l1 = l1.next;
		}
	}
}
