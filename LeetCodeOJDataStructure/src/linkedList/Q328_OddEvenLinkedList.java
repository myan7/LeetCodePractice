package linkedList;
/*
 * 328. Odd Even Linked List
 * Medium
 * Given a singly linked list, group all odd nodes together followed by the even nodes. 
 * Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. 
The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input. 
The first node is considered odd, the second node even and so on ...
 */
public class Q328_OddEvenLinkedList {

	public static void main(String[] args) {

	}
	
	public ListNode oddEvenListAnswer(ListNode head) {
		if(head == null)
			return head;
		
		ListNode odd = head;
	    ListNode EvenHead = head.next;
		ListNode even = EvenHead;
		while(even!= null && even.next!=null)
		{
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = EvenHead;
		return head;	
    }
	
	public static ListNode oddEvenList(ListNode head) 
    {
		if(head == null)
			return head;
		ListNode preOdd = new ListNode(-1);
		preOdd.next = head;
		ListNode odd = preOdd.next;
		ListNode preEven = new ListNode(0);
		preEven.next = head.next;
		ListNode even = preEven.next;
		while(odd.next != null && even.next!=null)
		{
			odd.next = even.next;
			odd = odd.next;
			even.next = odd.next;
			even = even.next;
		}
		odd.next = preEven.next;
		return preOdd.next;	
    }
}
