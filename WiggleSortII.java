/*
 Given an unsorted array nums, reorder it such that nums[0] < nums[1] > nums[2] < nums[3]....

Example:
(1) Given nums = [1, 5, 1, 1, 6, 4], one possible answer is [1, 4, 1, 5, 1, 6].
(2) Given nums = [1, 3, 2, 2, 3, 1], one possible answer is [2, 3, 1, 3, 1, 2].

Note:
You may assume all input has valid answer.

Follow Up:
Can you do it in O(n) time and/or in-place with O(1) extra space? 
*/

import java.io.*;
import java.util.*;

public class WiggleSortII {
	public static void wiggleSort(int[] nums) {
        if(nums.length <= 0) return;
        int L = nums.length;
        Arrays.sort(nums);
        int[] res = new int[L];
        int mid = L%2 ==0 ? L/2-1: L/2;
        int index = 0;
        for(int i = 0; i <= mid; i++){
            res[index] = nums[mid-i];
            if(index+1 < L) res[index+1] = nums[L-1-i];
            index += 2;
        }
        for(int i = 0; i < L; i++){
            nums[i] = res[i];
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
		int[] nums = new int[]{1, 2, 5, 8, 7, 3, 5, 0};
		System.out.println("array before:");
		dispAr(nums);
		wiggleSort(nums);
		System.out.println("array after:");
		dispAr(nums);
		int[] nums2 = new int[]{4, 5, 5, 6};
		System.out.println("array before:");
		dispAr(nums2);
		wiggleSort(nums2);
		System.out.println("array after:");
		dispAr(nums2);
		return;
	}	
}
