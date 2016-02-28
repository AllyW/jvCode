/*
 Given an array of numbers nums, in which exactly two elements appear only once and all the other elements appear exactly twice. Find the two elements that appear only once.

For example:

Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].

Note:

    The order of the result is not important. So in the above example, [5, 3] is also correct.
    Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 
*/

import java.io.*;
import java.util.*;

public class SingleNumberIII {
	public static int[] singleNumber(int[] nums) {
        int L = nums.length;
        Set<Integer> hp = new HashSet<Integer>();
        int[] r = new int[2];
        if(nums.length<=0) return r;
        for(int i = 0; i < L; i++){
            if(hp.contains(nums[i])){
                hp.remove(nums[i]);
            }else{
                hp.add(nums[i]);
            }
        }
        Object[] test = hp.toArray();
        r[0]=(int)test[0];
        r[1]=(int)test[1];
        return r;
    } 

	public static int[] singleNumber2(int[] nums) {
        int L = nums.length;
        int[] res = new int[2];
        if(nums.length<=0) return res;
        int r = 0;
        for(int i = 0; i < L; i++){
            r ^= nums[i];
        }
		System.out.println("r = " + r);
		// find the lowest 1 bit in r
		// method 1
         for(int i = 0; i < 32; i++){
             if( ((r>>i) & 1) == 1){
                 r = ((r>>i) & 1) << i;
                 break;
             }
         }
		 // method 2
        //r &= -r;
		// method 3
	    //r =	r & (~(r - 1));
		System.out.println("r = " + r);
        for(int i = 0; i < L; i++){
            if((nums[i] & r) == 0){
                res[0] ^= nums[i];
            }else{
                res[1] ^= nums[i];
            }
        }

        return res;
    }

	public static void dispAr(int[] nums) {
        for(int i = 0;i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
        return;
    }
	
	public static void main(String[] args) {
		int[] nums = new int[]{1, 2, 1, 3, 2, 5 };
		System.out.println("Single number using method 1:  ");
		int[] r = singleNumber(nums);
		dispAr(r);
		System.out.println("Single number using method 2:  ");
		r = singleNumber2(nums);
		dispAr(r);
		return;
	}	
}
