/*
Given an array of integers, find if the array contains any duplicates. Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct. 
*/

import java.io.*;
import java.util.*;

public class ContainsDuplicate {
	public static boolean containsDuplicate(int[] nums) {
        if(nums.length <= 0) return false;
        HashSet<Integer> hp = new HashSet<Integer>();
        for(int i=0; i < nums.length; i++){
            if(!hp.add(nums[i])) return true;
        }
        return false;
    }

	public static void dispAr(int[] nums) {
        for(int i = 0;i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
        return;
    }

	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 5, 8, 7, 3, 2, 0};
		boolean res = containsDuplicate(nums);

		System.out.println("array:");
		dispAr(nums);
		System.out.println("contains duplicate? " + res);
		return;
	}	
}
