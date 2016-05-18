/*
 Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].

Note:

    Each element in the result must be unique.
    The result can be in any order.

*/

import java.util.*;

public class IntersectionofTwoArrays {
	public static int[] intersection(int[] nums1, int[] nums2) {
        HashSet<Integer> hs = new HashSet<>();
        HashSet<Integer> res = new HashSet<>();
        for(int i = 0; i < nums1.length; i++){
            hs.add(nums1[i]);
        }
        for(int i = 0; i < nums2.length; i++){
            if(hs.contains(nums2[i])){
                res.add(nums2[i]);
            }
        }
        int[] result = new int[res.size()];
        int j = 0;
        for(int i : res){
            result[j++] = i;
        }
        return result;
        
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {1, 3, 4, 5, 7};
		int[] nums2 = new int[] {1,2,7,31,33};		
		int[] res = intersection(nums1, nums2);
        System.out.println("Array 1:");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
        System.out.println("Array 2:");
		for(int i=0; i < nums2.length; i++){
			System.out.print(nums2[i] + " ");
		}
        System.out.println();
        System.out.println("Intersection:");
		for(int i=0; i < res.length; i++){
			System.out.print(res[i] + " ");
		}
		return;
	}	
}
