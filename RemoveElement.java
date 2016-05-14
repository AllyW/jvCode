/*
Given an array and a value, remove all instances of that value in place and return the new length.

Do not allocate extra space for another array, you must do this in place with constant memory.

The order of elements can be changed. It doesn't matter what you leave beyond the new length.

Example:
Given input array nums = [3,2,2,3], val = 3

Your function should return length = 2, with the first two elements of nums being 2.
*/

import java.util.*;

public class RemoveElement {
	public static int removeElement(int[] nums, int val) {
        int j = 0;
        for(int i = 0; i < nums.length;){
            while( i < nums.length && nums[i] == val) i++;
            if(i == nums.length) break;
            nums[j++] = nums[i++];
        }
        return j;
    }

	public static void main(String[] args) {
		int[] nums = new int[] {3,2,2,3};
		int val = 3;
		for(int i=0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		int res = removeElement(nums, val);
		System.out.println();
        System.out.println("Number of " + val + ": " + res);
		return;
	}	
}
