/*
Given an array S of n integers, find three integers in S such that the sum is closest to a given number, target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

    For example, given array S = {-1 2 1 -4}, and target = 1.

    The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

*/

import java.util.*;

public class ThreeSumClosest{
	public static int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int delta = Integer.MAX_VALUE;
        int L = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < L-2; i++){
            int l = i + 1; 
            int r = L-1;
            while(l < r){
                int t = nums[i] + nums[l] + nums[r];
                int d = t - target;
                if(Math.abs(d) < delta){
                    delta = Math.abs(d);
                    sum = t;
                }
                if(d > 0){
                    r--;
                }else if(d < 0){
                    l++;
                }else{
                    return sum;
                }
            }
        }
        return sum;
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {-2,-1, 4, 0, 6, 0, 6, 2, 9};
		int res = threeSumClosest(nums1, 10);
        System.out.println("Array:");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
        System.out.println("Target sum: " + 10);
        System.out.println("Closest sum: " + res);
		return;
	}	
}
