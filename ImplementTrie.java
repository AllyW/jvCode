/*
Implement a trie with insert, search, and startsWith methods.

Note:
You may assume that all inputs are consist of lowercase letters a-z. 
*/

// note: any class is a set of variables and functions.
// search here is search for a string that starts from the root and must end with the root's endpoint
import java.io.*;
import java.util.*;
public class ImplementTrie {
	public static class TrieNode {
		// Initialize your data structure here.
	    public boolean endPoint;
		public TrieNode[] next;
	    public TrieNode() {
		    endPoint = false;
			next = new TrieNode[26];
	    }
	}
	
	public static class Trie {
		private TrieNode root;
		private TrieNode p;
		public Trie() {
			root = new TrieNode();
	    }

	    // Inserts a word into the trie.
		public void insert(String word) {
			if(word.length() <=0) return;
	       // TrieNode p = root;
		    p = root;
			for(int i = 0; i < word.length(); i++){
			    if(p.next[word.charAt(i) - 'a'] == null){
				     TrieNode a = new TrieNode();
					 p.next[word.charAt(i) - 'a'] = a;
	            }
		        p = p.next[word.charAt(i) - 'a'];
	        }
		    p.endPoint = true;
	    }

		// Returns if the word is in the trie.
	    public boolean search(String word) {
		    if(word.length() <=0) return true;
			//TrieNode p = root;
	        p = root;
			for(int i = 0;i < word.length(); i++){
		        if(p.next[word.charAt(i)- 'a'] != null){
			        p = p.next[word.charAt(i)- 'a'];
				}else{
					return false;
	            }
		    }
			if(p.endPoint == false){
				return false;
			}else{
				return true;
			}
	    }

		// Returns if there is any word in the trie
	    // that starts with the given prefix.
		public boolean startsWith(String prefix) {
			if(prefix.length() <=0) return true;
	        //TrieNode p = root;
		    p = root;
			for(int i = 0;i < prefix.length(); i++){
			    if(p.next[prefix.charAt(i)- 'a']!= null){
				    p = p.next[prefix.charAt(i)- 'a'];
	            }else{
		            return false;
			    }
	        }	
		    return true;
	    }
	}
// Your Trie object will be instantiated and called as such:
// Trie trie = new Trie();
// trie.insert("somestring");
// trie.search("key");

	public static void main(String[] args) { 
		Trie trie = new Trie();
		String ins = "something";
		String ser = "some";
		String sta = "some";
		trie.insert(ins);
		boolean canSearch = trie.search(ser);
		boolean canStart = trie.startsWith(sta);
		System.out.println("Before: " + ins);
		System.out.println("Is " + ser + " in: " + canSearch);
		System.out.println("Start with " + sta + " : " + canStart);
		return;
	}	
}
