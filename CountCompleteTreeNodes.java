/*
Given a complete binary tree, count the number of nodes.

Definition of a complete binary tree from Wikipedia:
In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.
*/


import java.io.*;
import java.util.*;
public class CountCompleteTreeNodes {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static int countNodes(TreeNode root) {
        if(root == null) return 0;
		Queue<TreeNode> st = new LinkedList<TreeNode>();
        int res = 0;
        st.add(root);
        while(st.size()>0){
			int sz = st.size();
        	for(int i = 0; i < sz; i++){
				TreeNode p = st.poll();
                res++;
				System.out.print( p.val + " ");
                if(p.left != null) st.add(p.left);
                if(p.right != null) st.add(p.right);
            }
			System.out.println();
        }
        return res;
        
    }
	
	public static int countNodes2(TreeNode root) {
        if(root == null) return 0;
        int l = leftLength(root);
        int r = rightLength(root);
        if(l == r){
            return (1 << l) - 1 ; // a1(q^n-1)/(q-1)  complete binary tree, nodes number = 2^length-1
        }else{
            return 1 + countNodes2(root.left) + countNodes2(root.right);
        }
    }
    
    public static int leftLength(TreeNode p){
        int res = 0;
        if(p == null) return 0;
        while(p != null){
            res++;
            p = p.left;
        }
        return res;

    }
    
    public static int rightLength(TreeNode p){
        int res = 0;
        if(p == null) return 0;
        while(p != null){
            res++;
            p = p.right;
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
		System.out.println( "Before: ");
		int res = countNodes(root);
		int res2 = countNodes2(root);
		System.out.println("Node number from method 1 is:" + res);
		System.out.println("Node number from method 2 is:" + res2);
		return;
	}	
}
