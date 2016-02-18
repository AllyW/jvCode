/*
Given an integer matrix, find the length of the longest increasing path.

From each cell, you can either move to four directions: left, right, up or down. You may NOT move diagonally or move outside of the boundary (i.e. wrap-around is not allowed).

Example 1:

nums = [
  [9,9,4],
  [6,6,8],
  [2,1,1]
]

Return 4
The longest increasing path is [1, 2, 6, 9].

Example 2:

nums = [
  [3,4,5],
  [3,2,6],
  [2,2,1]
]

Return 4
The longest increasing path is [3, 4, 5, 6]. Moving diagonally is not allowed. 
*/

public class LongestIncreasingPathinaMatrix {
	public static int longestIncreasingPath(int[][] matrix) {
        if(matrix.length <= 0 || matrix[0].length <= 0) return 0;
        int M = matrix.length, N = matrix[0].length;
        int[][] cache = new int[M][N];
        int res = 1;
        for(int i = 0; i < M; i++){
            for(int j = 0; j < N; j++){
                
                res = Math.max(DFS(i, j, M, N, matrix, cache, Integer.MIN_VALUE), res);
            }
        }
        return res;
    }
    
    public static int DFS(int i, int j, int M, int N, int[][] matrix, int cache[][], int preValue){
        if(i < 0 || j < 0 || i > M-1 || j > N-1 || matrix[i][j] <= preValue) return 0;
        if(cache[i][j] != 0) return cache[i][j];
        int min = matrix[i][j];
        int a = DFS(i-1, j, M, N, matrix, cache, min) + 1;
        int b = DFS(i, j-1, M, N, matrix, cache, min) + 1;
        int c = DFS(i+1, j, M, N, matrix, cache, min) + 1;
        int d = DFS(i, j+1, M, N, matrix, cache, min) + 1;
        int L = Math.max(a, Math.max(b, Math.max(c,d)));
        cache[i][j] = L;
        return L;
    } 

	
	public static void main(String[] args) {
		int[][] nums = new int[][] {
			{9,9,6},
			{6,6,8},
			{2,1,1}
		};
		int res = longestIncreasingPath(nums);
		for(int i=0; i < nums.length; i++){
			for(int j = 0; j < nums[i].length; j++){
				System.out.print(nums[i][j] + " ");	
			}
			System.out.println();
		}

		System.out.print("Longest increasing path length: " + res);	
		return;
	}	
}
