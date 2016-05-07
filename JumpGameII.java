/*
 Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
*/

import java.io.*;
import java.util.*;

public class JumpGameII {
	public static int jump(int[] nums) {
        int maxL = 0;
        int reach = 0;
        int step = 0;
        for(int i = 0; i < nums.length-1; i++){
            reach = Math.max(reach, i+nums[i]);
            if( i== maxL){
                step++;
                maxL = reach;
            }
        }
        return step;
    }

	public static void main(String[] args) {
		int[] can = new int[]{2, 3, 1, 1, 4};
		for(int i=0; i < can.length; i++){
			System.out.print(can[i] + " ");
		}
		System.out.println();
		int r = jump(can);
		System.out.println("minimum jump: " + r);
		return;
	}	
}
