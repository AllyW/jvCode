/*
 Given an array of n integers where n > 1, nums, return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

Solve it without division and in O(n).

For example, given [1,2,3,4], return [24,12,8,6].

Follow up:
Could you solve it with constant space complexity? (Note: The output array does not count as extra space for the purpose of space complexity analysis.)
*/

import java.util.*;

public class ProductofArrayExceptSelf {
	public static int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        if(nums.length <= 0) return res;
        int L = nums.length;
        int lp = 1, rp = 1;
        res[0] = 1;
        for(int i = 1; i < L; i++){
            lp = lp * nums[i-1];
            res[i] = lp;
        }
        for(int i = L-2; i >= 0; i--){
            rp = rp * nums[i+1];
            res[i] *= rp;
        }
        return res;
        
    }
	public static void main(String[] args) {
		int[] nums1 = new int[] {1,2, 3, 4};
        System.out.println("Array: ");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
		int[] res = productExceptSelf(nums1);
        System.out.println("Products: ");
		for(int i=0; i < res.length; i++){
			System.out.print(res[i] + " ");
		}
		return;
	}	
}
