/*
 Given a binary tree, find the maximum path sum.

For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path does not need to go through the root.

For example:
Given the below binary tree,

       1
      / \
     2   3

Return 6.


*/


import java.io.*;
import java.util.*;
public class BinaryTreeMaximumPathSum {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	private static int res = Integer.MIN_VALUE;
    public static int maxPathSum(TreeNode root) {
        if(root == null) return 0;
        int sum = maxPath(root);
        return sum > res ? sum : res;
    }
    
    public static int maxPath(TreeNode root){
        if(root == null) return 0;
        int l = 0;
        int r = 0;
        l = Math.max(maxPath(root.left), 0);
        r = Math.max(maxPath(root.right), 0);
        res = Math.max(l + r+ root.val, res);
        return l > r? l + root.val: r + root.val;
    }

	public static void main(String[] args) { 
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(3);
		TreeNode node4 = new TreeNode(4);
		TreeNode node5 = new TreeNode(5);
		TreeNode node6 = new TreeNode(6);
		TreeNode node7 = new TreeNode(7);
		TreeNode node8 = new TreeNode(8);
		TreeNode node9 = new TreeNode(9);
		TreeNode node10 = new TreeNode(10);
		TreeNode node11 = new TreeNode(11);
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
		int res = maxPathSum(root);
		System.out.println("Maximum path sum:" + res);
		return;
	}	
}
