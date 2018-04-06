package lc.q234.PalindromeLinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
 * 234. Palindrome Linked List
 * Easy
 * Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?
 */
public class PalindromeLinkedList {

	public static void main(String[] args) {

//		List<Integer> list = new ArrayList<>();
//		list.add(-3);
//		list.add(5);
//		System.out.println(list);
//		System.out.println(list.size());
//		System.out.println(list.get(0));
//		System.out.println(list.get(1));
		ListNode tc1 = new ListNode(1);
		tc1.next = new ListNode(2);
//		tc1.next.next = new ListNode(2);
//		tc1.next.next.next = new ListNode(1);
		System.out.println(isPalindrome2(tc1));
	}
	
	
//	O(n) complexity and O(1) space
	public static boolean isPalindrome2(ListNode head) {
		if (head == null) return true;
        ListNode curr = head;
        ListNode prev = null;
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) 
        {
            fast = fast.next.next;
            slow = slow.next;  // AKA slow
            curr.next = prev;    // reverse a linked list step 1
            prev = curr;         // reverse a linked list step 2
//          slow = slow.next;  // if you move slow to this line, it will become null
            curr = slow;
        }
        if (fast != null)   // odd number
        {
            slow = slow.next;
        }
        while (prev != null && slow != null) 
        {
            if (prev.val != slow.val) 
                return false;
            prev = prev.next;
            slow = slow.next;
        }
        return true;
    }
	
//	20.69%
	public static boolean isPalindrome1(ListNode head)
	{
/*
 *  1 -> 2 -> 2 -> 1   ===>   1 -> 2 -> 2 -> 1   ===>  1 -> 2 -> 2 -> 1 -> null    even number
 *  sf                             s    f                        s          f
 *  
 *  1 -> 2 -> 1   ===>   1 -> 2 -> 1   ===>  1 -> 2 -> 1    if(fast.next == null) odd number
 *  sf                        s    f              
 */
		List<Integer> list = new ArrayList<>();
		ListNode fast = head;
		ListNode slow = head;
		while(fast != null && fast.next != null)  
		{
            list.add(slow.val);
			slow = slow.next;
			fast = fast.next.next;
		}
        if(list.size() ==0 )
            return true;
        int i = list.size()-1;
		if(fast != null)  //odd number
        {
			while(slow.next!=null)
			{
				if(slow.next.val != list.get(i--))
					return false;
                slow = slow.next;
			}
		}
        else            //even number
		{
			while(slow!=null)
			{
				if(slow.val != list.get(i--))
					return false;
                slow = slow.next;
			}
		}
		return true;
		
		
		
	}
	
//	O(n) complexity and O(n) space  4.83%
	public boolean isPalindrome(ListNode head) 
	{
	        if(head == null)
	            return true;
	        Stack<Integer> st = new Stack<Integer>();
	        ListNode temp = head;
	        while(temp !=null)
	        {
	            st.push(temp.val);
	            temp = temp.next;
	        }
	        while(!st.isEmpty())
	        {
	            if(st.pop()==head.val)
	            {
	                head = head.next;
	            }else
	                return false;
	        }
	        return true;
	}

}
