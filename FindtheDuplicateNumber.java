/*
 Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive), prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.

Note:

    You must not modify the array (assume the array is read only).
    You must use only constant, O(1) extra space.
    Your runtime complexity should be less than O(n2).
    There is only one duplicate number in the array, but it could be repeated more than once.

*/

import java.util.*;

public class FindtheDuplicateNumber {
	public static int findDuplicate(int[] nums) {
        if(nums.length <= 0) return -1;
        int mid = 0;
        int start = 1; 
        int end = nums.length-1;
        while(start < end){
            int m = start + (end - start)/2;
            int count = 0; 
            for(int num : nums){
                if(num <= m) count++;
            }
            if(count > m){
                end = m;
            }else{
                start = m + 1;
            }
        }
        return start;
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 4, 3, 3, 2, 5};
		int res = findDuplicate(nums1);
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
		System.out.println();
        System.out.println("duplicate number: " + res);
		return;
	}	
}
