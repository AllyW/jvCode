/*
Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

Example 1:

11110
11010
11000
00000

Answer: 1

Example 2:

11000
11000
00100
00011

Answer: 3
*/

import java.io.*;
import java.util.*;

public class NumberofIslands {
	public static int numIslands(char[][] grid) {
        if(grid.length <= 0 || grid[0].length <= 0) return 0;
        int M = grid.length;
        int N = grid[0].length;
        int res = 0;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                if(grid[i][j] == '1'){
                    dfs(grid, i, j, M, N);
                    res++;
                }
            }
        }
        return res;
    }
    
    
    public static void dfs(char[][] grid, int i, int j, int M, int N){
        if(i < 0 || j < 0 || i >=M || j >= N || grid[i][j] == '0') return;
        grid[i][j] = '0';
        dfs(grid, i-1, j, M, N);
        dfs(grid, i, j-1, M, N);
        dfs(grid, i+1, j, M, N);
        dfs(grid, i, j+1, M, N);
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
			{'1', '1', '0', '0', '1'},
			{'1', '0', '0', '0', '1'},
			{'1', '0', '1', '1', '0'},
			{'0', '1', '0', '1', '1'},
			{'1', '1', '0', '0', '1'},
		};
		System.out.println("Number of Islands: ");
		dispArray2D(matrix);
		int r = numIslands(matrix);
		System.out.println("results: " + r);
		return;
	}	
}
