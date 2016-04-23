/*
*/

import java.io.*;
import java.util.*;

public class Combinations {
	private static List<List<Integer>> result = new ArrayList<List<Integer>>();
	public static List<List<Integer>> combine(int n, int k) {
        if(n < k) return result;
        List<Integer> r = new ArrayList<>();
        comRe(n, k, 1, r);
        return result;
	}    
	
	public static void comRe(int n, int k, int startSearchPos, List<Integer> r){
        int m = r.size();
        if(m == k){
            result.add(new ArrayList<Integer>(r));
            return;
        }
        for(int i = startSearchPos; i <= (n-k+1+m); i++){
            r.add(i);
            comRe(n, k, i+1, r);
            r.remove(r.size()-1);
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
		System.out.println("Enter k: ");
		int k = reader.nextInt();
		System.out.println("Enter n (n>k): ");
		int n = reader.nextInt();
		System.out.println("combinations using " + k + " numbers from 1 to " + n);
		List<List<Integer>> r = combine(n, k);
		System.out.println("results: ");
		dispArray2D(r);
		return;
	}	
}
