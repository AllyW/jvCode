/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most k transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

import java.util.*;
import java.io.*;

public class BestTimetoBuyandSellStockIV {
	public static int maxProfit(int k, int[] prices) {
        int L = prices.length;
        if(L <= 0) return 0;
        int res = 0;
        if(k > L/2){
            for(int i = 1; i < L; i++){
                if(prices[i] > prices[i-1]){
                    res += prices[i] - prices[i-1];
                }
            }
            return res;
        }
        int[][] t = new int[k + 1][L];
        for (int i = 1; i <= k; i++) {
            int tmpMax =  -prices[0];
            for (int j = 1; j < L; j++) {
                t[i][j] = Math.max(t[i][j - 1], prices[j] + tmpMax);
                tmpMax =  Math.max(tmpMax, t[i - 1][j - 1] - prices[j]);
                //tmpMax means the maximum profit of just doing at most i-1 transactions, using at most first j-1 prices, and buying the stock at price[j] - this is used for the next loop.
            }
        }
        return t[k][L - 1];
    }
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 2, 3, 0, 3, 1, 2, 7, 5, 6};
        System.out.println("Array: ");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int k = reader.nextInt();
		int res = maxProfit(k, nums1);
        System.out.println("Maximum profit after "+ k + " transactions: " + res);
		return;
	}	
}
