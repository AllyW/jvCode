/*
 A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

Return a deep copy of the list. 
*/


import java.io.*;
import java.util.*;

public class CopyListwithRandomPointer {
	//Definition for singly-linked list with a random pointer.
	public static class RandomListNode {
		int label;
		RandomListNode next, random;
		RandomListNode(int x) { this.label = x; }
	};

	public static RandomListNode copyRandomList(RandomListNode head) {
		if(head == null) return null;
		RandomListNode cur = head;
		RandomListNode newHead = new RandomListNode(cur.label);
		HashMap<RandomListNode, RandomListNode> hp = new HashMap<>();
		hp.put(cur, newHead);
		while(cur.next != null){
			cur = cur.next;
			hp.put(cur, new RandomListNode(cur.label));
		}
		cur = head;
		while(cur!= null){
			hp.get(cur).next = hp.get(cur.next);
			hp.get(cur).random = hp.get(cur.random);
			cur = cur.next;
		}
		return hp.get(head);
	}
	
	public static void main(String[] args) { 
		RandomListNode head = new RandomListNode(1);
		RandomListNode node2 = new RandomListNode(2);
		RandomListNode node3 = new RandomListNode(3);
		RandomListNode node4 = new RandomListNode(4);
		RandomListNode node5 = new RandomListNode(5);
		RandomListNode node6 = new RandomListNode(6);
		head.next = node2;
		head.random = node5;
		node2.next = node3;
		node2.random = node3;
		node3.next = node4;
		node3.random = node2;
		node4.next = node5;
		node4.random = node6;
		node5.next = node6;
		node5.random = head;
		node6.next = null;
		node6.random = null;
		System.out.println( "Random list: ");
		RandomListNode curr = head;
		while(curr != null){
			if(curr.random != null){
				System.out.print( "[" + curr.label + ", " + curr.random.label + "] ");
			}else{
				System.out.print( "[" + curr.label + ", null]");
			}
			curr = curr.next;
		}
		System.out.println();
		RandomListNode root = copyRandomList(head);
		System.out.println("The deep copied list:");
		curr = root;
		while(curr != null){
			if(curr.random != null){
				System.out.print( "[" + curr.label + ", " + curr.random.label + "] ");
			}else{
				System.out.print( "[" + curr.label + ", null]");
			}
			curr = curr.next;
		}
		System.out.println();
		return;
	}	
}
