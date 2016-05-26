/*
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?
*/

import java.io.*;
import java.util.*;

public class RotateImage {
	public static void rotate(int[][] matrix) {
        if(matrix.length != matrix[0].length) return;
        int N = matrix.length;
        for(int i = 0; i < N / 2 ; ++i){
            for(int j = i; j < N - i - 1; ++j){
                int shift = matrix[N-1-j][i];
                matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
                matrix[N-1-i][N-1-j] = matrix[j][N-1-i];
                matrix[j][N-1-i] = matrix[i][j];
                matrix[i][j] = shift;
            }
        }
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
			{11, 14, 27, 11, 15},
			{12, 15, 38, 12, 19},
			{13, 16, 19, 16, 22},
			{10, 13, 14, 17, 24},
			{18, 21, 23, 26, 30}
		};
		System.out.println("Rotate image:");
		dispArray2D(matrix);
		rotate(matrix);
		System.out.println("results: ");
		dispArray2D(matrix);
		return;
	}	
}
