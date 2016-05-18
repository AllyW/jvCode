/*
 Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:

    Elements in a subset must be in non-descending order.
    The solution set must not contain duplicate subsets.

For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/

import java.util.*;

public class SubsetsII {
    public static List<List<Integer>> res = new ArrayList<>();
	public static List<List<Integer>> subsetsWithDup(int[] nums) {
        if(nums.length <= 0) return new ArrayList<>();
        Arrays.sort(nums);
        subSetRe(nums, 0, new ArrayList<>());
        return res;
    }
    
    public static void subSetRe(int[] nums, int pos, ArrayList<Integer> a){
        if(pos <= nums.length){
            res.add(new ArrayList<>(a));
        };
        for(int i = pos; i < nums.length; i++){
            if(i > pos && nums[i] == nums[i-1]) continue;
            a.add(nums[i]);
            subSetRe(nums, i+1, a);
            a.remove(a.size()-1);
        }
        return;
    }

	public static void main(String[] args) {
		int[] nums = new int[] {1,4,4,5,7};
		int val = 3;
		for(int i=0; i < nums.length; i++){
			System.out.print(nums[i] + " ");
		}
		List<List<Integer>> res = subsetsWithDup(nums);
		System.out.println();
        System.out.println("Subsets: ");
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
		return;
	}	
}
