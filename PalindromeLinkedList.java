/*
Given a singly linked list, determine if it is a palindrome.

Follow up:
Could you do it in O(n) time and O(1) space?

*/


public class PalindromeLinkedList {
	public static class ListNode {
		int val;
	    ListNode next;
		public ListNode(int x) { val = x; }
	}

	public static boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null) return true;
        int L = 0;
        ListNode curr = head;
        while(curr != null){
            L++;
            curr = curr.next;
        }
        curr = head;
        int c =L / 2;
        while(c > 0 ){
            curr = curr.next;
            c--;
        }
        ListNode tail = curr;
		System.out.print( curr.val + " ");
        ListNode pre = null;
        while(tail.next != null){
            ListNode temp = tail.next;
            tail.next = pre;
            pre = tail;

            tail = temp;
			System.out.print( tail.val + " ");
			System.out.print( pre.val + " ");
        }
		tail.next = pre;
		/*
		curr = tail;
		while(curr != null){
			System.out.print( curr.val + " ");
			curr = curr.next;
		}
		*/
		c = L/2;
        while(c > 0){
            if(head.val != tail.val) return false;
            head = head.next;
            tail = tail.next;
            c--;
        }
        return true;
        
    }

	public static void main(String[] args) {
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
		boolean isPal = isPalindrome(head);	
		System.out.print( "Is Palindrome: " + isPal);
		return;
	}	
}
