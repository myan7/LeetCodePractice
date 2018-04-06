package linkedList;

import java.util.ArrayList;

/*
 * 445. Add Two Numbers II
 * Medium
 * You are given two non-empty linked lists representing two non-negative integers. 
 * The most significant digit comes first and each of their nodes contain a single digit. 
 * Add the two numbers and return it as a linked list.

You may assume the two numbers do not contain any leading zero, except the number 0 itself.

Follow up:
What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

Example:

Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 8 -> 0 -> 7
 */
public class Q445_AddTwoNumbersII {

	public static void main(String[] args) {

		ListNode l1= new ListNode(7);
		ListNode l2= new ListNode(2);
		ListNode l3= new ListNode(4);
		ListNode l4= new ListNode(3);
		ListNode l5= new ListNode(5);
		ListNode l6= new ListNode(6);
		ListNode l7= new ListNode(4);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l5.next = l6;
		l6.next = l7;
		addTwoNumbers(l1,l5).display();
//		reverse(l1).display();
		
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) 
	{
		 ListNode curr1 = reverse(l1);
	        ListNode curr2 = reverse(l2);
	        int carry = 0;
	        ListNode temp = curr1;
	        ListNode prev = curr1;
	        while(curr1!= null || curr2 != null || carry != 0){
	            int v1 = curr1 == null? 0: curr1.val;
	            int v2 = curr2 == null? 0: curr2.val;
	            if(curr1 == null){
	                curr1 = new ListNode((v1+v2+carry) % 10);
	                prev.next = curr1;
	            }else{
	                curr1.val = (v1+v2+carry) % 10;
	            }
	            carry = (v1+v2+carry)/10;
	            prev = curr1;
	            curr1 = curr1 == null? null : curr1.next;
	            curr2 = curr2 == null? null : curr2.next;
	        }
	        return reverse(temp);
    }
	
	public static ListNode reverse(ListNode head)
	{
		ListNode curr = head;
		ListNode next = null;
		ListNode prev = null;
		while(curr!=null)
		{
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		return prev;
	}

}
