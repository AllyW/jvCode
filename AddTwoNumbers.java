/*

*/


public class AddTwoNumbers {
	public static class ListNode {
		int val;
	    ListNode next;
		public ListNode(int x) { val = x; }
	}

	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int adds = 0;
        ListNode root = new ListNode(0);
        ListNode p = root;
        while(l1 != null || l2!= null){
            int a = 0;
            int b = 0;
            if(l1!= null){
                a = l1.val;
                l1 = l1.next;
            }
            if(l2!= null){
                b = l2.val;
                l2 = l2.next;
            }
            int sum = a + b + adds;
            adds = sum /10;
            p.next = new ListNode(sum%10);
            p = p.next;
        }
        if(adds != 0){
            p.next = new ListNode(adds);
        }
        return root.next;
        
    }

	public static void main(String[] args) {
		ListNode node1 = new ListNode(3);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(7);
		ListNode node4 = new ListNode(1);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(6);
		node1.next = node2;
		node2.next = node3;
		node3.next = null;
		node4.next = node5;
		node5.next = node6;
		node6.next = null;
		System.out.print( "Before: ");
	    System.out.println();
		System.out.print( "List 1: ");
		ListNode curr = node1;
		while(curr != null){
			System.out.print( curr.val + " ");
			curr = curr.next;
		}
	    System.out.println();
		System.out.print( "List 2: ");
		curr = node4;
		while(curr != null){
			System.out.print( curr.val + " ");
			curr = curr.next;
		}
	    System.out.println();
		System.out.print("After: ");
		ListNode newHead = addTwoNumbers(node1, node4);
		curr = newHead;
		while(curr != null){
			System.out.print( curr.val + " ");
			curr = curr.next;
		}
		return;
	}	
}
