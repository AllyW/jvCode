/*
Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.
*/


import java.io.*;
import java.util.*;

public class ConvertSortedListtoBinarySearchTree {
	//Definition for singly-linked list.
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) { val = x; }
	}

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode slow = head;
        ListNode fast = head.next.next;
        while(fast != null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        TreeNode inNode = new TreeNode(slow.next.val);
        ListNode rhead = slow.next.next;
        slow.next = null;
        if(head!= null){
            inNode.left = sortedListToBST(head);
        }else{
            inNode.left = null;
        }
        inNode.right = sortedListToBST(rhead);
        return inNode;
    }

	public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        q.offer(root);
        while(!q.isEmpty()){
            int s = q.size();
            List<Integer> a = new ArrayList<Integer>();
            for(int i = 0; i < s; i++){
                TreeNode t = q.poll();
                a.add(t.val);
                if(t.left != null) q.offer(t.left);
                if(t.right!= null) q.offer(t.right);
            }
            res.add(a);
        }
        return res;
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
		TreeNode root = sortedListToBST(head);
		List<List<Integer>> res = levelOrder(root);
		System.out.println("The level order:");
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
		return;
	}	
}
