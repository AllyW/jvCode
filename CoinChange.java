/*

You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

Example 1:
coins = [1, 2, 5], amount = 11
return 3 (11 = 5 + 5 + 1)

Example 2:
coins = [2], amount = 3
return -1.

Note:
You may assume that you have an infinite number of each kind of coin. 

*/
import java.util.Arrays;

public class CoinChange{

	static int res = Integer.MAX_VALUE;

    public static int coinChange1(int[] coins, int amount) {
        if(coins.length <=0 || amount <= 0) return -1;
        Arrays.sort(coins);
        int startP = 0;
        getAmount(coins, amount, 0, 0);
        return res;
    }

    public static void getAmount(int[] coins, int amount, int sp, int total){
        if(amount == 0) {
            res = Math.min(total, res);
            return;
        }
        if(amount < 0) return;
        for(int i = sp; i < coins.length; i++){
             getAmount(coins, amount-coins[i], i, total+1);
        }
        return;
    }

	public static int coinChange2(int[] coins, int amount) {
        if(coins.length <=0) return 0;
        if(amount <= 0) return 0;
        Arrays.sort(coins);
        int[] res = new int[amount+1];
        for(int i = 1; i<=amount;i++){
            res[i] = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                if(coins[j] <= i && res[i-coins[j]] != Integer.MAX_VALUE){
                    res[i] = Math.min(res[i], res[i-coins[j]] + 1);
                }
            }
        }
        if(res[amount] == Integer.MAX_VALUE) return -1;
        return res[amount];
    }
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 4};
		int n = 12;
		System.out.println("Amount is " + n);
		int res = coinChange2(nums1, n);
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
		
		System.out.println(" ");
		System.out.println("the smallest num of coins needed: " + res);
		return;
	}	
}
