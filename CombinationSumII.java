/*
 Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

Each number in C may only be used once in the combination.

Note:

    All numbers (including target) will be positive integers.
    Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
    The solution set must not contain duplicate combinations.

For example, given candidate set 10,1,2,7,6,1,5 and target 8,
A solution set is:
[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6] 
*/

import java.io.*;
import java.util.*;

public class CombinationSumII {
    private static List<List<Integer>> res = new ArrayList<List<Integer>>();
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(candidates.length <= 0) return res;
        Arrays.sort(candidates);
        int L = candidates.length;
        comSumRe(candidates, L, 0, target, new ArrayList<Integer>());
        return res;
    }    

    public static void comSumRe(int[] candidates, int L, int pos, int target, List<Integer> a){
        if(target < 0) return;
        if(target == 0){
            res.add(new ArrayList<Integer>(a));
            return;
        }
        for(int i = pos; i < candidates.length; i++){
            if(i > pos && candidates[i-1] == candidates[i]) continue;
            a.add(candidates[i]);
            comSumRe(candidates, L, i+1, target-candidates[i], a);
            a.remove(a.size()-1);
        }
        return;
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
		int[] can = new int[]{2, 2, 4, 5};
		System.out.println("combination sum n, each number used only once");
		List<List<Integer>> r = combinationSum(can, 9);
		System.out.println("results: ");
		dispArray2D(r);
		return;
	}	
}
