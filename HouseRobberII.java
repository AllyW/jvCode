/*
Note: This is an extension of House Robber.

After robbing those houses on that street, the thief has found himself a new place for his thievery so that he will not get too much attention. This time, all houses at this place are arranged in a circle. That means the first house is the neighbor of the last one. Meanwhile, the security system for these houses remain the same as for those in the previous street.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.
*/

import java.util.*;

public class HouseRobberII {
	public static int rob(int[] nums) {
        if(nums.length <= 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) {
            return nums[0] > nums[1]? nums[0] : nums[1];
        }
        int L = nums.length;
        int pre1 = 0, prepre1 = 0, cur1 = 0;
        for( int i = 0; i < L-1; i++){
            cur1 = Math.max( prepre1 + nums[i], pre1);
            prepre1 = pre1;
            pre1 = cur1;
        }
        int pre2 = 0, prepre2 = 0, cur2 = 0;
        for( int i = 1; i < L; i++){
            cur2 = Math.max( prepre2 + nums[i], pre2);
            prepre2 = pre2;
            pre2 = cur2;
        }
        return cur2 > cur1 ? cur2 : cur1;
    }	

	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 4, 2, 3, 6, 9, 7};
        System.out.println("Array: ");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
		int res = rob(nums1);
        System.out.println("Maximum profit: " + res);
		return;
	}	
}
