package linkedList;

/*
 * 142. Linked List Cycle II
 * Medium
 * Given a linked list, return the node where the cycle begins. 
 * If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space?


 */
public class Q142_LinkedListCycle_II {

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
		l5.next = l2;
		System.out.println(detectCycle(l1).val);

	}
	
	public static ListNode detectCycle(ListNode head) 
	{
		ListNode slow = head;
		ListNode fast = head;
		boolean flag = false;
		while(!flag &&fast!=null && fast.next != null)
		{
			slow = slow.next;
			fast = fast.next.next;
			if(slow == fast)
			{
				flag = true;
			}
		}
		if(flag == true)
        {
            slow = head;
			while(slow != fast)
			{
				slow = slow.next;
				fast = fast.next;
			}
        }
		return flag == true? slow: null;
	}

}
