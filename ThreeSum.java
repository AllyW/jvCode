/*
Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:

    Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
    The solution set must not contain duplicate triplets.

    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

*/

import java.util.*;

public class ThreeSum{
	public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(nums.length <= 2) return res;
        int L = nums.length;
        Arrays.sort(nums);
        for(int i = 0; i < L-2; i++){
            if(i > 0 && nums[i] == nums[i-1]) continue;
            int left = i+1;
            int right = L-1;
            while(left < right){
                if(nums[left] + nums[right] > -nums[i]){
                    right--;
                }else if(nums[left] + nums[right] < -nums[i]){
                    left++;
                }else{
                    List<Integer> a = new ArrayList<Integer>();
                    a.add(nums[i]);
                    a.add(nums[left]);
                    a.add(nums[right]);
                    res.add(a);
                    left++;
                    right--;
                    while(left < right && nums[left] == nums[left-1]) left++;
                    while(left < right && nums[right] == nums[right+1]) right--;
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
		int[] nums1 = new int[] {-2,-1, 0, 0, 0, 0, 1, 2, 3};
		List<List<Integer>> res = threeSum(nums1);
        System.out.println("Array:");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
        System.out.println("Results: ");
		dispArray2D(res);
		return;
	}	
}
