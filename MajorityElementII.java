/*
Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times. The algorithm should run in linear time and in O(1) space.

Hint:

    How many majority elements could it possibly have?
    Do you have a better hint? Suggest it!

*/

import java.util.*;

public class MajorityElementII {
	public static List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList<>();
        if(nums.length <= 0) return res;
        
        int[] count = new int[2];
        int[] cand = new int[2];
        count[0] = 0;
        count[1] = 0;
        cand[0] = 0;
        cand[1] = 1;
        for(int i = 0; i < nums.length; i++){
            if(count[0] == 0 && nums[i] != cand[1]){
                cand[0] = nums[i];
                count[0] = 1;
            }else if(count[1] == 0 && nums[i] != cand[0]){
                cand[1] = nums[i];
                count[1] = 1;
            }else if(nums[i] == cand[0]){
                count[0]++;
            }else if(nums[i] == cand[1]){
                count[1]++;
            }else{
                count[0]--;
                count[1]--;
            }
        }
        count[0] = 0;
        count[1] = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == cand[0]) count[0]++;
            if(nums[i] == cand[1]) count[1]++;
        }
        if(count[0] > nums.length/3) res.add(cand[0]);
        if(count[1] > nums.length/3 && !res.contains(cand[1])) res.add(cand[1]);
        return res;
        
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 2, 2, 3, 2, 1, 1, 3};
		List<Integer> res = majorityElement(nums1);
        System.out.print("Array: ");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
        System.out.print("Majority elements are: ");
		for(int i=0; i < res.size(); i++){
			System.out.print(res.get(i) + " ");
		}
        System.out.println();
		int[] nums2 = new int[] {8,8,7,7,7};
		List<Integer> res2 = majorityElement(nums2);
        System.out.print("Array: ");
		for(int i=0; i < nums2.length; i++){
			System.out.print(nums2[i] + " ");
		}
        System.out.println();
        System.out.print("Majority elements are: ");
		for(int i=0; i < res2.size(); i++){
			System.out.print(res2.get(i) + " ");
		}
        System.out.println();
		return;
	}	
}
