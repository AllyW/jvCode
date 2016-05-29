/*

*/


import java.io.*;
import java.util.*;

public class PathSumII {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

    public static List<List<Integer>> result = new ArrayList<List<Integer>>();
	
	public static List<List<Integer>> pathSum(TreeNode root, int sum) {
        pathSumRe(new ArrayList<Integer>(), root, sum);
        return result;
    }
    
    public static void pathSumRe(List<Integer> list, TreeNode root, int sum) {
        if (root == null) return;
        list.add(root.val);
        sum -= root.val;
        if (root.left == null && root.right == null && sum == 0) {
            result.add(list);
            return;
        }
        pathSumRe(new ArrayList<Integer>(list), root.left, sum);
        pathSumRe(new ArrayList<Integer>(list), root.right, sum);
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
		List<List<Integer>> res = levelOrder(root);
		System.out.println("The level order:");
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter sum: ");
		int n = reader.nextInt();
		List<List<Integer>> r = pathSum(root, n);
		System.out.println("Path sum " + n + " : ");
		for(int i = 0; i < r.size(); i++){
			System.out.println(r.get(i));
		}
		return;
	}
}
