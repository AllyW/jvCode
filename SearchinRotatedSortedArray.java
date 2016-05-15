/*
Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
*/

import java.util.*;

public class SearchinRotatedSortedArray {
	public static int search(int[] nums, int target) {
        if(nums.length <= 0) return -1;
        int L = nums.length;
        int l = 0; 
        int r = L-1;
        int mid = 0;
        while(l < r){
            mid = l + (r-l)/2;
            if(nums[mid] == target) return mid;
            if(nums[mid] >= nums[l]){
                if(nums[mid] > target && target>=nums[l]){
                    r = mid-1;
                }else{
                    l = mid+1;
                }
            }else if( nums[mid] <= nums[r]){
                if( nums[mid] < target && target <= nums[r]){
                    l = mid+1;
                }else{
                    r = mid-1;
                }
            }
        }
        if( l < L && l >= 0 && nums[l] == target){
            return l;
        }else if( r < L && r >= 0 && nums[r] == target){
            return r;
        }else{
            return -1;
        }
    }

	public static void main(String[] args) {
		int[] nums = new int[] {11,12,13,3, 5, 7, 10};
		int val = 3;
		for(int i=0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		int res = search(nums, val);
		System.out.println();
        System.out.println("Index of " + val + ": " + res);
		return;
	}	
}
