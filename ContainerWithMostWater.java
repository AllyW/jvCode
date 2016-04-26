/*
Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container. 
*/

import java.util.*;

public class ContainerWithMostWater {
	public static int maxArea(int[] height) {
        if(height.length <= 0) return 0;
        int r = height.length - 1;
        int l = 0;
        int res = 0;
        while(l < r){
            if(height[l] >= height[r]){
                res = Math.max(res, (r-l) * height[r]);
                r--;
            }else{
                res = Math.max(res, (r-l)*height[l]);
                l++;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		System.out.print("Array:");
		int[] nums = new int[] {1,2,4, 2, 7, 8, 2, 6};
		int res = maxArea(nums);
		for(int i=0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		System.out.println();
        System.out.println("Max area: " + res);
		return;
	}	
}
