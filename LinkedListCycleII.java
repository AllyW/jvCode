/*
 Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

Note: Do not modify the linked list.

Follow up:
Can you solve it without using extra space? 
*/


public class LinkedListCycleII {
	public static class ListNode {
		int val;
	    ListNode next;
		public ListNode(int x) { val = x; }
	}

	public static ListNode detectCycle(ListNode head) {
        if(head== null) return null;
        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                fast = head;
                while(fast != slow){
                    fast = fast.next;
                    slow = slow.next;
                }
                return fast;
            }
        }
        
        return null;
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
		ListNode res = detectCycle(head);
		System.out.println("cycle start node: " + res.val);
		return;
	}	
}
