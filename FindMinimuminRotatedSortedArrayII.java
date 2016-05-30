/*


    Follow up for "Find Minimum in Rotated Sorted Array":
    What if duplicates are allowed?

    Would this affect the run-time complexity? How and why?

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

The array may contain duplicates.
*/

import java.util.*;

public class FindMinimuminRotatedSortedArrayII {
	public static int findMin(int[] nums) {
        if(nums.length == 0) return 0;
        int N = nums.length;
        int start = 0; 
        int end = N-1;
        while(start < end && nums[start] >= nums[end]) {
            int mid = start + (end - start) / 2; 
            if(nums[mid] > nums[end]){
                start = mid + 1;
            }
            else if(nums[mid] < nums[start]){
                end = mid;
            }
            else{
                start++;
            }
        } 
        return nums[start];
    }	

	public static void main(String[] args) {
		int[] nums1 = new int[] {6, 6, 9, 1, 2, 6};
		int res = findMin(nums1);
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
		System.out.println();
        System.out.println("minimum number: " + res);
		return;
	}	
}
