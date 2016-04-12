/*
Implement an iterator over a binary search tree (BST). Your iterator will be initialized with the root node of a BST.

Calling next() will return the next smallest number in the BST.

Note: next() and hasNext() should run in average O(1) time and uses O(h) memory, where h is the height of the tree. 
*/


import java.io.*;
import java.util.*;
public class BinarySearchTreeIterator {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static class BSTIterator {
	    public Stack<TreeNode> st = new Stack<TreeNode>();
	    public BSTIterator(TreeNode root) {
		    while(root!= null){
			    st.add(root);
				root = root.left;
	        }
        
	    }

	    /** @return whether we have a next smallest number */
		public boolean hasNext() {
			return !st.isEmpty();
	    }

	    /** @return the next smallest number */
		public int next() {
			TreeNode a = st.pop();
	        int res = a.val;
		    a = a.right;
			while(a != null){
	            st.add(a);
		        a = a.left;
	        }
		    return res;
	    }
	}

	/**
 * Your BSTIterator will be called like this:
 * BSTIterator i = new BSTIterator(root);
 * while (i.hasNext()) v[f()] = i.next();
 */

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
		BSTIterator i = new BSTIterator(root);
		while (i.hasNext()){
			System.out.println("The next smallest node:" + i.next());
		}
		return;
	}	
}
