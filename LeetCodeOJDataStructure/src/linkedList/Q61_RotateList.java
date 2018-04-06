package linkedList;

import java.util.Iterator;

public class Q61_RotateList {

	public static void main(String[] args) {

		ListNode l1= new ListNode(1);
		ListNode l2= new ListNode(2);
		ListNode l3= new ListNode(3);
		ListNode l4= new ListNode(4);
		ListNode l5= new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		ListNode newHead = rotateRight2(l1,2);
		while(newHead!=null)
		{
			System.out.print(newHead.val+" -->");
			newHead = newHead.next;
		}
		System.out.println("null");
	}
	
	private static ListNode rotateRight2(ListNode head, int k) 
	{
		if (head == null)
			return head;
		
		ListNode copyHead = head;
		
		int len = 1;
		while (copyHead.next != null) {
			copyHead = copyHead.next;
			len++;
		}
		
		copyHead.next = head;
		
		for (int i = len - k % len; i > 1; i--)
			head = head.next;

		copyHead = head.next;
		head.next = null;

		return copyHead;
	}

	public static ListNode rotateRight(ListNode head, int k) 
    {    
		   if(head == null || head.next == null)
	            return head;
	      int len = 1;
	        ListNode newHead = head;
	        ListNode newTail = head;
	        ListNode oldHead = head;
	        ListNode oldTail = head;
	        while(oldTail.next != null)   // find the length of the list
	        {
	            oldTail = oldTail.next;
	            len++;   
	        }
	        
	        k= k>=len?k%len:k; // find out how many nodes I should move
	        
	        if(k==0)
	            return head;
	        
	        ListNode curr = head;
	        while(k>0)
	        {
	           curr = curr.next;
	           k--;
	        }
	        while(curr.next != null)
	        {
	        	newTail = newTail.next;
	        	curr = curr.next;
	        }
	        
	        newHead = newTail.next;
	        oldTail.next = oldHead;
	        newTail.next = null;
	        
	        return newHead;       
    }

}
