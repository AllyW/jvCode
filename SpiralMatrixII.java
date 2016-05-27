/*
Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,
You should return the following matrix:

[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/

import java.io.*;
import java.util.*;

public class SpiralMatrixII {
	public static int[][] generateMatrix(int n) {
        List<Integer> res = new ArrayList<>();
        int[][] matrix = new int[n][n];
        int imin = 0, jmin = 0;
        int imax = n-1, jmax = n-1;
        int num = 1;
        while(true){
            for(int j = jmin; j <= jmax; ++j){
                matrix[imin][j] = num++;
            }
            if (++imin > imax) break;
            for(int i = imin; i <= imax; ++i){
                matrix[i][jmax] = num++;
            }
            if(--jmax < jmin) break;
            for(int j = jmax; j >= jmin; --j){
                matrix[imax][j] = num++;
            }
            if(--imax < imin) break;
            for(int i = imax; i >= imin; --i){
                matrix[i][jmin] = num++;
            }
            if(++jmin > jmax) break;
        }
        return matrix;
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
		Scanner reader = new Scanner(System.in);
		System.out.println("Enter n: ");
		int n = reader.nextInt();
		System.out.println("Spiral matrix:");
		int[][] matrix = generateMatrix(n);
		dispArray2D(matrix);
		return;
	}	
}
