/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k. 
*/

import java.io.*;
import java.util.*;

public class ContainsDuplicateIII {
	public static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        if (k < 1 || t < 0) return false;
		Map<Long, Long> map = new java.util.LinkedHashMap<>();
	    for (int i = 0; i < nums.length; i++) {
		    long j = t == 0 ? (long) nums[i] - Integer.MIN_VALUE : (((long) nums[i] - Integer.MIN_VALUE) / t);
			if (map.containsKey(j)){
				return true;
	        }else if(map.containsKey(j - 1) && Math.abs(map.get(j - 1) - nums[i]) <= t){
		        return true;
	        }else if(map.containsKey(j + 1) && Math.abs(map.get(j + 1) - nums[i]) <= t) {
		        return true;
	        }
		    if (map.keySet().size() == k) map.remove(map.keySet().iterator().next());
			map.put(j, (long) nums[i]);
	    }
		return false;
	}	
	
	public static void dispAr(int[] nums) {
        for(int i = 0;i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
        return;
    }

	public static void main(String[] args) {
		int[] nums = new int[]{-1, 2147483647};
		System.out.println("Math.MIN_VALUE = " + Integer.MIN_VALUE);
		System.out.println("Math.abs(-2147483648):" + Math.abs(-2147483648)); // !!
		boolean res = containsNearbyAlmostDuplicate(nums, 1, 2147483647);
		System.out.println("array:");
		dispAr(nums);
		System.out.println("results:" + res);
		return;
	}	
}
