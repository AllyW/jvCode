/*
Serialization is the process of converting a data structure or object into a sequence of bits so that it can be stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later in the same or another computer environment.

Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your serialization/deserialization algorithm should work. You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.

For example, you may serialize the following tree

    1
   / \
  2   3
     / \
    4   5

as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree. You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.

Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless. 
*/


import java.io.*;
import java.util.*;
public class SerializeandDeserializeBinaryTree {
	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;
		TreeNode(int x) { val = x; }
	}

	public static class Codec {
		// Encodes a tree to a single string.
		public String serialize(TreeNode root) {
			StringBuilder res = new StringBuilder();
	        if(root==null) return "";
		    Queue<TreeNode> q = new LinkedList<TreeNode>();
			q.add(root);
	        while(q.isEmpty() == false){
		        int s = q.size();
			    for(int i = 0; i < s; i++){
				    TreeNode a = q.poll();
					if(a==null){
						res.append("null,");
	                    continue;
		            }
			        res.append(a.val + ",");
				    q.add(a.left);
					q.add(a.right);
	            }
		    }
			return res.toString();
		}

    // Decodes your encoded data to tree.
		public TreeNode deserialize(String data) {
			if(data == "") return null;
		    String[] res= data.split(",");
	       Queue<TreeNode> q = new LinkedList<TreeNode>();
			TreeNode root = new TreeNode(Integer.parseInt(res[0]));
	        q.add(root);
		    int index = 1;
			while(index < res.length && q.isEmpty() == false){
				int s = q.size();
	            for(int j = 0; j < s; j++){
		            TreeNode parent = q.poll();
			        if(res[index].equals("null")){
				        parent.left = null;
	                }else{
		                TreeNode a = new TreeNode(Integer.parseInt(res[index]));
			            parent.left = a;
				        q.add(a);
	                }
		            index++;
			        if(res[index].equals("null")){ // string equal!
				        parent.right = null;
					}else{
						TreeNode a = new TreeNode(Integer.parseInt(res[index]));
	                    parent.right = a;
		                q.add(a);
			        }
				    index++;
	            }	
		    }
			return root;
		}
	}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));

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
		node2.left = null;
		node2.right = null;
		node3.left = node4;
		node3.right = node5;
		node4.left = null;
		node4.right = null;
		node5.left = null;
		node5.right = null;
		Codec codec = new Codec();
		String res = codec.serialize(root);
		boolean res2 = false;
		if(codec.deserialize(codec.serialize(root)).val == root.val){  // use value equal of root node to simple test if deserialization can restore previous tree.
			res2 = true;
		}
		System.out.println("String after serializing:" + res);
		System.out.println("Equal if serialization and deserialization? " + res2);
		return;
	}	
}
