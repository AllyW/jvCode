/*
Say you have an array for which the ith element is the price of a given stock on day i.

Design an algorithm to find the maximum profit. You may complete as many transactions as you like (ie, buy one and sell one share of the stock multiple times) with the following restrictions:

    You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
    After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)

Example:

prices = [1, 2, 3, 0, 2]
maxProfit = 3
transactions = [buy, sell, cooldown, buy, sell]

*/

import java.util.*;

public class BestTimetoBuyandSellStockwithCooldown {
	public static int maxProfit(int[] prices) {
        if(prices.length <= 0) return 0;
        int L = prices.length;
        int[] buy = new int[L];
        int[] sell = new int[L];
        int[] cooldown = new int[L];
        buy[0] = -prices[0];
        sell[0] = 0;
        cooldown[0] = 0;
        for(int i = 1; i <L; i++){
            buy[i] = Math.max(cooldown[i-1] - prices[i], buy[i-1]);
            sell[i] = Math.max(buy[i-1] + prices[i], sell[i-1]);
            cooldown[i] = Math.max(cooldown[i-1], sell[i-1]);
        }
        if(sell[L-1] > cooldown[L-1]){
            return sell[L-1];
        }else{
            return cooldown[L-1];
        }    
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 2, 3, 0, 2};
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
