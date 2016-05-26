/*
 Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1]. 
*/

import java.util.*;

public class PermutationsII {
	public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> a = new ArrayList<Integer>();
        a.add(nums[0]);
        res.add(a);
        for(int i = 1; i < nums.length;i++){
            List<List<Integer>> temp = new ArrayList<List<Integer>>();
            for(List<Integer> l : res){
                int n = l.size();
                for(int j = 0; j <= n; j++){
                    if(j > 0 && nums[i] == l.get(j-1)) break;
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
		int[] nums1 = new int[] {7, 3, 3};
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
