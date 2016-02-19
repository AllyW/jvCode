/*
Given an unsorted array of integers, find the length of longest increasing subsequence.

For example,
Given [10, 9, 2, 5, 3, 7, 101, 18],
The longest increasing subsequence is [2, 3, 7, 101], therefore the length is 4. Note that there may be more than one LIS combination, it is only necessary for you to return the length.

Your algorithm should run in O(n2) complexity.

Follow up: Could you improve it to O(n log n) time complexity? 
*/

import java.util.*;

public class LongestIncreasingSubsequence {
	public static int lengthOfLIS(int[] nums) {
        if(nums.length <= 0) return 0;
        int res = 1;
        int L = nums.length;
        int[] dp = new int[L];
        Arrays.fill(dp, 1);
        for(int i = 1; i < L; i++){
            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i], dp[j]+1);
                }
            }
            res = Math.max(dp[i], res);
        }
        return res;
	}
	
	// O(nlogn): see http://www.geeksforgeeks.org/longest-monotonically-increasing-subsequence-size-n-log-n/
	public static void main(String[] args) {
		int[] nums = new int[] {10, 9, 2, 5, 3, 7, 101, 18, 3};
		int res = lengthOfLIS(nums);
		for(int i=0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println(" ");
		System.out.println("the longest increasing subsequence: " + res);
		return;
	}	
}
