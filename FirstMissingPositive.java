/*
 Given an unsorted integer array, find the first missing positive integer.

For example,
Given [1,2,0] return 3,
and [3,4,-1,1] return 2.

Your algorithm should run in O(n) time and uses constant space. 
*/

import java.util.*;

public class FirstMissingPositive {
	public static int firstMissingPositive(int[] nums) {
        if(nums.length <= 0) return 1;
        int a = 0;
        for(int i = 0; i < nums.length ; i++){
            a = nums[i];
            while(a > 0 && a < nums.length && nums[a-1] != a){  
                int temp = nums[a-1];
                nums[a-1] = nums[i];
                nums[i] = temp;
                a = nums[i];
            }
        }
        for(int i = 0; i < nums.length ; i++){
            if(nums[i] != i+1) return i+1;
        }
        return nums.length+1;
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {7, 3, 4, 1, 6, 5};
		int res = firstMissingPositive(nums1);
        System.out.println("Array:");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
        System.out.println("Missing number:" + res);
		return;
	}	
}
