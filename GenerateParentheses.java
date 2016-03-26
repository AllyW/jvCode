/*
 Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()" 
*/

import java.io.*;
import java.util.*;

public class GenerateParentheses {
    public static List<String> res = new ArrayList<String>();
	public static List<String> generateParenthesis(int n) {
        if(n <= 0) return res;
        helper(1, 0, 1, "(", n);
        return res;
    }
    
    public static void helper(int left, int right, int L, String s, int n){
        if(right > left) return;
        if(left == n && right == n){
            res.add(s);
            return;
        }
        
        for(int i = L+1; i <= 2*n; i++){
            if(left < n) helper(left+1, right, i, s+"(", n);
            if(right < left){
               helper(left, right+1, i, s+")", n); 
            }
        }
        return;
    }	
	
	public static void main(String[] args) {
		System.out.println("Generate pairs of parenthesis");
		Scanner reader = new Scanner(System.in); 
		System.out.println("Enter a number: ");
		int n = reader.nextInt();
		List<String> res = generateParenthesis(n);
		System.out.println("Results: ");
		for(int i = 0; i < res.size(); i++){
			System.out.print(" " + res.get(i));
		}
		return;
	}	
}
