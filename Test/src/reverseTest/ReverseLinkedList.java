package reverseTest;



public class ReverseLinkedList {

	public static void main(String[] args) {
		ListNode  l1 = new ListNode(1);
		ListNode  l2 = new ListNode(2);
		ListNode  l3 = new ListNode(3);
		ListNode  l4 = new ListNode(4);
		ListNode  l5 = new ListNode(5);
		ListNode  l6 = new ListNode(6);
		ListNode  l7 = new ListNode(7);
		ListNode  l8 = new ListNode(8);
		ListNode  l9 = new ListNode(9);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		l8.next = l9;
		l9.next = null;
		
//		ListNode prev = null;
//		ListNode slow = l1;
//		ListNode fast = l1;
//		ListNode curr = l1;
//		System.out.println(l1.val);
//		curr.next = prev;
//		prev = curr;
//		System.out.println(fast.next);
//		System.out.println(prev.val);
		display(l1);
		ListNode head = recReverse(l1);
		System.out.println();
		display(head);
	}
	
	public static ListNode reverseLinkedList(ListNode l1)
	{
		ListNode curr = l1;
		ListNode prev = null;
		ListNode next = l1;
		while(curr!=null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}
	
	public static void isPalindrome(ListNode l1)
	{
		ListNode node = l1;
        ListNode left = null;
        ListNode right = l1;
        ListNode fast = l1;
        
        while (fast != null && fast.next != null) 
        {
            fast = fast.next.next;
            right = node.next;
            node.next = left;
            left = node;
            node = right;
        }
        
        while(left!=null)  // means odd number
        {
        	System.out.print(left.next.val+ " ");
        	left = left.next;
        }
	}

	public static ListNode recReverse(ListNode l1)
	{
		if(l1 == null || l1.next == null)
			return l1;
		ListNode ans = recReverse(l1.next);
		l1.next.next = l1;
		l1.next = null;
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
