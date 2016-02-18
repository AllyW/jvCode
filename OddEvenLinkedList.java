/*
Given a singly linked list, group all odd nodes together followed by the even nodes. Please note here we are talking about the node number and not the value in the nodes.

You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time complexity.

Example:
Given 1->2->3->4->5->NULL,
return 1->3->5->2->4->NULL.

Note:
The relative order inside both the even and odd groups should remain as it was in the input.
The first node is considered odd, the second node even and so on ... 

*/


public class OddEvenLinkedList {
	public static class ListNode {
		int val;
	    ListNode next;
		public ListNode(int x) { val = x; }
	}

	public static ListNode oddEvenList(ListNode head) {
        if(head==null || head.next == null) return head;
        ListNode odd = head, even_head = head.next, even = head.next;
        while(even!=null && even.next != null){
            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = even_head;
        return head;
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
		node6.next = null;
		System.out.print( "Before: ");
		ListNode curr = head;
		while(curr != null){
			System.out.print( curr.val + " ");
			curr = curr.next;
		}
	    System.out.println("");
		System.out.print("After: ");
		ListNode newHead = oddEvenList(head);
		curr = newHead;
		while(curr != null){
			System.out.print( curr.val + " ");
			curr = curr.next;
		}
		return;
	}	
}
