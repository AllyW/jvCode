/*
 Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1]. 
*/

import java.util.*;

public class Permutations {
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<Integer>();
        a.add(nums[0]);
        res.add(a);
        for(int i = 1; i < nums.length;i++){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(int j = 0; j <= i; j++){
                for(List<Integer> l : res){
                    List<Integer> t = new ArrayList<>(l);
                    t.add(j, nums[i]);
                    temp.add(t);
                }
            }
            res = temp;
        }
        return res;
    }

	public static void main(String[] args) {
		int[] nums1 = new int[] {7, 3, 4};
		List<List<Integer>> res = permute(nums1);
        System.out.println("Array:");
		for(int i=0; i < nums1.length; i++){
			System.out.print(nums1[i] + " ");
		}
        System.out.println();
        System.out.println("Permutations:");
		for(int i = 0; i < res.size(); i++){
			System.out.println(res.get(i));
		}
		return;
	}	
}
