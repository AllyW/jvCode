/*
Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

    Integers in each row are sorted in ascending from left to right.
    Integers in each column are sorted in ascending from top to bottom.

For example,

Consider the following matrix:

[
  [1,   4,  7, 11, 15],
  [2,   5,  8, 12, 19],
  [3,   6,  9, 16, 22],
  [10, 13, 14, 17, 24],
  [18, 21, 23, 26, 30]
]

Given target = 5, return true.

Given target = 20, return false.
*/

import java.io.*;
import java.util.*;

public class Searcha2DMatrixII {
	public static boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length<=0 || matrix[0].length <= 0) return false;
        int m = matrix.length, n = matrix[0].length;
        int[][] visited = new int[m][n];
        int i = 0, j = n-1;
        while(i < m && j >= 0 && visited[i][j] == 0){
            visited[i][j] = 1;
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
            
        }
        return false;
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
		System.out.println("Searcha 2D MatrixII");
		dispArray2D(matrix);
		System.out.println("Enter target: ");
		Scanner reader = new Scanner(System.in); 
		int n = reader.nextInt();
		boolean r = searchMatrix(matrix, n);
		System.out.println("results: " + r);
		return;
	}	
}
