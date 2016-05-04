/*
You are a professional robber planning to rob houses along a street. Each house has a certain amount of money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have security system connected and it will automatically contact the police if two adjacent houses were broken into on the same night.

Given a list of non-negative integers representing the amount of money of each house, determine the maximum amount of money you can rob tonight without alerting the police.

*/

import java.util.*;

public class HouseRobber {
	public static int rob(int[] nums) {
        if(nums.length <= 0) return 0;
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) {
            return nums[0] > nums[1]? nums[0] : nums[1];
        }
        int L = nums.length;
        int pre1 = 0, prepre1 = 0, cur1 = 0;
        for( int i = 0; i < L; i++){
            cur1 = Math.max( prepre1 + nums[i], pre1);
            prepre1 = pre1;
            pre1 = cur1;
        }
        return cur1;
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
