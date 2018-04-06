package linkedList;
/*
 * 237. Delete Node in a Linked List
 * Easy
 * Write a function to delete a node (except the tail) in a singly linked list, 
 * given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 
and you are given the third node with value 3, 
the linked list should become 1 -> 2 -> 4 after calling your function.
 */
public class Q237_DeleteNodeinaLinkedList 
{
	public static void main(String[] args)
	{
		ListNode l1= new ListNode(1);
		ListNode l2= new ListNode(2);
		ListNode l3= new ListNode(3);
		ListNode l4= new ListNode(4);
		ListNode l5= new ListNode(5);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		
		
	}
//	This is called lazy deleted
	public void deleteNode(ListNode node) 
	{
		node.val = node.next.val;
		node.next = node.next.next;
	}

}


