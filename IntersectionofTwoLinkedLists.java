/*
Write a program to find the node at which the intersection of two singly linked lists begins.

For example, the following two linked lists:

A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

begin to intersect at node c1.

Notes:

    If the two linked lists have no intersection at all, return null.
    The linked lists must retain their original structure after the function returns.
    You may assume there are no cycles anywhere in the entire linked structure.
    Your code should preferably run in O(n) time and use only O(1) memory.

*/


public class IntersectionofTwoLinkedLists {
	public static class ListNode {
		int val;
	    ListNode next;
		public ListNode(int x) { val = x; }
	}

	public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        int la = lengthOfList(headA);
        int lb = lengthOfList(headB);
        if(la < lb){
            ListNode a = headA;
            headA = headB;
            headB = a;
            int l = lb;
            lb = la;
            la = l;
        }
        while(la > lb){
            headA = headA.next;
            la--;
        }
        while( headA != null && headB != null && headA.val != headB.val){
            headA = headA.next;
            headB = headB.next;
        }
        return (headA== null || headB==null) ? null : headA;
    }

	public static int lengthOfList(ListNode head){
        int res = 0;
        while(head!= null){
            res++;
            head = head.next;
        }
        return res;
    }

	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		headA.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;

		ListNode headB = new ListNode(4);
		ListNode node2b = new ListNode(5);
		ListNode node3b = new ListNode(6);
		headB.next = node2b;
		node2b.next = node3b;
		node3b.next = null;

		System.out.print( "List A: ");
		ListNode curr = headA;
		while(curr != null){
			System.out.print( curr.val + " ");
			curr = curr.next;
		}
	    System.out.println();
		System.out.print("List B: ");
		curr = headB;
		while(curr != null){
			System.out.print( curr.val + " ");
			curr = curr.next;
		}
	    System.out.println();
		ListNode res = getIntersectionNode(headA, headB);
		System.out.print("Intersected node: " + res.val);
		return;
	}	
}
