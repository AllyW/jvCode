/*
Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].

Note:

    You must do this in-place without making a copy of the array.
    Minimize the total number of operations.

*/

import java.io.*;
import java.util.*;

public class MoveZeroes {
	public static void moveZeroes(int[] nums) {
        int L = nums.length;
        if(L <=1) return;
        int j = 0;
        for(int i = 0;i < L;){
            while(i < L && nums[i] == 0) i++;  // i<L
            if( i < L && i != j){  // i < L && i != j, swap, else, continue
                nums[j] = nums[i];
                nums[i] = 0;
            }
            j++;
            i++;
        }
        return;
    }

	public static void dispAr(int[] nums) {
        for(int i = 0;i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
        return;
    }
	
	public static void main(String[] args) {
		int[] nums1 = new int[] {0, 1, 0, 12, 3};
		int[] nums2 = new int[] {1, 1, 0, 12, 3};
		int[] nums3 = new int[] {0, 0, 0};
		System.out.println("Array 1:");
		dispAr(nums1);
		System.out.println("Result:");
		moveZeroes(nums1);
		dispAr(nums1);
		System.out.println("Array 2:");
		dispAr(nums2);
		System.out.println("Result:");
		moveZeroes(nums2);
		dispAr(nums2);
		System.out.println("Array 3:");
		dispAr(nums3);
		System.out.println("Result:");
		moveZeroes(nums3);
		dispAr(nums3);
		return;
	}	
}
