package linkedList;
/*
 * 203. Remove Linked List Elements
 * Easy
 * Remove all elements from a linked list of integers that have value val.

Example
Given: 1 --> 2 --> 6 --> 3 --> 4 --> 5 --> 6, val = 6
Return: 1 --> 2 --> 3 --> 4 --> 5
 */

public class Q203_RemoveLinkedListElements {

	public static void main(String[] args) {
		ListNode l1 = new ListNode(3);
		ListNode l2 = new ListNode(2);
		ListNode l3 = new ListNode(1);
		ListNode l4 = new ListNode(1);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
		display(removeElements(l1,1));
		
//		tc1  = [1],1  // expected return [] I.E null, I threw out an exception.
//		tc2  = [], 1  // expected return [] I threw out an exception.
//		tc41 Input: [1,1], 1  	Expected: [] Output: [1]   
//		tc44 [1,2,2,1], 2  Expected: [1,1], Output: [1,2,1]
//		[1,2,2,1], 1
//		[1,2,1,2], 2
//		tc45 [1,2,1], 1 NullPointerException
//		[5,4,3,2,1,1],1 NullPointerException
	}
	
	
	// standard answer
	public ListNode removeElements4(ListNode head, int val) {
        ListNode prev = null;
        ListNode curr = head;
        while(curr!=null)
        {
            if(curr.val == val)
            {
                if(prev == null)
                    head = head.next;
                else 
                    prev.next = curr.next;
            }
            else 
                prev = curr;
            curr = curr.next;
        }
        return head;
    }
	//recursive method.
	public ListNode removeElements3(ListNode head, int val) {
        if (head == null) 
        	return null;
        head.next = removeElements(head.next, val);
        return head.val == val ? head.next : head;
    }
	
	public static ListNode removeElements2(ListNode head, int val)
	{
		while(head!= null && head.val ==val)  // first make sure that head is available
		{
			head = head.next;
		}
		if(head == null)
			return head;
		ListNode prev = null;  // we already know that head is available
		ListNode curr = head.next; 
		while(curr != null)
		{
			if(curr.val == val)
			{
				prev.next = curr.next;
				curr = curr.next;
			}
			else
			{
				prev = curr;
				curr = curr.next;
			}
		}
		return head;
	}
	
	
//	0.89%  Lazy delete
	public static ListNode removeElements(ListNode head, int val) 
	{
		while(head!= null && head.val == val)
			head = head.next;
		if((head == null || head.val == val && head.next == null))
            return null;
		
        ListNode curr = head;
		ListNode prev = null;
		while(curr!=null && curr.next !=null)
		{
			if(curr.val == val)
			{
                ListNode tmp = curr.next;
                while(tmp!=null && tmp.val == val)
                    tmp=tmp.next;
                if(tmp == null)
                {
                	prev.next = null;
                	curr = curr.next;
                }else
                {
                	curr.val = tmp.val;
    				curr.next = tmp.next;
    				prev = curr;  // update prev
    				curr = curr.next; // update curr to its next
                }
				
			}
			else
            {
                prev = curr;
                curr = curr.next;
            }
		}
        
		if(curr!=null && curr.val == val) // which means it is the last element
		{	
//			if(prev == null)
//				return null;
//			else
				prev.next = null;
		}
		return head.val==val? head.next:head;  // should also be return head
	}

	public static void display(ListNode node)
	{
		while(node != null)
		{
			System.out.print(node.val+"-->");
			node = node.next;
		}
		System.out.print("null");
	}
	
//	0.89%  Lazy delete
	public ListNode removeElements1(ListNode head, int val) {
        while(head != null && head.val == val)
            head = head.next;
        if((head == null || head.val == val && head.next == null))
            return null;
        ListNode curr = head;
		ListNode prev = null;
		while(curr!=null && curr.next !=null)
		{
			if(curr.val == val)  // find the next node with not val 
			{
                ListNode tmp = curr.next;
                while(tmp!=null && tmp.val == val)
                    tmp=tmp.next;
				if(tmp == null)  // if tmp is the last node.
                {
                	prev.next = null;
                	curr = curr.next;
                }
				else
                {
                	curr.val = tmp.val;
    				curr.next = tmp.next;
    				prev = curr;  // update prev
    				curr = curr.next; // update curr to its next
                }
			}else
            {
                prev = curr;
                curr = curr.next;
            }
                
		}
		if(curr!=null && curr.val == val) // which means it is the last element
			prev.next = null;
		return head;
    }
}
