/*
 You are given an integer array nums and you have to return a new counts array. The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Given nums = [5, 2, 6, 1]

To the right of 5 there are 2 smaller elements (2 and 1).
To the right of 2 there is only 1 smaller element (1).
To the right of 6 there is 1 smaller element (1).
To the right of 1 there is 0 smaller element.

Return the array [2, 1, 1, 0]. 
*/

import java.util.*;

public class CountofSmallerNumbersAfterSelf {
	public static class TreeNode{
        TreeNode left;
        TreeNode right;
        int val; 
        int count;
        public TreeNode(int val){
            this.val = val;
            this.count = 1;
        }
    }

	public static List<Integer> countSmaller(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length <= 0) return res;
        int L = nums.length;
        res.add(0);
        TreeNode root = new TreeNode(nums[L-1]);
        for(int i = L-2; i >= 0; i--){
            int count = findCount(root, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }
    
    public static int findCount(TreeNode node, int num){
        int acount = 0;
        while(true){
            if(node.val < num){
                acount += node.count;
                if(node.right == null){
                    TreeNode r = new TreeNode(num);
                    node.right = r;
                    break;
                }else{
                    node = node.right;
                }
            }else{
                node.count++;
                if(node.left == null){
                    TreeNode l = new TreeNode(num);
                    node.left = l;
                    break;
                }else{
                    node = node.left;
                }
            }
        }
        return acount;   
    }
	public static void main(String[] args) {
		int[] nums1 = new int[] {12, 2, 27, 8, 35, 56, 2, 2, 3};
        System.out.println("Array: ");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
        System.out.println("Res: ");
		List<Integer> nums2 = countSmaller(nums1);
		for(int i=0; i < nums2.size(); i++){
			System.out.print(nums2.get(i) + " ");
		}
		return;
	}	
}
