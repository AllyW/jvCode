/*
 Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]

word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.
*/

import java.io.*;
import java.util.*;

public class WordSearch {
	public static boolean exist(char[][] board, String word) {
        if(board.length <= 0 || board[0].length <= 0) return false;
        int M = board.length;
        int N = board[0].length;
        int[][] visited = new int[M][N];
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(dfs(board, word, i, j, 0, visited)) return true;
            }
        }
        return false;
    }   

    
    public static boolean dfs(char[][] board, String word, int i, int j, int pos, int[][] visited){
        if( i < 0 || j < 0 || i >= board.length || j >= board[0].length || visited[i][j] == 1 || pos >= word.length() || board[i][j] != word.charAt(pos)) return false;
        if(pos == word.length()-1) return true;
        visited[i][j] = 1;
        if(dfs(board, word, i-1, j, pos+1, visited)) return true;
        if(dfs(board, word, i, j-1, pos+1, visited)) return true;
        if(dfs(board, word, i+1, j, pos+1, visited)) return true;
        if(dfs(board, word, i, j+1, pos+1, visited)) return true;
        visited[i][j] = 0;
        return false;
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
			{'A', 'B', 'C', 'J', 'K'},
			{'E', 'Q', 'V', 'J', 'L'},
			{'C', 'A', 'G', 'M', 'E'},
			{'M', 'E', 'F', 'Q', 'R'},
			{'D', 'F', 'T', 'S', 'Z'},
		};
		System.out.println("Boards: ");
		dispArray2D(matrix);
		String s1 = "ABBC";
		boolean r = exist(matrix, s1);
		System.out.println(s1 + " exists? " + r);
		String s2 = "QAEFT";
		r = exist(matrix, s2);
		System.out.println(s2 + " exists? " + r);
		return;
	}	
}
