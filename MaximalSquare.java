/*
 Given a 2D binary matrix filled with 0's and 1's, find the largest square containing all 1's and return its area.

For example, given the following matrix:

1 0 1 0 0
1 0 1 1 1
1 1 1 1 1
1 0 0 1 0

Return 4.
*/

import java.io.*;
import java.util.*;

public class MaximalSquare {
	public static int maximalSquare(char[][] matrix) {
        if(matrix.length <= 0 || matrix[0].length <= 0) return 0;
        int res = 0;
        int M = matrix.length;
        int N = matrix[0].length;
        int[][] dp = new int[M+1][N+1];
        for(int i = 1; i <= matrix.length; i++){
            for(int j = 1; j <= matrix[0].length; j++){
                if(matrix[i-1][j-1] == '1'){
                    dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i-1][j]), dp[i][j-1])+1;
                    res = Math.max(dp[i][j], res);
                }
            }
        }
        return res*res;
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
			{'0', '1', '1', '1', '1'},
			{'0', '1', '1', '1', '1'},
			{'1', '0', '1', '1', '1'},
			{'1', '1', '1', '1', '1'},
			{'0', '0', '0', '1', '1'}
		};
		System.out.println("Maximal square: ");
		dispArray2D(matrix);
		int r = maximalSquare(matrix);
		System.out.println("results: " + r);
		return;
	}	
}
