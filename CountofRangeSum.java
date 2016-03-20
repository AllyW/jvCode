/*
 Given an integer array nums, return the number of range sums that lie in [lower, upper] inclusive.
Range sum S(i, j) is defined as the sum of the elements in nums between indices i and j (i ≤ j), inclusive.

Note:
A naive algorithm of O(n2) is trivial. You MUST do better than that.

Example:
Given nums = [-2, 5, -1], lower = -2, upper = 2,
Return 3.
The three ranges are : [0, 0], [2, 2], [0, 2] and their respective sums are: -2, -1, 2. 
*/

import java.util.*;
import java.util.HashMap;
import java.util.Map; //use hashmap or hashtable

public class CountofRangeSum {
	public static int countRangeSum(int[] nums, int lower, int upper) {
        int res = 0; 
        int L = nums.length;
        long[] sum = new long[L+1];
        sum[0] = 0;
        for(int i = 1; i <= L; i++){
            sum[i] = sum[i-1] + nums[i-1];
        }
        return mergeSort(sum, lower, upper, 0, L+1);
    }
    
    public static int mergeSort(long[] sum, int lower, int upper, int l, int r){
        int mid;
        mid = l + (r - l)/2;
        if(r - l <= 1) return 0;
        int res = mergeSort(sum, lower, upper, l, mid) + mergeSort(sum, lower, upper, mid, r);
        long[] cache = new long[r - l];
        int t = mid;
        int m = mid;
        int n = mid;
        for(int i = l, c = 0; i < mid; i++, c++){
            while(m< r && sum[m] - sum[i] < lower) m++;
            while(n< r && sum[n] - sum[i] <= upper) n++;
            while(t< r && sum[t] < sum[i]) cache[c++] = sum[t++];
            cache[c] = sum[i];
            res += n-m;
        }
        System.arraycopy(cache, 0, sum, l, t - l);
        return res;
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {-2, 5, -1, 3, -7};
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
		int res = countRangeSum(nums1, -2, 2);
        System.out.println("results: " + res);
		return;
	}	
}
