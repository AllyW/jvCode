/*
Given a 2D matrix matrix, find the sum of the elements inside the rectangle defined by its upper left corner (row1, col1) and lower right corner (row2, col2).

Range Sum Query 2D
The above rectangle (with the red border) is defined by (row1, col1) = (2, 1) and (row2, col2) = (4, 3), which contains sum = 8.

Example:

Given matrix = [
  [3, 0, 1, 4, 2],
  [5, 6, 3, 2, 1],
  [1, 2, 0, 1, 5],
  [4, 1, 0, 1, 7],
  [1, 0, 3, 0, 5]
]

sumRegion(2, 1, 4, 3) -> 8
sumRegion(1, 1, 2, 2) -> 11
sumRegion(1, 2, 2, 4) -> 12

Note:

    You may assume that the matrix does not change.
    There are many calls to sumRegion function.
    You may assume that row1 ≤ row2 and col1 ≤ col2.

*/

import java.io.*;
import java.util.*;

public class RangeSumQuery2DImmutable {

	public static class NumMatrix {
	    private int[][] sumToBottom;
		public NumMatrix(int[][] matrix) {
			if(matrix.length <= 0 || matrix[0].length <= 0) return;
	        int M = matrix.length;
		    int N = matrix[0].length;
			sumToBottom = new int[M+1][N+1];
	        for(int i = 1; i <= M; i++){
		        for(int j = 1; j <= N; j++){
			         sumToBottom[i][j] = sumToBottom[i][j-1] + sumToBottom[i-1][j] - sumToBottom[i-1][j-1] + matrix[i-1][j-1];
				}
	        }
	    }

		public int sumRegion(int row1, int col1, int row2, int col2) {
	        return sumToBottom[row2+1][col2+1] - sumToBottom[row1][col2+1] - sumToBottom[row2+1][col1]+ sumToBottom[row1][col1];
        }
		// Your NumMatrix object will be instantiated and called as such:
// NumMatrix numMatrix = new NumMatrix(matrix);
// numMatrix.sumRegion(0, 1, 2, 3);
// numMatrix.sumRegion(1, 2, 3, 4);
	}

	public static void dispArray2D(int[][] res){
		for(int i = 0; i < res.length; i++){    
			for(int j = 0; j < res[i].length; j++){
				System.out.print(res[i][j] + " ");   // note: res[i][j]
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		int[][] matrix = new int[][]{
			{1,   4,  7, 11, 15},
			{2,   5,  8, 12, 19},
			{3,   6,  9, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30}
		};
		System.out.println("Range Sum Query 2D - immutable:");
		dispArray2D(matrix);
		NumMatrix numMatrix = new NumMatrix(matrix);
		System.out.println("Enter row1: ");
		Scanner reader = new Scanner(System.in);
		int row1 = reader.nextInt();
		System.out.println("Enter col1: ");
		int col1 = reader.nextInt();
		System.out.println("Enter row2: ");
		int row2 = reader.nextInt();
		System.out.println("Enter col2: ");
		int col2 = reader.nextInt();
		int r = numMatrix.sumRegion(row1, col1, row2, col2);
		System.out.println("results: " + r);
		return;
	}	
}
