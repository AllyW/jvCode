/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Determine if you are able to reach the last index.

For example:
A = [2,3,1,1,4], return true.

A = [3,2,1,0,4], return false. 
*/

import java.io.*;
import java.util.*;

public class JumpGame {
	public static boolean canJump(int[] nums) {
        int maxL = 0;
        for(int i = 0; i < nums.length; i++){
            if(maxL < i) return false;
            maxL = Math.max(nums[i] + i, maxL);
        }
        return true;
    }
	
	public static void main(String[] args) {
		int[] can = new int[]{2, 3, 1, 1, 4};
		for(int i=0; i < can.length; i++){
			System.out.print(can[i] + " ");
		}
		System.out.println();
		boolean r = canJump(can);
		System.out.println("can jump: " + r);
		return;
	}	
}
