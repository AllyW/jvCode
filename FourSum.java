/*
Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:

    Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
    The solution set must not contain duplicate quadruplets.

    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)

*/

import java.util.*;

public class FourSum{
	public static List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums.length <= 0) return res;
        Arrays.sort(nums);
        int L = nums.length;
        for(int i = 0; i < L-3; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            for(int j = i+1; j < L-2; j++){
                if(j > i+1 && nums[j] == nums[j-1]) continue;
                int l = j+1;
                int r = L-1;
                while(l < r){
                    int sum = nums[i] + nums[j] + nums[l] + nums[r];
                    if(sum == target){
                        List<Integer> a = new ArrayList<Integer>();
                        a.add(nums[i]);
                        a.add(nums[j]);
                        a.add(nums[l]);
                        a.add(nums[r]);
                        res.add(a);
                        l++;
                        r--;
                        while(l < r && nums[l] == nums[l-1]) l++;
                        while(l < r && nums[r] == nums[r+1]) r--;
                    }else if(sum < target){
                        l++;
                    }else{
                        r--;
                    }
                    
                }
            }
        }
        return res;
        
    }	
	
	
	public static void dispArray2D(List<List<Integer>> res){
		for(int i = 0; i < res.size(); i++){
			for(int j = 0; j < res.get(i).size(); j++){
				System.out.print(res.get(i).get(j) + " ");   // note: res[i][j]
			}
			System.out.println();
		}
	}

	public static void main(String[] args) {
		int[] nums1 = new int[] {-3, -2,-1, 0, 0, 0, 0, 1, 2, 3};
		List<List<Integer>> res = fourSum(nums1, 0);
        System.out.println("Array:");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
        System.out.println("Target: " + 0);
        System.out.println("Results: ");
		dispArray2D(res);
		return;
	}	
}
