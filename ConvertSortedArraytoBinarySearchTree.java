/*
Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
*/


import java.io.*;
import java.util.*;
public class ConvertSortedArraytoBinarySearchTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}
	public static TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length <= 0) return null;
        return buildTree(nums, 0, nums.length-1);
    }    

    public static TreeNode buildTree(int[] nums, int start, int end){
        if(start > end) return null;
        if(start == end) return new TreeNode(nums[start]);
        int mid = start + (end - start)/2;
        TreeNode inNode = new TreeNode(nums[mid]);
        inNode.left = buildTree(nums, start, mid-1);
        inNode.right = buildTree(nums, mid+1, end);
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
		int[] nums = new int[]{1,2,3,4,5,6,7};
		System.out.println( "Array: ");
		for( int a : nums) System.out.print(a + " "); 
		System.out.println();
		TreeNode root = sortedArrayToBST(nums);
		List<List<Integer>> res = levelOrder(root);
		System.out.println("The level order:");
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
		return;
	}	
}
