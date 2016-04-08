/*
Say you have an array for which the ith element is the price of a given stock on day i.

If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock), design an algorithm to find the maximum profit.
*/

import java.util.*;

public class BestTimetoBuyandSellStock {
	public static int maxProfit(int[] prices) {
        int res = 0;
        if(prices.length <= 0) return 0;
        int m = Integer.MAX_VALUE;
        for(int i = 0; i < prices.length; i++){
            m = Math.min(prices[i], m);
            res = Math.max(prices[i] - m, res);
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
