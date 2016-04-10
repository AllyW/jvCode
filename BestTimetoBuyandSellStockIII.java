/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete at most two transactions.

Note:
You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
*/

import java.util.*;

public class BestTimetoBuyandSellStockIII {
	public static int maxProfit(int[] prices) {
        if(prices.length <= 1) return 0;
        int L = prices.length;
        int[] le = new int[L];
        int lmin = prices[0];
        for(int i = 1; i < L; i++){
            le[i] = Math.max(prices[i] - lmin, le[i-1]);
            if(prices[i] < lmin){
                lmin = prices[i];
            }
        }
        int[] ri = new int[L];
        int rmax = prices[L-1];
        for(int i = L-2; i>= 0; i--){
            ri[i] = Math.max(rmax - prices[i], ri[i+1]);
            if(prices[i] > rmax) rmax = prices[i];
        }
        int res = 0;
        for(int i = 0; i < L; i++){
            res = Math.max(le[i] + ri[i], res);
        }
        return res;
    }
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 2, 3, 0, 2, 7};
        System.out.println("Array: ");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
		int res = maxProfit(nums1);
        System.out.println("Maximum profit: " + res);
		return;
	}	
}
