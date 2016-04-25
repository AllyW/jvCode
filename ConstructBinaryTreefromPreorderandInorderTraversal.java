/*
Given preorder and inorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree. 

*/


import java.io.*;
import java.util.*;
public class ConstructBinaryTreefromPreorderandInorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static TreeNode buildTree(int[] preorder, int[] inorder) {
        if(inorder.length != preorder.length) return null;
        int L = inorder.length;
        return buildTreeRe(inorder, preorder, 0, L-1, 0, L-1);
    }
    
    public static TreeNode buildTreeRe(int[] inorder, int[] preorder, int l, int r, int start, int end){
        if(start > end) return null;
        if(start == end) return new TreeNode(preorder[start]);
        TreeNode inNode = new TreeNode(preorder[start]);
        int leftLen = findIn(inorder, l, r, preorder[start]);
        inNode.left = buildTreeRe(inorder, preorder, l, l+leftLen-1, start+1, start+leftLen);
        inNode.right = buildTreeRe(inorder, preorder, l+leftLen+1, r, start+leftLen+1, end);
        return inNode;
    } 

    public static int findIn(int[] inorder, int l, int r, int node){
        int leftLen = 0;
        for(int i = l; i <= r; i++){
            if(inorder[i] != node){
                leftLen++;
            }else{
                return leftLen;
            }
        }
        return leftLen;
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
		int[] inorder = new int[]{4,2,5,1,6,3,7};
		int[] preorder = new int[]{1,2,4,5,3,6,7};
		System.out.println( "Inorder: ");
		for( int a : inorder) System.out.print(a + " "); 
		System.out.println();
		System.out.println( "Preorder: ");
		for( int a : preorder) System.out.print(a + " "); 
		System.out.println();
		TreeNode root = buildTree(preorder, inorder);
		List<List<Integer>> res = levelOrder(root);
		System.out.println("The level order:");
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
		return;
	}	
}
