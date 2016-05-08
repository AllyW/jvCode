/*
 Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space? 
*/


public class LinkedListCycle {
	public static class ListNode {
		int val;
	    ListNode next;
		public ListNode(int x) { val = x; }
	}

	public static boolean hasCycle(ListNode head) {
        if(head== null) return false;
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            if(fast == slow) return true;
            slow = slow.next;
            fast = fast.next.next;
        }
        return false;
    }

	public static void main(String[] args) {
		int n = 6;
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node3;
		System.out.print( "Before: ");
		ListNode curr = head;
		int test = 20;
		while(curr != null && test>=0){
			System.out.print( curr.val + " ");
			curr = curr.next;
			test--;
		}
	    System.out.println();
		boolean res = hasCycle(head);
		System.out.println("has cycle: " + res);
		return;
	}	
}
