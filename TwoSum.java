/*
Given an array of integers, return indices of the two numbers such that they add up to a specific target.

You may assume that each input would have exactly one solution.

Example:

Given nums = [2, 7, 11, 15], target = 9,

Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1].

UPDATE (2016/2/13):
The return format had been changed to zero-based indices. Please read the above updated description carefully. 
*/

import java.util.*;

public class TwoSum {
	public static int[] twoSum(int[] nums, int target) {
        int[] res = new int[2];
        int L = nums.length;
        Map<Integer, Integer> hp = new HashMap<Integer, Integer>();
        for(int i = 0; i < L; i++){
            
            if( hp.containsKey(nums[i])){
                res[0] = i;
                res[1] = hp.get(nums[i]);
                return res;
            }
            hp.put(target - nums[i], i);
        }
        return res;
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {2, 3, 5, 12, 17, 30};
		int n = 35;
		int[] res = twoSum(nums1, n);
        System.out.println("Array: ");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
        System.out.println("Indices for " + n + ": " + res[0] + ", " + res[1]);
		return;
	}	
}
