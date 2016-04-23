/*
*/

import java.io.*;
import java.util.*;

public class Combinations {
    private static List<List<Integer>> res = new ArrayList<List<Integer>>();
	public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        if(n < k) return result;
        List<Integer> r;
        comRe(n, k, 1, r, r);
        return result; 
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
		return;
	}	
}
