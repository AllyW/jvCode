/*
The demons had captured the princess (P) and imprisoned her in the bottom-right corner of a dungeon. The dungeon consists of M x N rooms laid out in a 2D grid. Our valiant knight (K) was initially positioned in the top-left room and must fight his way through the dungeon to rescue the princess.

The knight has an initial health point represented by a positive integer. If at any point his health point drops to 0 or below, he dies immediately.

Some of the rooms are guarded by demons, so the knight loses health (negative integers) upon entering these rooms; other rooms are either empty (0's) or contain magic orbs that increase the knight's health (positive integers).

In order to reach the princess as quickly as possible, the knight decides to move only rightward or downward in each step.

Write a function to determine the knight's minimum initial health so that he is able to rescue the princess.

For example, given the dungeon below, the initial health of the knight must be at least 7 if he follows the optimal path RIGHT-> RIGHT -> DOWN -> DOWN.
-2 (K) 	-3 	3
-5 	-10 	1
10 	30 	-5 (P)

Notes:

    The knight's health has no upper bound.
    Any room can contain threats or power-ups, even the first room the knight enters and the bottom-right room where the princess is imprisoned.

*/

import java.io.*;
import java.util.*;

public class DungeonGame {
	public static int calculateMinimumHP(int[][] dungeon) {
        if(dungeon.length <= 0 || dungeon[0].length <= 0){
            return -1;
        }
        int M = dungeon.length;
        int N = dungeon[0].length;
        int[][] matrix = new int[M][N];
        matrix[M-1][N-1] = dungeon[M-1][N-1] >= 1 ? 1:1-dungeon[M-1][N-1];
        for(int i = M-2; i>= 0; i--){
            matrix[i][N-1] = Math.max(matrix[i+1][N-1]-dungeon[i][N-1], 1);
        }
        for(int j = N-2; j>=0; j--){
            matrix[M-1][j] = Math.max(matrix[M-1][j+1] - dungeon[M-1][j], 1);
        }
        for(int i = M-2; i>=0; i--){
            for(int j = N-2; j >= 0; j--){
                int l = Math.max(matrix[i+1][j] - dungeon[i][j], 1);
                int m = Math.max(matrix[i][j+1] - dungeon[i][j], 1);
                matrix[i][j] = Math.min(l, m);
            }
        }
        return matrix[0][0];
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
			{1,   -4,  -7, 2, 5},
			{-2,   5,  -8, 12, 9},
			{-7,   6,  9, -6, -12},
			{-1, 13, -4, 1, -6},
			{8, 1, -13, -6, 3}
		};
		System.out.println("2D matrix:");
		dispArray2D(matrix);
		int r = calculateMinimumHP(matrix);
		System.out.println("minimum inputs: " + r);
		return;
	}	
}
