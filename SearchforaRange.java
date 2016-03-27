/*
Given a sorted array of integers, find the starting and ending position of a given target value.

Your algorithm's runtime complexity must be in the order of O(log n).

If the target is not found in the array, return [-1, -1].

For example,
Given [5, 7, 7, 8, 8, 10] and target value 8,
return [3, 4]. 
*/

import java.util.*;

public class SearchforaRange {
	public static int[] searchRange(int[] nums, int target) {
        if(nums.length <= 0) return new int[0];
        int[] res = new int[2];
        res[0] = findLeft(nums, target);
        res[1] = findRight(nums, target);
        return res;
    }
    
    public static int findLeft(int[] nums, int target){
        int l = 0; 
        int r = nums.length-1;
        int idx = -1;
        int mid = 0;
        while(l <= r){
            mid = l + (r-l)/2;
            if(nums[mid] >= target){
                r = mid-1;
            }else{
                l = mid+1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }
    
    public static int findRight(int[] nums, int target){
        int idx = -1;
        int l = 0; 
        int r = nums.length-1;
        int mid = 0;
        while(l <= r){
            mid = l + (r-l)/2;
            if(nums[mid] > target){
                r = mid-1;
            }else{
                l = mid+1;
            }
            if(nums[mid] == target) idx = mid;
        }
        return idx;
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {2,2};
		int n = 3;
		int[] res = searchRange(nums1, n);
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
        System.out.println("Ranges for " + n + ": ");
		for(int i=0; i < res.length; i++){
			System.out.print(res[i] + " ");
		}
		return;
	}	
}
