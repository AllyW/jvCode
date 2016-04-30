/*
 Write a function to delete a node (except the tail) in a singly linked list, given only access to that node.

Supposed the linked list is 1 -> 2 -> 3 -> 4 and you are given the third node with value 3, the linked list should become 1 -> 2 -> 4 after calling your function.
*/


import java.io.*;
import java.util.*;

public class DeleteNodeinaLinkedList {
	//Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static void deleteNode(ListNode node) {
        if(node == null) return;
        if(node.next == null) {
            node = null;
        }
        ListNode cur = node;
        while(cur.next != null && cur.next.next != null){
            cur.val = cur.next.val;
            cur = cur.next;
        }
        cur.val = cur.next.val;
        cur.next = null;
        return;
    }
	
	public static void main(String[] args) { 
		ListNode head = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		ListNode node5 = new ListNode(5);
		ListNode node6 = new ListNode(6);
		ListNode node7 = new ListNode(7);
		head.next = node2;
		node2.next = node3;
		node3.next = node4;
		node4.next = node5;
		node5.next = node6;
		node6.next = node7;
		node7.next = null;
		System.out.print( "List: ");
		ListNode curr = head;
		while(curr != null){
			System.out.print( curr.val + " ");
			curr = curr.next;
		}
	    System.out.println();
		deleteNode(node4);
		curr = head;
		System.out.println("Delete node 4:");
		while(curr != null){
			System.out.print( curr.val + " ");
			curr = curr.next;
		}
	    System.out.println();
		return;
	}	
}
