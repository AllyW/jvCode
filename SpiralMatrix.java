/*
Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]

You should return [1,2,3,6,9,8,7,4,5]. 
*/

import java.io.*;
import java.util.*;

public class SpiralMatrix {
	public static List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0 || matrix[0].length== 0) return res;
        int M = matrix.length;
        int N = matrix[0].length;
        int imin = 0, jmin = 0;
        int imax = M-1, jmax = N-1;
        while(true){
            for(int j = jmin; j <= jmax; ++j){
                res.add(matrix[imin][j]);
            }
            if (++imin > imax) break;
            for(int i = imin; i <= imax; ++i){
                res.add(matrix[i][jmax]);
            }
            if(--jmax < jmin) break;
            for(int j = jmax; j >= jmin; --j){
                res.add(matrix[imax][j]);
            }
            if(--imax < imin) break;
            for(int i = imax; i >= imin; --i){
                res.add(matrix[i][jmin]);
            }
            if(++jmin > jmax) break;
        }
        return res;
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
		System.out.println("Spiral matrix:");
		dispArray2D(matrix);
		List<Integer> res = spiralOrder(matrix);
		System.out.println("results: " + res);
		return;
	}	
}
