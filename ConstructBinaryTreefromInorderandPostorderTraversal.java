/*
Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

*/


import java.io.*;
import java.util.*;
public class ConstructBinaryTreefromInorderandPostorderTraversal {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder.length != postorder.length) return null;
        int L = inorder.length;
        return buildTreeRe(inorder, postorder, 0, L-1, 0, L-1);
    }
    
    public static TreeNode buildTreeRe(int[] inorder, int[] postorder, int l, int r, int start, int end){
        if(start > end) return null;
        if(start == end) return new TreeNode(postorder[start]);
        TreeNode inNode = new TreeNode(postorder[end]);
        int leftLen = findIn(inorder, l, r, postorder[end]);
        inNode.left = buildTreeRe(inorder, postorder, l, l+leftLen-1, start, start+leftLen-1);
        inNode.right = buildTreeRe(inorder, postorder, l+leftLen+1, r, start+leftLen, end-1);
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
		int[] postorder = new int[]{4,5,2,6,7,3,1};
		System.out.println( "Inorder: ");
		for( int a : inorder) System.out.print(a + " "); 
		System.out.println();
		System.out.println( "Postorder: ");
		for( int a : postorder) System.out.print(a + " "); 
		System.out.println();
		TreeNode root = buildTree(inorder, postorder);
		List<List<Integer>> res = levelOrder(root);
		System.out.println("The level order:");
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
		return;
	}	
}
