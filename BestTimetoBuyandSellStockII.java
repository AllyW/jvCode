/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).

*/

import java.util.*;

public class BestTimetoBuyandSellStockII {
	public static int maxProfit(int[] prices) {
        if(prices.length<=0) return 0;
        int l = prices[0];
        int res = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] > l){
                res += prices[i]-l;
            }
            l = prices[i];
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
