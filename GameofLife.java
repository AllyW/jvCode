/*
 According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."

Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):

    Any live cell with fewer than two live neighbors dies, as if caused by under-population.
    Any live cell with two or three live neighbors lives on to the next generation.
    Any live cell with more than three live neighbors dies, as if by over-population..
    Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.

Write a function to compute the next state (after one update) of the board given its current state.

Follow up:

    Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
    In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?

*/

// define state change machine to remember the old state as well as the new result
// case 1 -> 2    from live to dead
// case 2 -> 3    from live to live
// case 3 -> 4    from live to dead
// case 4 -> 5    from dead to live
// ask for in place, then count costs time...
// if ask for time efficiency, define a new 2D array for time saving


import java.io.*;
import java.util.*;

public class GameofLife {
	public static void gameOfLife(int[][] board) {
        if(board.length <= 0 && board[0].length <= 0) return;
        int m = board.length, n = board[0].length;
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                int count = countNeighbor(board, i, j, m, n);
                if(board[i][j] == 1){
                    if(count < 2){
                        board[i][j] = 2;
                    }else if(count == 2 || count == 3){
                        board[i][j] = 3;
                    }else{
                        board[i][j] = 4;
                    }
                }else{
                    if(count == 3) board[i][j] = 5;
                }
            }
        }
        
        for(int i = 0; i < m; i++){
            for(int j = 0; j < n; j++){
                if(board[i][j] == 2){
                    board[i][j] = 0;
                }else if(board[i][j] == 3){
                    board[i][j] = 1;
                }else if(board[i][j] == 4){
                    board[i][j] = 0;
                }else if(board[i][j] == 5){
                    board[i][j] = 1;
                }
            }
        }
        return;
    }
    
    public static int countNeighbor(int[][] board, int i, int j, int m, int n){
        int count = 0;
        // board[i][j] in [1, 4] means it is live in old state
        // board[i][j] in {0, 5} means it's dead in previous state
        if(i > 0 && j > 0 && board[i-1][j-1] >= 1 && board[i-1][j-1] <= 4) count++;
        if(i > 0 && board[i-1][j] >= 1 && board[i-1][j] <= 4) count++;
        if(i > 0 && j < n-1 && board[i-1][j+1] >= 1 && board[i-1][j+1] <= 4) count++;
        if(j > 0 && board[i][j-1] >= 1 && board[i][j-1] <= 4) count++;
        if(j < n-1 && board[i][j+1] >= 1 && board[i][j+1] <= 4) count++;
        if(i < m-1 && j < n-1 && board[i+1][j+1] >= 1 && board[i+1][j+1] <= 4) count++;
        if(i < m-1 && board[i+1][j] >= 1 && board[i+1][j] <= 4) count++;
        if(i < m-1 && j > 0 && board[i+1][j-1] >= 1 && board[i+1][j-1] <=4) count++;
        return count;
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
			{1,  1,  1,  0,  0, 1},
			{0,  1,  1,  0,  1, 1},
			{1,  0,  1,  1,  0, 0},
			{0,  1,  1,  0,  1, 1},
			{1,  1,  0,  1,  0, 0},
			{1,  1,  0,  1,  1, 1}
		};
		System.out.println("Game of Life");
		System.out.println("old state: ");
		dispArray2D(matrix);
		gameOfLife(matrix);
		System.out.println("next state: ");
		dispArray2D(matrix);
		return;
	}	
}
