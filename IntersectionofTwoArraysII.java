/*
 Given two arrays, write a function to compute their intersection.

Example:
Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2, 2].

Note:

    Each element in the result should appear as many times as it shows in both arrays.
    The result can be in any order.

Follow up:

    What if the given array is already sorted? How would you optimize your algorithm?
    What if nums1's size is small compared to num2's size? Which algorithm is better?
    What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?

*/

import java.util.*;

public class IntersectionofTwoArraysII {
	public static int[] intersection(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int M = nums1.length;
        int N = nums2.length;
        List<Integer> r = new ArrayList<Integer>();
        int i = 0;
        int j = 0;
        while( i < M && j < N){
            while(i < M && j < N && nums1[i] < nums2[j]) i++;
            while(i < M && j < N && nums1[i] > nums2[j]) j++;
            while(i < M && j < N && nums1[i] == nums2[j]){
                r.add(nums1[i]);
                i++;
                j++;
            }
        }
        int L = r.size();
        int[] res = new int[L];
        for(i = 0; i < L; i++){
            res[i] = r.get(i);
        }
        return res;        
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {1,1,2, 3, 4,4,4,4, 5, 7};
		int[] nums2 = new int[] {1,2,4,4,4,7,3,3, 4};		
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
