/*
A peak element is an element that is greater than its neighbors.

Given an input array where num[i] ≠ num[i+1], find a peak element and return its index.

The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

You may imagine that num[-1] = num[n] = -∞.

For example, in array [1, 2, 3, 1], 3 is a peak element and your function should return the index number 2.
*/

import java.util.*;

public class FindPeakElement {
	public static int findPeakElement(int[] nums) {
        if(nums.length == 0) return 0;
        int N = nums.length;
        if(N == 1) return 0;
        if(N == 2) return nums[0]> nums[1] ? 0:1;
        int start = 0;
        int end = N - 1;
        int mid = 0;
        while(start <= end) {
            mid = start + (end - start) / 2;
            if((mid == 0 || nums[mid-1] < nums[mid]) && (mid == N-1 || nums[mid+1] < nums[mid])){ return mid;
            }
            if(mid > 0 && nums[mid] < nums[mid-1]){
                end = mid - 1;
            }else if( mid < N-1 && nums[mid+1] > nums[mid]){
                start = mid + 1;
            }
        }
        return mid;
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {6, 7, 9, 1, 2, 5};
		int res = findPeakElement(nums1);
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
		System.out.println();
        System.out.println("peeking number index: [" + res + "], number: " + nums1[res]);
		return;
	}	
}
