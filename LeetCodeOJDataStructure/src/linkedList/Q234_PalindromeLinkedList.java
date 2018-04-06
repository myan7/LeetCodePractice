package linkedList;
/*
 * 234. Palindrome Linked List
 * Easy
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 * 
 */
public class Q234_PalindromeLinkedList {

	public static void main(String[] args) {

	}

	
	public static boolean isPalindrome(ListNode head) 
	{
		if (head == null) return true;
        // first find out the middle node;
		ListNode slow = head, fast = head,prev = null, next = null;
		while(fast!=null && fast.next!=null)
		{
			next = slow.next;
			fast = fast.next.next;
			slow.next = prev;
			prev = slow;
			slow = next;
		}
		if(fast!=null) // which means fast.next.next = null, which means the total number of nodes is odd
		{
			slow = slow.next;
		}
		while(slow!=null)   //remember slow is now in the middle, 
		{                       //we need to compare it with prev. not fast!!!
			if(prev.val == slow.val)
			{
				prev = prev.next;
				slow = slow.next;
			}
			else
				return false;
		}
		return true;
	}
	
	
}
