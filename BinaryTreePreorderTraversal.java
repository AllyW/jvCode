/*
Given a binary tree, return the preorder traversal of its nodes' values.

For example:
Given binary tree {1,#,2,3},

   1
    \
     2
    /
   3

return [1,2,3].

Note: Recursive solution is trivial, could you do it iteratively?
*/


import java.io.*;
import java.util.*;
public class BinaryTreePreorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if(root == null) return res;
        Stack<TreeNode> st = new Stack<TreeNode>();
        while(!st.isEmpty() || root != null){
            while(root != null){
                st.add(root);
                res.add(root.val);
                root = root.left;
            }
            TreeNode a = st.pop();
            root = a.right;
        }
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
		List<Integer> res = preorderTraversal(root);
		System.out.println("Preorder traversal:");
		for(int i = 0; i < res.size() - 1; i++){
			System.out.print(res.get(i) + " -> ");
		}
		System.out.print(res.get(res.size()-1));
		return;
	}	
}
