/*
 Given a 2D board and a list of words from the dictionary, find all words in the board.

Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

For example,
Given words = ["oath","pea","eat","rain"] and board =

[
  ['o','a','a','n'],
  ['e','t','a','e'],
  ['i','h','k','r'],
  ['i','f','l','v']
]

Return ["eat","oath"].

Note:
You may assume that all inputs are consist of lowercase letters a-z.

click to show hint.

You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?

If the current candidate does not exist in all words' prefix, you could stop backtracking immediately. What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not? How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem: Implement Trie (Prefix Tree)
*/

import java.io.*;
import java.util.*;

public class WordSearchII {
	public static class TrieNode {
		// Initialize your data structure here.
	    public boolean endPoint;
		public TrieNode[] next;
	    public TrieNode() {
		    endPoint = false;
			next = new TrieNode[26];
	    }
	}
	
	public static void insertTree(TrieNode p, String word) {
		if(word.length() <=0) return;
		for(int i = 0; i < word.length(); i++){
		    if(p.next[word.charAt(i) - 'a'] == null){
		        TrieNode a = new TrieNode();
		        p.next[word.charAt(i) - 'a'] = a;
	       }
	       p = p.next[word.charAt(i) - 'a'];
	    }
	    p.endPoint = true;
	}
	
    public static Set<String> res = new HashSet<String>();
    
    public static List<String> findWords(char[][] board, String[] words) {
        if(board.length <= 0 || board[0].length <= 0) return new ArrayList<String>(res);
        int M = board.length;
        int N = board[0].length;
        TrieNode root = new TrieNode();
        
        for(int i =0; i < words.length; i++){
            TrieNode p = root;
            insertTree(p, words[i]);
        }
        findWord(board, root, M, N);
        return new ArrayList<String>(res);
    }
    
    public static void findWord(char[][] board, TrieNode tr, int M, int N){
        int[][] visited = new int[M][N];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                dfs(board, tr, visited, "", M, N, i, j);
            }
        }
        return;
    }
    public static void dfs(char[][] board, TrieNode tr, int[][] visited, String str, int M, int N, int i, int j){
        if(i <0 || i >= M || j < 0 || j >= N || visited[i][j] == 1) return;
        char c = board[i][j];
        if(tr.next[c-'a'] == null) return;
        tr = tr.next[c-'a'];
        if(tr.endPoint == true){
            res.add(str + c);
        }
        visited[i][j] = 1;
        dfs(board, tr, visited, str + board[i][j], M, N, i-1, j);
        dfs(board, tr, visited, str + board[i][j], M, N, i+1, j);
        dfs(board, tr, visited, str + board[i][j], M, N, i, j-1);
        dfs(board, tr, visited, str + board[i][j], M, N, i, j+1);
        visited[i][j] = 0;
        return;
    }

	public static void dispArray2D(char[][] res){
		for(int i = 0; i < res.length; i++){    
			for(int j = 0; j < res[i].length; j++){
				System.out.print(res[i][j] + " ");   // note: res[i][j]
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		char[][] matrix = new char[][]{
			{'o', 'a', 'a', 'n'},
			{'e', 't', 'a', 'e'},
			{'i', 'h', 'k', 'r'},
			{'i', 'f', 'l', 'v'}
		};
		System.out.println("Matrix: ");
		dispArray2D(matrix);
		String[] words = new String[]{"oath","pea","eak","rain"};
		List<String> r = findWords(matrix, words);
		System.out.println("results: " + r);  // list print~~
		//for(int i = 0; i < r.size(); i++){
		//	System.out.print(" " + r.get(i));
		//}
		return;
	}	
}
