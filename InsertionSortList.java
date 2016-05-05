/*
Sort a linked list using insertion sort.
*/


import java.io.*;
import java.util.*;

public class InsertionSortList {
	public static class ListNode {
		int val;
		ListNode next;
		public ListNode(int x) { val = x; }
	}

	public static ListNode insertionSortList(ListNode head) {
		if(head == null) return null;
		ListNode res = new ListNode(Integer.MIN_VALUE);
		res.next = head;
		ListNode cur = res;
		while(cur!= null && cur.next != null){
			if(cur.next.val < cur.val){
				ListNode temp = cur.next;
				cur.next = cur.next.next;
				findNode(res, temp);
			}else{
				cur = cur.next;
			}
		}
		return res.next;
	}

	public static void findNode(ListNode res, ListNode cur){
		while(res.next!= null && cur.val > res.next.val){
			res = res.next;
		}
		ListNode t = res.next;
		res.next = cur;
		cur.next = t;
		return;
	}

	public static void main(String[] args) {
		ListNode head = new ListNode(3);
		ListNode node2 = new ListNode(1);
		ListNode node3 = new ListNode(7);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(9);
		ListNode node6 = new ListNode(5);
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
		ListNode newHead = insertionSortList(head);
		curr = newHead;
		while(curr != null){
			System.out.print( curr.val + " ");
			curr = curr.next;
		}
		return;
	}	
}
