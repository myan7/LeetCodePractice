package linkedList;
/*
 * Sort a linked list using insertion sort.
 * Medium
 */
public class Q147_InsertionSortList {

	public static void main(String[] args) {
		ListNode l1= new ListNode(4);
		ListNode l2= new ListNode(2);
		ListNode l3= new ListNode(5);
		ListNode l4= new ListNode(1);
		ListNode l5= new ListNode(3);
		l1.next = l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		insertionSortList(l1).display();
	}
	
	

	public static ListNode insertionSortList(ListNode head) 
	{
        ListNode preHead = new ListNode(-1);
//        preHead.next = head;
        ListNode curr = head;
        ListNode prev = preHead;
        ListNode next = null;
        
        
        while(curr!=null)
        {
        	next = curr.next;
			//find the right place to insert
			while( prev.next != null && prev.next.val < curr.val ){
				prev = prev.next;
			}
			//insert between pre and pre.next
			curr.next = prev.next;
			prev.next = curr;
			prev = preHead;
			curr = next;
        }
        
        return preHead.next;
    }
}
