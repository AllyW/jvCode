/*
 Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"]. 
*/

import java.util.*;
public class SummaryRanges {
	public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<String>();
        if(nums.length<= 0) return res;
        if(nums.length == 1){
            res.add(nums[0] + "");
            return res;
        }
        int sp = 0;
        int L = nums.length;
        for(int i = 1; i < L; i++){
            if(nums[i] == nums[i-1] + 1){
                if(i == L-1){
                    res.add(nums[sp] + "->" + nums[L-1]);
                    return res;
                }
            }else{
                if (i == sp + 1) {
                    res.add(nums[sp] + "");
                }else{
                    res.add(nums[sp] + "->" + nums[i-1]);
                }
                sp = i;
            }
            if(sp == L-1) res.add(nums[L-1]+"");
        }
        
        return res;
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 3};
		List<String> res = summaryRanges(nums1);
        System.out.println("Array: ");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println("");
        System.out.println("Ranges: ");
		for(int i=0; i < res.size(); i++){
			System.out.print(res.get(i) + " "); // list.get(), does not support index[]
		}
        System.out.println("");
		int[] nums2 = new int[] {1,2,3,33};
		res = summaryRanges(nums2);
        System.out.println("Array: ");
		for(int i=0; i < nums2.length; i++){
			System.out.print(nums2[i] + " ");
		}
        System.out.println("");
        System.out.println("Ranges: ");
		for(int i=0; i < res.size(); i++){
			System.out.print(res.get(i) + " ");
		}

        System.out.println("");
		int[] nums3 = new int[] {1,4,33};
		res = summaryRanges(nums3);
        System.out.println("Array: ");
		for(int i=0; i < nums3.length; i++){
			System.out.print(nums3[i] + " ");
		}
        System.out.println("");
        System.out.println("Ranges: ");
		for(int i=0; i < res.size(); i++){
			System.out.print(res.get(i) + " ");
		}

		return;
	}	
}
