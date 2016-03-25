/*
Given a string S, you are allowed to convert it to a palindrome by adding characters in front of it. Find and return the shortest palindrome you can find by performing this transformation.

For example:

Given "aacecaaa", return "aaacecaaa".

Given "abcd", return "dcbabcd".
*/
import java.util.*;

public class ShortestPalindrome {
	public static String shortestPalindrome(String s) {
        int adds = 0; 
        if(s.length() <= 1) return s;
        int L = s.length();
        char[] sc = s.toCharArray();
        boolean pal = true;
        while(adds < L){
            for(int i = 0; i <= (L - adds)/2; i++){
                if(sc[i] != sc[L-1-adds-i]){
                    adds++;
                    pal = false;
                    break;
                }
            }
            if(pal == true){
                String suffix = s.substring(L-adds);
                return new StringBuffer(suffix).reverse().toString() + s;
                
            }
            pal = true;
        }
        return s+s;
    }	
	public static void main(String[] args) {
		String s = "abcd";
		String res = shortestPalindrome(s);
		System.out.println("Source string: " + s);
		System.out.println("Shortest pal string: " + res);
		return;
	}	
}
