/*
Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the difference between i and j is at most k. 
*/

import java.io.*;
import java.util.*;

public class ContainsDuplicateII {
	public static boolean containsNearbyDuplicate(int[] nums, int k) {
        if(k <=0) return false;
        if(nums.length <= 1) return false;
        HashSet<Integer> hs = new HashSet<Integer>();
        int l = 0;
        for(int i = 0; i < nums.length; i++){
            if(!hs.add(nums[i])) return true;
            if(l < k){
                l++;
            }else{
                hs.remove(nums[i-k]);
            }
            
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
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		int[] nums = new int[]{1, 2, 5, 8, 7, 3, 5, 0};
		boolean res = containsNearbyDuplicate(nums, n);
		System.out.println("array:");
		dispAr(nums);
		System.out.println("contains duplicate within " + n + "? " + res);
		return;
	}	
}
