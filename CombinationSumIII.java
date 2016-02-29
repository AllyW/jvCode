/*
Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.

Ensure that numbers within the set are sorted in ascending order.

Example 1:

Input: k = 3, n = 7

Output:

[[1,2,4]]


Example 2:

Input: k = 3, n = 9

Output:

[[1,2,6], [1,3,5], [2,3,4]]

*/

import java.io.*;
import java.util.*;

public class CombinationSumIII {
    private static List<List<Integer>> res = new ArrayList<List<Integer>>();
	public static List<List<Integer>> combinationSum3(int k, int n) {
        if( k <= 0 || n <= 0) return res;
        comRe(k, n, 1, 0, new ArrayList<Integer>());
        return res;
    }
    
    public static void comRe(int k, int n, int startn, int sum, List<Integer> a){
        if(a.size() > k) return;
        if(sum > n) return;
        if(a.size() == k && sum == n){
            res.add(new ArrayList<Integer>(a));
        }
        for(int i = startn; i < 10; i++){
            a.add(i);
            comRe(k, n, i+1, sum + i, a);
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
		Scanner reader = new Scanner(System.in); 
		System.out.println("combination sum with given length k and sum n");
		System.out.println("Enter k: ");
		int k = reader.nextInt();
		System.out.println("Enter n: ");
		int n = reader.nextInt();
		List<List<Integer>> r = combinationSum3(k, n);
		System.out.println("results: ");
		dispArray2D(r);
		return;
	}	
}
