/*
 Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

    The left subtree of a node contains only nodes with keys less than the node's key.
    The right subtree of a node contains only nodes with keys greater than the node's key.
    Both the left and right subtrees must also be binary search trees.

confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.
*/


import java.io.*;
import java.util.*;
public class ValidateBinarySearchTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static boolean isValidBST(TreeNode root) {
        if(root == null) return true;
        if(root.left == null && root.right==null) return true;
        long L= maxVal(root.left);
        long R = minVal(root.right);
        if(L < root.val && root.val <R){
            return isValidBST(root.left) && isValidBST(root.right);
        }
        return false;
    }
    
    public static long maxVal(TreeNode root){
        long res = Long.MIN_VALUE;
        if(root == null) return res;
        return Math.max(root.val, Math.max(maxVal(root.left), maxVal(root.right)));
    }
    
    public static long minVal(TreeNode root){
        long res = Long.MAX_VALUE;
        if(root == null) return res;
        return Math.min(root.val, Math.min(minVal(root.left), minVal(root.right)));
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
		TreeNode root = new TreeNode(11);
		TreeNode node2 = new TreeNode(6);
		TreeNode node3 = new TreeNode(15);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(9);
		TreeNode node6 = new TreeNode(12);
		TreeNode node7 = new TreeNode(17);
		TreeNode node8 = new TreeNode(1);
		TreeNode node9 = new TreeNode(5);
		TreeNode node10 = new TreeNode(7);
		TreeNode node11 = new TreeNode(10);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		node3.left = node6;
		node3.right = node7;
		node4.left = node8;
		node4.right = node9;
		node5.left = node10;
		node5.right = node11;
		node6.left =  null;
		node6.right = null;
		node7.left = null;
		node7.right = null;
		node8.left = null;
		node8.right = null;
		node9.left = null;
		node9.right = null;
		node10.left = null;
		node10.right = null;
		node11.left = null;
		node11.right = null;
		boolean r = isValidBST(root);
		List<List<Integer>> res = levelOrder(root);
		System.out.println("The level order:");
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
		System.out.println("Valid BST: " + r);
		return;
	}
}
