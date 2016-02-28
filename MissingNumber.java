/*
 Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity? 
*/

import java.util.*;

public class MissingNumber {
	public static int missingNumber(int[] nums) {
        if(nums.length <= 0) return 0;
        int L = nums.length;
        int p = 0;
        int i;
        for(i = 0; i < L; i++){
            while(nums[i] < L && nums[i] != i){
                p = nums[nums[i]];
                nums[nums[i]] = nums[i];
                nums[i] = p;
            }
        }
        for(i =0; i < L; i++){
            if(nums[i] != i) return i;
        }
        return i;
    }
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 4, 2, 3};
        System.out.println("Array: ");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
		int res = missingNumber(nums1);
        System.out.println("Missing number: " + res);
		return;
	}	
}
