/*
 Given an array of n positive integers and a positive integer s, find the minimal length of a subarray of which the sum ≥ s. If there isn't one, return 0 instead.

For example, given the array [2,3,1,2,4,3] and s = 7,
the subarray [4,3] has the minimal length under the problem constraint.

click to show more practice.
More practice:

If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).

*/

import java.util.*;

public class MinimumSizeSubarraySum {
	public static int minSubArrayLen(int s, int[] nums) {
        if(nums.length <= 0 || s<=0) return 0;
        int L = nums.length;
        int sum = 0;
        int right = 0, left = 0;
        int res = Integer.MAX_VALUE;
        while(right < L){
            sum += nums[right++];
            while(sum >=s){   // condition: sum >= s not =
                res = Math.min(res, right-left);
                sum -= nums[left++];
            }
        }
        return res == Integer.MAX_VALUE? 0: res;
    }	

	public static void main(String[] args) {
		int[] nums1 = new int[] {2,3, 1, 2, 4, 3};
        System.out.println("Array: ");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
		System.out.println("Enter target: ");
		Scanner reader = new Scanner(System.in);
		int s = reader.nextInt();
		int res = minSubArrayLen(s, nums1);
        System.out.println("results: " + res);
		return;
	}	
}
