/*
 The thief has found himself a new place for his thievery again. There is only one entrance to this area, called the "root." Besides the root, each house has one and only one parent house. After a tour, the smart thief realized that "all houses in this place forms a binary tree". It will automatically contact the police if two directly-linked houses were broken into on the same night.

Determine the maximum amount of money the thief can rob tonight without alerting the police.

Example 1:

     3
    / \
   2   3
    \   \ 
     3   1

Maximum amount of money the thief can rob = 3 + 3 + 1 = 7.

Example 2:

     3
    / \
   4   5
  / \   \ 
 1   3   1

Maximum amount of money the thief can rob = 4 + 5 = 9. 
*/


import java.io.*;
import java.util.*;
public class HouseRobberIII {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static int rob(TreeNode root) {
        if(root == null) return 0;
        int[] res = dfs(root);
        return res[0] > res[1] ? res[0]: res[1];
    }
    
    public static int[] dfs(TreeNode root){
        if(root == null) return new int[2];
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int res[] = new int[2];
        res[0] = l[1] + r[1] + root.val;
        res[1] = Math.max(l[0], l[1]) + Math.max(r[0], r[1]);
        return res;
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
		int res = rob(root);
		System.out.println("Maximum number is:" + res);
		return;
	}	
}
