/*
 Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.

For example, given n = 12, return 3 because 12 = 4 + 4 + 4; given n = 13, return 2 because 13 = 4 + 9. 
*/

import java.io.*;
import java.util.*;

public class PerfectSquares {
	private static int res = Integer.MAX_VALUE;
    public static int numSquares(int n) {
        if(n <= 1) return n;
        int L = (int)Math.sqrt(n);
        numSquaresRe(L, 0, 1, n, 0);
        return res;
    }
    
    public static void numSquaresRe(int L, int num, int sp, int n, int sum){
        if(sum == n){
            res = Math.min(res, num);
            return;
        }
        if( sum > n) return;
        for(int i = sp; i <= L; i++){
            numSquaresRe(L, num + 1, i, n, sum + i*i);
        }
        return;
    }

    public static int numSquares2(int n) {
        if(n <= 1) return n;
        int[] res = new int[n+1];
        res[0] = 0;
        res[1] = 1;
        for(int i = 2; i <= n; i++){
            res[i] = Integer.MAX_VALUE;
            for(int j = i-1; j > 0; j--){
                if(res[j] == Integer.MAX_VALUE) continue;
                if( i >= j*j){
                    res[i] = Math.min(res[i-j*j] + 1, res[i]);
                }
            }
        }
        return res[n];
    }  
// most efficient
	public static int numSquares3(int n) {
        if(n <= 1) return n;
        int[] res = new int[n+1];
        for(int i = 1; i <= n; i++){
            res[i] = Integer.MAX_VALUE;
        }
        res[0] = 0;
        res[1] = 1;
        for(int i = 2; i <= n; i++){
            int upper = (int)Math.sqrt(i);
            if(upper * upper == i){
                res[i] = 1;
                continue;
            }
            for(int j = 1; j <= upper; j++){
                res[i] = Math.min(res[i-j*j] + 1, res[i]);
            }
        }
        return res[n];
    }
    
	
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		System.out.println("is perfect square? ");
		//System.out.println("method 1: " + numSquares(n));  stackoverflow when n is large, like 22220
		System.out.println("method 2: " + numSquares2(n));
		System.out.println("method 3: " + numSquares3(n));
		return;
	}	
}
